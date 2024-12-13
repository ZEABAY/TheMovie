package com.zeabay.themovie.modules.popularmovies.entity;

import com.zeabay.themovie.common.core.entity.BaseEntity;
import com.zeabay.themovie.modules.shared.entity.MovieGenre;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "popular_movies")
@EqualsAndHashCode(callSuper = true)
public class PopularMovie extends BaseEntity {

    private String title;
    private String originalTitle;
    private String overview;
    private String releaseDate;
    private Double popularity;
    private Double voteAverage;
    private Integer voteCount;

    private String posterPath;
    private String backdropPath;

    @Builder.Default
    @ManyToMany
    @JoinTable(
            name = "popular_movie_genres",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<MovieGenre> genres = new ArrayList<>();
}