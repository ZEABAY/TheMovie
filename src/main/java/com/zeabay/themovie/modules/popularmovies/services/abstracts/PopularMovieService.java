package com.zeabay.themovie.modules.popularmovies.services.abstracts;

import com.zeabay.themovie.common.core.service.BaseService;
import com.zeabay.themovie.modules.popularmovies.dto.request.PopularMovieCreateReq;
import com.zeabay.themovie.modules.popularmovies.dto.request.PopularMovieUpdateReq;
import com.zeabay.themovie.modules.popularmovies.dto.response.PopularMovieReadRes;

public interface PopularMovieService extends BaseService<PopularMovieCreateReq, PopularMovieReadRes, PopularMovieUpdateReq> {
}
