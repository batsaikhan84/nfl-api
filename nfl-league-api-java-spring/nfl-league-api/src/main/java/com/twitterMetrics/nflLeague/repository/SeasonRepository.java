package com.twitterMetrics.nflLeague.repository;

import com.twitterMetrics.nflLeague.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {
}
