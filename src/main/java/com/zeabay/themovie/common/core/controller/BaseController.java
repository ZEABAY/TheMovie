package com.zeabay.themovie.common.core.controller;

import com.zeabay.themovie.common.core.dto.BaseRequest;
import com.zeabay.themovie.common.core.dto.BaseResponse;
import com.zeabay.themovie.common.core.service.BaseService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
public abstract class BaseController<
        CREATE_REQ extends BaseRequest,
        READ_RES extends BaseResponse,
        UPDATE_REQ extends BaseRequest,
        SERVICE extends BaseService<CREATE_REQ, READ_RES, UPDATE_REQ>
        > {

    protected final SERVICE service;

    @Operation(summary = "Create a new resource")
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CREATE_REQ createReq) {
        // Service'ten yeni kaynağın ID'sini döndür
        Long id = service.create(createReq);

        // Location URI'sini oluştur
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest() // Mevcut URI'yi temel alır
                .path("/{id}")        // URI'ye /{id} ekler
                .buildAndExpand(id)   // {id} kısmını ID ile değiştirir
                .toUri();

        // 201 Created yanıtı döndür
        return ResponseEntity.created(location).build();
    }

    @Operation(summary = "Get all resources")
    @GetMapping
    public ResponseEntity<List<READ_RES>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Operation(summary = "Get a resource by ID")
    @GetMapping("/{id}")
    public ResponseEntity<READ_RES> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @Operation(summary = "Update a resource")
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody UPDATE_REQ updateReq) {
        service.update(id, updateReq);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Delete a resource")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}