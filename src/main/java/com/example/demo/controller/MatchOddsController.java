package com.example.demo.controller;

import com.example.demo.entities.Match;
import com.example.demo.entities.MatchOdds;
import com.example.demo.model.MatchOddsDTO;
import com.example.demo.services.MatchOddsService;
import com.example.demo.services.MatchService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/match-odds")
@Tag(name = "Match Odds", description = "Operations related to match odds.")
public class MatchOddsController {

    private static final Logger logger = LoggerFactory.getLogger(MatchOddsController.class);
    private final MatchOddsService matchOddsService;
    private final MatchService matchService;

    public MatchOddsController(MatchOddsService matchOddsService, MatchService matchService) {
        this.matchOddsService = matchOddsService;
        this.matchService = matchService;
    }

    // Get all match odds
    @GetMapping
    public ResponseEntity<List<MatchOdds>> getAllOdds() {
        logger.info("Fetching all match odds");
        List<MatchOdds> matchOdds = matchOddsService.getAllOdds();
        logger.info("Returning {} match odds", matchOdds.size());
        return ResponseEntity.ok(matchOdds);
    }

    // Get match odds by ID
    @GetMapping("/{id}")
    public ResponseEntity<MatchOdds> getMatchOddsById(@PathVariable Long id) {
        logger.info("Fetching match odds with ID: {}", id);
        MatchOdds matchOdds = matchOddsService.getMatchOddsById(id);
        if (matchOdds == null) {
            logger.error("Match odds with ID {} not found", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(matchOdds);
    }

    // Create new match odds
    @PostMapping
    public ResponseEntity<MatchOdds> createMatchOdds(@RequestBody MatchOddsDTO matchOddsDTO) {
        logger.info("Creating new match odds for match ID: {}", matchOddsDTO.getMatchId());

        Match match = matchService.getMatchById(matchOddsDTO.getMatchId());
        if (match == null) {
            logger.error("Match with ID {} not found", matchOddsDTO.getMatchId());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        MatchOdds matchOdds = new MatchOdds();
        matchOdds.setMatch(match);
        matchOdds.setSpecifier(matchOddsDTO.getSpecifier());
        matchOdds.setOdd(matchOddsDTO.getOdd());

        MatchOdds createdMatchOdds = matchOddsService.saveMatchOdds(matchOdds);

        logger.info("Created match odds with ID: {}", createdMatchOdds.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMatchOdds);
    }

    // Delete match odds by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatchOdds(@PathVariable Long id) {
        logger.info("Deleting match odds with ID: {}", id);
        MatchOdds matchOdds = matchOddsService.getMatchOddsById(id);
        if (matchOdds == null) {
            logger.error("Match odds with ID {} not found", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        matchOddsService.deleteMatchOddsById(id);
        logger.info("Deleted match odds with ID: {}", id);
        return ResponseEntity.noContent().build();
    }
}
