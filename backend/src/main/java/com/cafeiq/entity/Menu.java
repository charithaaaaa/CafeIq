package com.cafeiq.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "menu")
public class Menu {

    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "item_id")
private Integer itemId;

    @Column(name = "item_name")
    private String itemName;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference
    private Category category;

    @Column(name = "selling_price")
    private Double sellingPrice;

    @Column(name = "cost_price")
    private Double costPrice;

    @Column(name = "is_active")
    private Boolean isActive = true;

    // No-Argument Constructor
    public Menu() {
    }

    // Parameterized Constructor
    public Menu(Integer itemId,
                String itemName,
                Category category,
                Double sellingPrice,
                Double costPrice,
                Boolean isActive) {

        this.itemId = itemId;
        this.itemName = itemName;
        this.category = category;
        this.sellingPrice = sellingPrice;
        this.costPrice = costPrice;
        this.isActive = isActive;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", sellingPrice=" + sellingPrice +
                ", costPrice=" + costPrice +
                ", isActive=" + isActive +
                '}';
    }
}