package com.example.demo

import io.gatling.core.Predef._
import io.gatling.core.structure.{ChainBuilder, ScenarioBuilder}
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

import scala.concurrent.duration._

class LoadTest extends Simulation {

  val httpProtocol: HttpProtocolBuilder = http.baseUrl("http://localhost:8080")

  object PersonResource {
    val getAll: ChainBuilder = exec(http("Get all").get("/people"))
  }

  object CarResource {
    val getAll: ChainBuilder = exec(http("Get all").get("/cars"))
  }

  val scn: ScenarioBuilder = scenario("Demo Scenario")
    .exec(
      PersonResource.getAll,
      CarResource.getAll
    )

  setUp(scn.inject(
    incrementUsersPerSec(20)
      .times(5)
      .eachLevelLasting(5 seconds)
      .separatedByRampsLasting(5 seconds)
      .startingFrom(100)
  ), scn.inject(
    incrementUsersPerSec(50)
      .times(10)
      .eachLevelLasting(5 seconds)
      .separatedByRampsLasting(5 seconds)
      .startingFrom(100)
  )).protocols(httpProtocol)
    .assertions(global.successfulRequests.percent.is(100))
}