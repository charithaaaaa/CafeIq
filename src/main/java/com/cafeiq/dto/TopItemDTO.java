package com.cafeiq.dto;

public class TopItemDTO {

    private String itemName;
    private Long quantitySold;

    public TopItemDTO(String itemName, Long quantitySold) {
        this.itemName = itemName;
        this.quantitySold = quantitySold;
    }

    public String getItemName() {
        return itemName;
    }

    public Long getQuantitySold() {
        return quantitySold;
    }
}