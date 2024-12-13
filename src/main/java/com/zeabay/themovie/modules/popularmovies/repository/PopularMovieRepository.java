package com.zeabay.themovie.modules.popularmovies.repository;

import com.zeabay.themovie.common.core.repository.BaseRepository;
import com.zeabay.themovie.modules.popularmovies.entity.PopularMovie;
import org.springframework.stereotype.Repository;

@Repository
public interface PopularMovieRepository extends BaseRepository<PopularMovie> {
}
