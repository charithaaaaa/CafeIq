package com.cafeiq.dto;

import java.time.LocalDate;

public class RevenueTrendDTO {

    private LocalDate date;
    private Double revenue;

    // No-Argument Constructor
    public RevenueTrendDTO() {
    }

    // Parameterized Constructor
    public RevenueTrendDTO(LocalDate date, Double revenue) {
        this.date = date;
        this.revenue = revenue;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getRevenue() {
        return revenue;
    }

    public void setRevenue(Double revenue) {
        this.revenue = revenue;
    }

    @Override
    public String toString() {
        return "RevenueTrendDTO{" +
                "date=" + date +
                ", revenue=" + revenue +
                '}';
    }
}