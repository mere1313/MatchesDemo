package com.example.demo.controller;

import com.example.demo.entities.Match;
import com.example.demo.model.MatchDTO;
import com.example.demo.model.MatchResponseDTO;
import com.example.demo.services.MatchService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/matches")
@Tag(name = "Matches", description = "Operations related to sports matches.")
public class MatchController {

    private static final Logger logger = LoggerFactory.getLogger(MatchController.class);
    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping
    public ResponseEntity<List<MatchResponseDTO>> getAllMatches() {
        logger.info("Fetching all matches");

        List<Match> matches = matchService.getAllMatches();
        List<MatchResponseDTO> response = matches.stream().map(this::convertToDTO).collect(Collectors.toList());

        logger.info("Returning {} matches", response.size());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchResponseDTO> getMatchById(@PathVariable Long id) {
        logger.info("Fetching match with ID: {}", id);

        Match match = matchService.getMatchById(id);
        if (match == null) {
            logger.error("Match with ID: {} not found", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        MatchResponseDTO response = convertToDTO(match);
        logger.info("Returning match with ID: {}", id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<MatchResponseDTO> createMatch(@RequestBody MatchDTO matchDTO) {
        logger.info("Creating new match with description: {}", matchDTO.getDescription());

        Match match = new Match();
        match.setDescription(matchDTO.getDescription());
        match.setMatchDate(matchDTO.getMatchDate());

        // Convert matchTime from String to LocalTime
        LocalTime matchTime = LocalTime.parse(matchDTO.getMatchTime());  // Converts "12:00:00" to LocalTime
        match.setMatchTime(matchTime);

        match.setTeamA(matchDTO.getTeamA());
        match.setTeamB(matchDTO.getTeamB());
        match.setSport(matchDTO.getSport());

        Match createdMatch = matchService.saveMatch(match);
        MatchResponseDTO response = convertToDTO(createdMatch);

        logger.info("Created match with ID: {}", createdMatch.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable Long id) {
        logger.info("Deleting match with ID: {}", id);

        boolean isDeleted = matchService.deleteMatch(id);
        if (!isDeleted) {
            logger.error("Match with ID: {} not found for deletion", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        logger.info("Match with ID: {} deleted successfully", id);
        return ResponseEntity.ok().build();
    }

    // Helper method to convert Match entity to MatchResponseDTO
    private MatchResponseDTO convertToDTO(Match match) {
        MatchResponseDTO dto = new MatchResponseDTO();
        dto.setId(match.getId());
        dto.setDescription(match.getDescription());
        dto.setMatchDate(match.getMatchDate());
        dto.setMatchTime(match.getMatchTime());
        dto.setTeamA(match.getTeamA());
        dto.setTeamB(match.getTeamB());
        dto.setSport(match.getSport().name()); // Convert enum to String
        return dto;
    }
}
