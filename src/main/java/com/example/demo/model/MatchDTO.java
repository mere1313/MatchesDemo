package com.example.demo.model;

import com.example.demo.entities.Sport;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

public class MatchDTO {

    private String description;

    private LocalDate matchDate;

    @Schema(example = "12:00:00", description = "Match time in HH:mm:ss format")
    private String matchTime;

    private String teamA;

    private String teamB;

    private Sport sport;

    // Getters and Setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(LocalDate matchDate) {
        this.matchDate = matchDate;
    }

    public String getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(String matchTime) {
        this.matchTime = matchTime;
    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }
}
