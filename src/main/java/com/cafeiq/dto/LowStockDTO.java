package com.cafeiq.dto;

public class LowStockDTO {

    private String itemName;
    private Integer currentStock;
    private Integer minimumStock;

    public LowStockDTO() {
    }

    public LowStockDTO(String itemName, Integer currentStock, Integer minimumStock) {
        this.itemName = itemName;
        this.currentStock = currentStock;
        this.minimumStock = minimumStock;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(Integer currentStock) {
        this.currentStock = currentStock;
    }

    public Integer getMinimumStock() {
        return minimumStock;
    }

    public void setMinimumStock(Integer minimumStock) {
        this.minimumStock = minimumStock;
    }

    @Override
    public String toString() {
        return "LowStockDTO{" +
                "itemName='" + itemName + '\'' +
                ", currentStock=" + currentStock +
                ", minimumStock=" + minimumStock +
                '}';
    }
}