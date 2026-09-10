package com.cafeiq.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class MenuRequestDTO {

    @NotBlank(message = "Item name is required")
    private String itemName;

    @NotNull(message = "Category is required")
    private Integer categoryId;

    @NotNull(message = "Selling price is required")
    @Positive(message = "Selling price must be greater than 0")
    private Double sellingPrice;

    @NotNull(message = "Cost price is required")
    @Positive(message = "Cost price must be greater than 0")
    private Double costPrice;

    // No-Argument Constructor
    public MenuRequestDTO() {
    }

    // Parameterized Constructor
    public MenuRequestDTO(String itemName,
                          Integer categoryId,
                          Double sellingPrice,
                          Double costPrice) {

        this.itemName = itemName;
        this.categoryId = categoryId;
        this.sellingPrice = sellingPrice;
        this.costPrice = costPrice;
    }

    // Getter for itemName
    public String getItemName() {
        return itemName;
    }

    // Setter for itemName
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    // Getter for categoryId
    public Integer getCategoryId() {
        return categoryId;
    }

    // Setter for categoryId
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    // Getter for sellingPrice
    public Double getSellingPrice() {
        return sellingPrice;
    }

    // Setter for sellingPrice
    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    // Getter for costPrice
    public Double getCostPrice() {
        return costPrice;
    }

    // Setter for costPrice
    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    @Override
    public String toString() {
        return "MenuRequestDTO{" +
                "itemName='" + itemName + '\'' +
                ", categoryId=" + categoryId +
                ", sellingPrice=" + sellingPrice +
                ", costPrice=" + costPrice +
                '}';
    }
}