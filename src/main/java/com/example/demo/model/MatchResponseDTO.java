package com.example.demo.model;


import java.time.LocalDate;
import java.time.LocalTime;

public class MatchResponseDTO {
    private Long id;
    private String description;
    private LocalDate matchDate;
    private LocalTime matchTime;
    private String teamA;
    private String teamB;
    private String sport;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalTime getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(LocalTime matchTime) {
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

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }
}
