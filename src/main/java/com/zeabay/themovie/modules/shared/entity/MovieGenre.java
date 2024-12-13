package com.zeabay.themovie.modules.shared.entity;

import com.zeabay.themovie.common.core.entity.BaseEntity;
import com.zeabay.themovie.modules.popularmovies.entity.PopularMovie;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movie_genres")
@EqualsAndHashCode(callSuper = true)
public class MovieGenre extends BaseEntity {
    private int genreId;
    private String genreName;

    @Builder.Default
    @ManyToMany(mappedBy = "genres")
    private List<PopularMovie> popularMovies = new ArrayList<>();

}

