package com.zeabay.themovie.modules.popularmovies.controller;

import com.zeabay.themovie.common.core.controller.BaseController;
import com.zeabay.themovie.modules.popularmovies.dto.request.PopularMovieCreateReq;
import com.zeabay.themovie.modules.popularmovies.dto.request.PopularMovieUpdateReq;
import com.zeabay.themovie.modules.popularmovies.dto.response.PopularMovieReadRes;
import com.zeabay.themovie.modules.popularmovies.services.abstracts.PopularMovieService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/popular-movies")
@Tag(name = "Popular Movies Controller", description = "Popular Movies Controller")
public class PopularMovieController implements BaseController<PopularMovieCreateReq, PopularMovieReadRes, PopularMovieUpdateReq> {

    private final PopularMovieService popularMovieService;

    @Override
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid PopularMovieCreateReq createReq) {
        popularMovieService.create(createReq);
        return ResponseEntity.created(URI.create("/popular-movies")).build();
    }

    @Override
    @GetMapping
    public ResponseEntity<List<PopularMovieReadRes>> getAll() {
        return ResponseEntity.ok(popularMovieService.getAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<PopularMovieReadRes> getById(@PathVariable Long id) {
        return ResponseEntity.ok(popularMovieService.getById(id));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody PopularMovieUpdateReq updateReq) {
        popularMovieService.update(id, updateReq);
        return ResponseEntity.noContent().build();
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        popularMovieService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
