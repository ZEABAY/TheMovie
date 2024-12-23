package com.zeabay.themovie.integration.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class ExternalApiCallerJob {
    private static final String MINUTELY_CRON = "0 * * * * ?";  // Every minute
    private static final String HOURLY_CRON = "0 0 * * * ?";    // Every hour
    private static final String DAILY_CRON = "0 0 0 * * ?";     // Every day
    private static final String WEEKLY_CRON = "0 0 0 * * MON";  // Every week (Monday)
    private static final String MONTHLY_CRON = "0 0 0 1 * ?";   // Every month (1st day)

    @Scheduled(cron = MINUTELY_CRON, zone = "Europe/Istanbul")
    public void getPopularMoviesFromTMDB() {
        log.info("Called TMDB API");
    }
}
