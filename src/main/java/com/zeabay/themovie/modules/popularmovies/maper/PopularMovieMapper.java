package com.zeabay.themovie.modules.popularmovies.maper;

import com.zeabay.themovie.common.core.mapper.BaseMapper;
import com.zeabay.themovie.modules.popularmovies.dto.request.PopularMovieCreateReq;
import com.zeabay.themovie.modules.popularmovies.dto.request.PopularMovieUpdateReq;
import com.zeabay.themovie.modules.popularmovies.dto.response.PopularMovieReadRes;
import com.zeabay.themovie.modules.popularmovies.entity.PopularMovie;
import com.zeabay.themovie.modules.shared.entity.MovieGenre;
import org.mapstruct.*;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PopularMovieMapper extends BaseMapper<
        PopularMovie,
        PopularMovieCreateReq,
        PopularMovieReadRes,
        PopularMovieUpdateReq> {

    @Override
    @Mapping(target = "genres", ignore = true)
    PopularMovie toEntity(PopularMovieCreateReq createReq);

    @Override
    @Mapping(target = "genreNames", expression = "java(mapGenresToNames(entity.getGenres()))")
    PopularMovieReadRes toResponse(PopularMovie entity);

    default List<String> mapGenresToNames(List<MovieGenre> movieGenres) {
        return movieGenres.stream()
                .map(MovieGenre::getGenreName)
                .collect(Collectors.toList());
    }
}