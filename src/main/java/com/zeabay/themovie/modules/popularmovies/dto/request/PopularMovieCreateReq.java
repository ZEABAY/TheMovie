package com.zeabay.themovie.modules.popularmovies.dto.request;

import com.zeabay.themovie.common.core.dto.BaseRequest;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class PopularMovieCreateReq extends BaseRequest {

    @NotNull(message = "Title is required")
    private String title;

    private String originalTitle;
    private String overview;
    private String releaseDate;
    private Double popularity;
    private Double voteAverage;
    private Integer voteCount;
    private String posterPath;
    private String backdropPath;

    @NotNull(message = "Genres are required")
    private List<Integer> genreIds;
}