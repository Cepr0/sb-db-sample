package com.example.demo.app.dto;

import com.example.demo.app.model.Address;
import com.example.demo.commons.dto.BaseResponse;
import lombok.Data;

@Data
public class PersonResponse implements BaseResponse<Integer> {
    private Integer id;
    private String name;
    private String email;
    private Address address;
}
