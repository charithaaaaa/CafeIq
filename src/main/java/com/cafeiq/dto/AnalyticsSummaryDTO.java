package com.cafeiq.dto;

public class AnalyticsSummaryDTO {

    private double totalRevenue;
    private long totalOrders;
    private long totalItemsSold;
    private String bestSellingItem;

    public AnalyticsSummaryDTO() {
    }

    public AnalyticsSummaryDTO(double totalRevenue,
                               long totalOrders,
                               long totalItemsSold,
                               String bestSellingItem) {
        this.totalRevenue = totalRevenue;
        this.totalOrders = totalOrders;
        this.totalItemsSold = totalItemsSold;
        this.bestSellingItem = bestSellingItem;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public long getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(long totalOrders) {
        this.totalOrders = totalOrders;
    }

    public long getTotalItemsSold() {
        return totalItemsSold;
    }

    public void setTotalItemsSold(long totalItemsSold) {
        this.totalItemsSold = totalItemsSold;
    }

    public String getBestSellingItem() {
        return bestSellingItem;
    }

    public void setBestSellingItem(String bestSellingItem) {
        this.bestSellingItem = bestSellingItem;
    }
}