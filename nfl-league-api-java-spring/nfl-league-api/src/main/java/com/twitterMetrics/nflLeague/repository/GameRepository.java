package com.twitterMetrics.nflLeague.repository;

import com.twitterMetrics.nflLeague.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    Optional<Game> findByIdAndSeasonId(long id, Long seasonId);
}
