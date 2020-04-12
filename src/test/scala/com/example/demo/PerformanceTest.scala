package com.example.demo

import java.util.concurrent.ThreadLocalRandom

import com.example.demo.app.dto.{CarRequest, PersonRequest}
import com.fasterxml.jackson.databind.ObjectMapper
import io.gatling.core.Predef._
import io.gatling.core.feeder.FeederBuilder
import io.gatling.core.structure.{ChainBuilder, ScenarioBuilder}
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

import scala.concurrent.duration._
import scala.math._
import scala.util._

class PerformanceTest extends Simulation {

  val mapper = new ObjectMapper()

  val HTTP: HttpProtocolBuilder = http
    .baseUrl(System.getProperty("base_url"))
    .acceptHeader("application/json")

  def randomInt(len: Int): Int = ThreadLocalRandom.current().nextInt(pow(10, len - 1).toInt, pow(10, len).toInt)

  def randomText(n: Int): String = Random.alphanumeric.filter(_.isLetter).take(n).mkString.toLowerCase()

  def toJson(obj: Object): String = mapper.writeValueAsString(obj)

  def postPerson: ChainBuilder = exec(http("Create a person")
    .post("/people")
    .body(StringBody(toJson(new PersonRequest()
      .setName("${name}")
      .setEmail("${email}")
      .setCity("${city}")
      .setStreet("${street}")
      .setNumber("${number}")
    )))
    .asJson
    .check(status is 200)
    .check(jsonPath("$.id").saveAs("personId"))
  )

  def getPerson: ChainBuilder = exec(http("Get a person")
    .get("/people/${personId}")
  )

  def createCar(n: Int): ChainBuilder = exec(http("Create a car")
    .post("/cars")
    .body(StringBody(session => toJson(new CarRequest()
      .setBrand(session("brand").as[String])
      .setModel(session("model").as[String])
      .setPlateNum(session("plateNum").as[String].format(n))
      .setPerson(session("personId").as[Int])
    )))
    .asJson
    .check(status is 200)
  )

  def getPersonCars: ChainBuilder = exec(http("Get person's cars")
    .get("/people/${personId}/cars")
  )

  def feeder: FeederBuilder = Iterator.continually(Map(
    "name" -> randomText(8).capitalize,
    "email" -> s"${randomText(1)}.${randomText(7)}@${randomText(5)}.${randomText(3)}",
    "city" -> randomText(8).capitalize,
    "street" -> s"${randomText(8)} str.".capitalize,
    "number" -> randomInt(3),
    "brand" -> randomText(8).capitalize,
    "model" -> randomText(8).capitalize,
    "plateNum" -> s"${randomText(2)}-${randomInt(3)}%s-${randomText(2)}",
  ))

  def createPersonAndHisCars: ScenarioBuilder = scenario("People").feed(feeder).exec(
    postPerson,
    getPerson,
    createCar(1),
    createCar(2),
    getPersonCars
  )

  setUp(
    createPersonAndHisCars.inject(
      rampConcurrentUsers(1) to 400 during (30 seconds),
      constantConcurrentUsers(400) during (30 seconds)
//      rampUsers(300) during (30 seconds),
//      heavisideUsers(300) during (30 seconds)
  )).protocols(HTTP)
}


