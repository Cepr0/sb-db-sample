package com.example.demo.dto;

import com.example.demo.commons.dto.BaseRequest;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class PersonRequest implements BaseRequest {
    @NotEmpty private String name;
    @NotEmpty private String email;
    @NotEmpty private String city;
    @NotEmpty private String street;
    @NotEmpty private String number;
}
