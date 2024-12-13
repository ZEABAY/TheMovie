package com.zeabay.themovie.common.core.controller;

import com.zeabay.themovie.common.core.dto.BaseRequest;
import com.zeabay.themovie.common.core.dto.BaseResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BaseController<
        CREATE_REQ extends BaseRequest,
        READ_RES extends BaseResponse,
        UPDATE_REQ extends BaseRequest
        > {
    ResponseEntity<Void> create(CREATE_REQ createReq);

    ResponseEntity<List<READ_RES>> getAll();

    ResponseEntity<READ_RES> getById(Long id);

    ResponseEntity<Void> update(Long id, UPDATE_REQ updateReq);

    ResponseEntity<Void> delete(Long id);
}