package com.example.demo.dto;

import com.example.demo.commons.dto.BaseRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CarRequest implements BaseRequest {
    @NotEmpty private String brand;
    @NotEmpty private String model;
    @NotEmpty private String plateNum;
    @JsonProperty("personId") private int person;
}
