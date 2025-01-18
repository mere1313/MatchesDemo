package com.example.demo.services;

import com.example.demo.entities.MatchOdds;
import com.example.demo.repositories.MatchOddsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchOddsService {

    private final MatchOddsRepository matchOddsRepository;

    public MatchOddsService(MatchOddsRepository matchOddsRepository) {
        this.matchOddsRepository = matchOddsRepository;
    }

    // Get all match odds
    public List<MatchOdds> getAllOdds() {
        return matchOddsRepository.findAll();
    }

    // Save match odds
    public MatchOdds saveMatchOdds(MatchOdds matchOdds) {
        return matchOddsRepository.save(matchOdds);
    }

    // Get match odds by ID
    public MatchOdds getMatchOddsById(Long id) {
        return matchOddsRepository.findById(id).orElse(null);
    }

    // Delete match odds by ID
    public void deleteMatchOddsById(Long id) {
        matchOddsRepository.deleteById(id);
    }
}
