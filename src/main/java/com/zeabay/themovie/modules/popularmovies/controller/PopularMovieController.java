package com.zeabay.themovie.modules.popularmovies.controller;

import com.zeabay.themovie.common.core.controller.BaseController;
import com.zeabay.themovie.modules.popularmovies.dto.request.PopularMovieCreateReq;
import com.zeabay.themovie.modules.popularmovies.dto.request.PopularMovieUpdateReq;
import com.zeabay.themovie.modules.popularmovies.dto.response.PopularMovieReadRes;
import com.zeabay.themovie.modules.popularmovies.services.abstracts.PopularMovieService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/popular-movies")
@Tag(name = "Popular Movies Controller", description = "Popular Movies Controller")
public class PopularMovieController extends BaseController<
        PopularMovieCreateReq,
        PopularMovieReadRes,
        PopularMovieUpdateReq,
        PopularMovieService> {

    public PopularMovieController(PopularMovieService service) {
        super(service);
    }
}