package com.example.demo.app.dto;

import com.example.demo.commons.dto.BaseResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CarResponse implements BaseResponse<Integer> {
    private Integer id;
    private String brand;
    private String model;
    private String plateNum;
    @JsonProperty("personId") private int person;
}
