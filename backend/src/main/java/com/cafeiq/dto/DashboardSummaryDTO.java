package com.cafeiq.dto;

public class DashboardSummaryDTO {

    private Double totalRevenue;
    private Long totalOrders;
    private Double averageOrderValue;
    private Long totalItemsSold;

    // No-Argument Constructor
    public DashboardSummaryDTO() {
    }

    // Parameterized Constructor
    public DashboardSummaryDTO(Double totalRevenue,
                               Long totalOrders,
                               Double averageOrderValue,
                               Long totalItemsSold) {

        this.totalRevenue = totalRevenue;
        this.totalOrders = totalOrders;
        this.averageOrderValue = averageOrderValue;
        this.totalItemsSold = totalItemsSold;
    }

    // Getter for totalRevenue
    public Double getTotalRevenue() {
        return totalRevenue;
    }

    // Setter for totalRevenue
    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    // Getter for totalOrders
    public Long getTotalOrders() {
        return totalOrders;
    }

    // Setter for totalOrders
    public void setTotalOrders(Long totalOrders) {
        this.totalOrders = totalOrders;
    }

    // Getter for averageOrderValue
    public Double getAverageOrderValue() {
        return averageOrderValue;
    }

    // Setter for averageOrderValue
    public void setAverageOrderValue(Double averageOrderValue) {
        this.averageOrderValue = averageOrderValue;
    }

    // Getter for totalItemsSold
    public Long getTotalItemsSold() {
        return totalItemsSold;
    }

    // Setter for totalItemsSold
    public void setTotalItemsSold(Long totalItemsSold) {
        this.totalItemsSold = totalItemsSold;
    }

    @Override
    public String toString() {
        return "DashboardSummaryDTO{" +
                "totalRevenue=" + totalRevenue +
                ", totalOrders=" + totalOrders +
                ", averageOrderValue=" + averageOrderValue +
                ", totalItemsSold=" + totalItemsSold +
                '}';
    }
}