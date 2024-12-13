package com.zeabay.themovie.common.core.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

public interface BaseMapper<
        ENTITY,
        CREATE_REQ,
        READ_RES,
        UPDATE_REQ> {

    ENTITY toEntity(CREATE_REQ createReq);

    READ_RES toResponse(ENTITY entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(UPDATE_REQ updateReq, @MappingTarget ENTITY entity);
}