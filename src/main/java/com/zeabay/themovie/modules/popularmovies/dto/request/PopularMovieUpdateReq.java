package com.zeabay.themovie.modules.popularmovies.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zeabay.themovie.common.core.dto.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class PopularMovieUpdateReq extends BaseRequest {
    @JsonProperty("titleName")
    private String title;
    @JsonProperty("originalTitle")
    private String originalTitle;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("releaseDate")
    private String releaseDate;
    @JsonProperty("popularity")
    private Double popularity;
    @JsonProperty("voteAverage")
    private Double voteAverage;
    @JsonProperty("voteCount")
    private Integer voteCount;
    @JsonProperty("posterPath")
    private String posterPath;
    @JsonProperty("backdropPath")
    private String backdropPath;
    @JsonProperty("genreIds")
    private List<Integer> genreIds;
}