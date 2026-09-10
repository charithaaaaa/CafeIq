package com.cafeiq.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cafe_operating_day")
public class CafeOperatingDay {

    @Id
    @Column(name = "operating_date")
    private LocalDate operatingDate;

    @Column(name = "status", nullable = false)
    private String status;

    // No-argument constructor
    public CafeOperatingDay() {
    }

    // Parameterized constructor
    public CafeOperatingDay(LocalDate operatingDate, String status) {
        this.operatingDate = operatingDate;
        this.status = status;
    }

    public LocalDate getOperatingDate() {
        return operatingDate;
    }

    public void setOperatingDate(LocalDate operatingDate) {
        this.operatingDate = operatingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CafeOperatingDay{" +
                "operatingDate=" + operatingDate +
                ", status='" + status + '\'' +
                '}';
    }
}