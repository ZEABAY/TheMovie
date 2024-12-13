package com.zeabay.themovie.common.core.service;

import com.zeabay.themovie.common.core.dto.BaseRequest;
import com.zeabay.themovie.common.core.dto.BaseResponse;
import com.zeabay.themovie.common.core.mapper.BaseMapper;
import com.zeabay.themovie.common.core.repository.BaseRepository;

import java.util.List;
import java.util.stream.Collectors;


public abstract class BaseServiceImpl<
        ENTITY,
        CREATE_REQ extends BaseRequest,
        READ_RES extends BaseResponse,
        UPDATE_REQ extends BaseRequest>
        implements BaseService<CREATE_REQ, READ_RES, UPDATE_REQ> {

    protected final BaseRepository<ENTITY> repository;
    protected final BaseMapper<ENTITY, CREATE_REQ, READ_RES, UPDATE_REQ> mapper;

    protected BaseServiceImpl(BaseRepository<ENTITY> repository,
                              BaseMapper<ENTITY, CREATE_REQ, READ_RES, UPDATE_REQ> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void create(CREATE_REQ createReq) {
        ENTITY entity = mapper.toEntity(createReq);
        handleRelationships(createReq, entity);
        repository.save(entity);
    }

    @Override
    public List<READ_RES> getAll() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public READ_RES getById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Entity not found"));
    }

    @Override
    public void update(Long id, UPDATE_REQ updateReq) {
        ENTITY entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entity not found"));
        mapper.updateEntity(updateReq, entity);
        handleRelationships(updateReq, entity);
        repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    protected void handleRelationships(BaseRequest request, ENTITY entity) {
        // Default implementation
    }
}