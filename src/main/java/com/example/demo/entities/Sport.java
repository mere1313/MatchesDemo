package com.example.demo.entities;

public enum Sport {
    FOOTBALL(1), BASKETBALL(2);

    private final int value;

    Sport(int value) {
        this.value = value;
    }

    public static Sport fromValue(int value) {
        for (Sport sport : Sport.values()) {
            if (sport.value == value) {
                return sport;
            }
        }
        throw new IllegalArgumentException("Invalid value for Sport: " + value);
    }

    public int getValue() {
        return value;
    }
}
