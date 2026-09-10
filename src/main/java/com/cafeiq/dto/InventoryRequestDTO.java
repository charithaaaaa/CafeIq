package com.cafeiq.dto;

public class InventoryRequestDTO {

    private Integer itemId;
    private Integer currentStock;
    private Integer minimumStock;

    public InventoryRequestDTO() {
    }

    public InventoryRequestDTO(Integer itemId,
                               Integer currentStock,
                               Integer minimumStock) {

        this.itemId = itemId;
        this.currentStock = currentStock;
        this.minimumStock = minimumStock;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
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
        return "InventoryRequestDTO{" +
                "itemId=" + itemId +
                ", currentStock=" + currentStock +
                ", minimumStock=" + minimumStock +
                '}';
    }
}