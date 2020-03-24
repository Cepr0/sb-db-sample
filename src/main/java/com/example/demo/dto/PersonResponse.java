package com.example.demo.dto;

import com.example.demo.commons.dto.BaseResponse;
import com.example.demo.model.Address;
import lombok.Data;

@Data
public class PersonResponse implements BaseResponse<Integer> {
    private Integer id;
    private String name;
    private String email;
    private Address address;
}
