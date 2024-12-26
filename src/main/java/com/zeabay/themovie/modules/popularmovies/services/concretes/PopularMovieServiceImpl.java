package com.zeabay.themovie.modules.popularmovies.services.concretes;

import com.zeabay.themovie.common.core.dto.BaseRequest;
import com.zeabay.themovie.common.core.service.BaseServiceImpl;
import com.zeabay.themovie.modules.popularmovies.dto.request.PopularMovieCreateReq;
import com.zeabay.themovie.modules.popularmovies.dto.request.PopularMovieUpdateReq;
import com.zeabay.themovie.modules.popularmovies.dto.response.PopularMovieReadRes;
import com.zeabay.themovie.modules.popularmovies.entity.PopularMovie;
import com.zeabay.themovie.modules.popularmovies.maper.PopularMovieMapper;
import com.zeabay.themovie.modules.popularmovies.repository.PopularMovieRepository;
import com.zeabay.themovie.modules.popularmovies.services.abstracts.PopularMovieService;
import com.zeabay.themovie.modules.shared.entity.MovieGenre;
import com.zeabay.themovie.modules.shared.repository.GenreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PopularMovieServiceImpl extends BaseServiceImpl<
        PopularMovie,
        PopularMovieCreateReq, PopularMovieReadRes, PopularMovieUpdateReq>
        implements PopularMovieService {

    private final GenreRepository genreRepository;

    public PopularMovieServiceImpl(PopularMovieRepository popularMovieRepository,
                                   PopularMovieMapper popularMovieMapper,
                                   GenreRepository genreRepository) {
        super(popularMovieRepository, popularMovieMapper);
        this.genreRepository = genreRepository;
    }

    @Override
    protected void handleRelationships(BaseRequest request, PopularMovie entity) {
        if (request instanceof PopularMovieCreateReq createReq) {
            List<MovieGenre> genres = genreRepository.findAllByGenreIdIn(createReq.getGenreIds());
            entity.setGenres(genres);
        } else if (request instanceof PopularMovieUpdateReq updateReq) {
            List<MovieGenre> genres = genreRepository.findAllByGenreIdIn(updateReq.getGenreIds());
            if (!genres.isEmpty()) {
                entity.setGenres(genres);
            }
        }
    }
}