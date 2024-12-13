package com.zeabay.themovie.modules.popularmovies.dto.response;

import com.zeabay.themovie.common.core.dto.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class PopularMovieReadRes extends BaseResponse {
    private String title;
    private String originalTitle;
    private String overview;
    private String releaseDate;
    private Double popularity;
    private Double voteAverage;
    private Integer voteCount;
    private String posterPath;
    private String backdropPath;
    private List<String> genreNames;
}
