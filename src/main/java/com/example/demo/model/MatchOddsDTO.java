package com.example.demo.model;

import io.swagger.v3.oas.annotations.media.Schema;

public class MatchOddsDTO {

    @Schema(description = "ID of the match associated with the odds", example = "1")
    private Long matchId;

    @Schema(description = "Specifier for the odds (e.g., 'X', '1', '2')", example = "1")
    private String specifier;

    @Schema(description = "The odd value associated with the specifier", example = "2.5")
    private Double odd;

    // Getters and Setters
    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public String getSpecifier() {
        return specifier;
    }

    public void setSpecifier(String specifier) {
        this.specifier = specifier;
    }

    public Double getOdd() {
        return odd;
    }

    public void setOdd(Double odd) {
        this.odd = odd;
    }
}
