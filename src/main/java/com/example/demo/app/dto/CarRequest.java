package com.example.demo.app.dto;

import com.example.demo.commons.dto.BaseRequest;
import com.example.demo.commons.dto.OnCreate;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CarRequest implements BaseRequest {
    @NotEmpty(groups = OnCreate.class) private String brand;
    @NotEmpty(groups = OnCreate.class) private String model;
    @NotEmpty(groups = OnCreate.class) private String plateNum;
    @JsonProperty("personId") private Integer person;
}
