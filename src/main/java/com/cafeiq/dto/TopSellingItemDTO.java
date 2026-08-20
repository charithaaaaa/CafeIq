package com.cafeiq.dto;

public class TopSellingItemDTO {

    private String itemName;
    private Long quantitySold;

    // No-Argument Constructor
    public TopSellingItemDTO() {
    }

    // Parameterized Constructor
    public TopSellingItemDTO(String itemName, Long quantitySold) {
        this.itemName = itemName;
        this.quantitySold = quantitySold;
    }

    // Getter for itemName
    public String getItemName() {
        return itemName;
    }

    // Setter for itemName
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    // Getter for quantitySold
    public Long getQuantitySold() {
        return quantitySold;
    }

    // Setter for quantitySold
    public void setQuantitySold(Long quantitySold) {
        this.quantitySold = quantitySold;
    }

    @Override
    public String toString() {
        return "TopSellingItemDTO{" +
                "itemName='" + itemName + '\'' +
                ", quantitySold=" + quantitySold +
                '}';
    }
}