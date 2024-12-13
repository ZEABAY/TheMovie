package com.zeabay.themovie.modules.shared.repository;

import com.zeabay.themovie.common.core.repository.BaseRepository;
import com.zeabay.themovie.modules.shared.entity.MovieGenre;

import java.util.List;

public interface GenreRepository extends BaseRepository<MovieGenre> {
    List<MovieGenre> findAllByGenreIdIn(List<Integer> genreIds);
}
