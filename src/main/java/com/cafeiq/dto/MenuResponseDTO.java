package com.cafeiq.dto;

public class MenuResponseDTO {

    private Integer itemId;
    private String itemName;
    private Integer categoryId;
    private String categoryName;
    private Double sellingPrice;
    private Double costPrice;

    // No-Argument Constructor
    public MenuResponseDTO() {
    }

    // Parameterized Constructor
    public MenuResponseDTO(Integer itemId,
                           String itemName,
                           Integer categoryId,
                           String categoryName,
                           Double sellingPrice,
                           Double costPrice) {

        this.itemId = itemId;
        this.itemName = itemName;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.sellingPrice = sellingPrice;
        this.costPrice = costPrice;
    }

    // Getter for itemId
    public Integer getItemId() {
        return itemId;
    }

    // Setter for itemId
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
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

    // Getter for categoryName
    public String getCategoryName() {
        return categoryName;
    }

    // Setter for categoryName
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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
        return "MenuResponseDTO{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", sellingPrice=" + sellingPrice +
                ", costPrice=" + costPrice +
                '}';
    }
}