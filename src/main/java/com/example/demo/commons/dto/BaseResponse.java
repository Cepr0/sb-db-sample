package com.example.demo.commons.dto;

import org.springframework.lang.NonNull;

import java.io.Serializable;

public interface BaseResponse <ID extends Serializable> extends Serializable {
    @NonNull ID getId();
}
