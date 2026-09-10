package com.cafeiq.dto;

public class CategoryRevenueDTO {

    private String categoryName;
    private Double revenue;

    public CategoryRevenueDTO() {
    }

    public CategoryRevenueDTO(String categoryName, Double revenue) {
        this.categoryName = categoryName;
        this.revenue = revenue;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Double getRevenue() {
        return revenue;
    }

    public void setRevenue(Double revenue) {
        this.revenue = revenue;
    }

    @Override
    public String toString() {
        return "CategoryRevenueDTO{" +
                "categoryName='" + categoryName + '\'' +
                ", revenue=" + revenue +
                '}';
    }
}