package com.example.demo.commons.crud;

import com.example.demo.commons.dto.BaseRequest;
import com.example.demo.commons.dto.BaseResponse;
import com.example.demo.commons.model.BaseEntity;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.io.Serializable;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValueMappingStrategy.RETURN_DEFAULT;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@MapperConfig(
        nullValueMappingStrategy = RETURN_DEFAULT,
        nullValueCheckStrategy = ALWAYS,
        nullValuePropertyMappingStrategy = IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring"
)
public interface BaseMapper<T extends BaseEntity<ID>, ID extends Serializable, Q extends BaseRequest, S extends BaseResponse<ID>> {
    T toEntity(Q request);

    S toResponse(T entity);

    T update(Q request, @MappingTarget T target);

    T update(T source, @MappingTarget T target);

    default ID toId(T entity) {
        return entity.getId();
    }
}
