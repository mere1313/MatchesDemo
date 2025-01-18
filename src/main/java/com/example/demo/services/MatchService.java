package com.example.demo.services;

import com.example.demo.entities.Match;
import com.example.demo.repositories.MatchRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MatchService {
    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public Match getMatchById(Long id) {
        return matchRepository.findById(id).orElseThrow(() -> new RuntimeException("Match not found"));
    }

    public Match saveMatch(Match match) {
        return matchRepository.save(match);
    }

    public boolean deleteMatch(Long id) {
        Optional<Match> match = matchRepository.findById(id);
        if (match.isPresent()) {
            matchRepository.delete(match.get());
            return true;  // Match deleted successfully
        }
        return false;  // Match not found
    }

}
