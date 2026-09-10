package com.cafeiq.dto;

import java.time.LocalDateTime;

public class RecentSaleDTO {

    private LocalDateTime saleDate;
    private String itemName;
    private Integer quantity;
    private String paymentMethod;
    private Double totalAmount;

    public RecentSaleDTO() {
    }

    public RecentSaleDTO(LocalDateTime saleDate, String itemName, Integer quantity,
                         String paymentMethod, Double totalAmount) {
        this.saleDate = saleDate;
        this.itemName = itemName;
        this.quantity = quantity;
        this.paymentMethod = paymentMethod;
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}