package com.cafeiq.dto;

import java.time.LocalDateTime;

public class InventoryDTO {

    private Integer inventoryId;
    private Integer itemId;
    private String itemName;
    private Integer currentStock;
    private Integer minimumStock;
    private LocalDateTime lastUpdated;

    // No-Argument Constructor
    public InventoryDTO() {
    }

    // Parameterized Constructor
    public InventoryDTO(Integer inventoryId,
                        Integer itemId,
                        String itemName,
                        Integer currentStock,
                        Integer minimumStock,
                        LocalDateTime lastUpdated) {

        this.inventoryId = inventoryId;
        this.itemId = itemId;
        this.itemName = itemName;
        this.currentStock = currentStock;
        this.minimumStock = minimumStock;
        this.lastUpdated = lastUpdated;
    }

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
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

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "InventoryDTO{" +
                "inventoryId=" + inventoryId +
                ", itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", currentStock=" + currentStock +
                ", minimumStock=" + minimumStock +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}