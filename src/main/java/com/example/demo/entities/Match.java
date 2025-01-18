package com.example.demo.entities;

import com.example.demo.utils.SportConverter;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private LocalDate matchDate;
    private LocalTime matchTime;
    private String teamA;
    private String teamB;
    @Convert(converter = SportConverter.class)
    private Sport sport;

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
        // Truncate seconds and nanoseconds
        this.matchTime = matchTime == null ? null : matchTime.withSecond(0).withNano(0);
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

    // Getters and Setters
}
