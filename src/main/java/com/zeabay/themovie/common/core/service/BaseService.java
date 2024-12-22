package com.zeabay.themovie.common.core.service;

import com.zeabay.themovie.common.core.dto.BaseRequest;
import com.zeabay.themovie.common.core.dto.BaseResponse;

import java.util.List;

public interface BaseService<
        CREATE_REQ extends BaseRequest,
        READ_RES extends BaseResponse,
        UPDATE_REQ extends BaseRequest
        > {
    Long create(CREATE_REQ createReq);

    List<READ_RES> getAll();

    READ_RES getById(Long id);

    void update(Long id, UPDATE_REQ updateReq);

    void delete(Long id);
}