package com.cafeiq.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private Integer inventoryId;

    @OneToOne
    @JoinColumn(name = "menu_item_id")
    private Menu menu;

    @Column(name = "current_stock")
    private Integer currentStock;

    @Column(name = "minimum_stock")
    private Integer minimumStock;

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;

    // No-Argument Constructor
    public Inventory() {
    }

    // Parameterized Constructor
    public Inventory(Integer inventoryId,
                     Menu menu,
                     Integer currentStock,
                     Integer minimumStock,
                     LocalDateTime lastUpdated) {

        this.inventoryId = inventoryId;
        this.menu = menu;
        this.currentStock = currentStock;
        this.minimumStock = minimumStock;
        this.lastUpdated = lastUpdated;
    }

    // Getter for inventoryId
    public Integer getInventoryId() {
        return inventoryId;
    }

    // Setter for inventoryId
    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    // Getter for menu
    public Menu getMenu() {
        return menu;
    }

    // Setter for menu
    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    // Getter for currentStock
    public Integer getCurrentStock() {
        return currentStock;
    }

    // Setter for currentStock
    public void setCurrentStock(Integer currentStock) {
        this.currentStock = currentStock;
    }

    // Getter for minimumStock
    public Integer getMinimumStock() {
        return minimumStock;
    }

    // Setter for minimumStock
    public void setMinimumStock(Integer minimumStock) {
        this.minimumStock = minimumStock;
    }

    // Getter for lastUpdated
    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    // Setter for lastUpdated
    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
    @PrePersist
    public void prePersist() {
        this.lastUpdated = LocalDateTime.now();
}

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryId=" + inventoryId +
                ", menu=" + menu +
                ", currentStock=" + currentStock +
                ", minimumStock=" + minimumStock +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}