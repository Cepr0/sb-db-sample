package com.example.demo.dto;

import com.example.demo.commons.dto.BaseRequest;
import com.example.demo.commons.dto.OnCreate;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class PersonRequest implements BaseRequest {
    @NotEmpty(groups = OnCreate.class) private String name;
    @NotEmpty(groups = OnCreate.class) private String email;
    @NotEmpty(groups = OnCreate.class) private String city;
    @NotEmpty(groups = OnCreate.class) private String street;
    @NotEmpty(groups = OnCreate.class) private String number;
}
