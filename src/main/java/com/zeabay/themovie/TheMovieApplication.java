package com.zeabay.themovie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaAuditing
@SpringBootApplication
@EnableJpaRepositories
@EnableConfigurationProperties
public class TheMovieApplication {

    public static void main(String[] args) {
        SpringApplication.run(TheMovieApplication.class, args);
    }

}
