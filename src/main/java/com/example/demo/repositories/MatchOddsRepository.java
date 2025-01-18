package com.example.demo.repositories;

import com.example.demo.entities.MatchOdds;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchOddsRepository extends JpaRepository<MatchOdds, Long> {

}
