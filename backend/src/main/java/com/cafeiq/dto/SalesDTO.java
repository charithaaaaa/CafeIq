package com.cafeiq.dto;

import java.time.LocalDateTime;

public class SalesDTO {

    private Integer saleId;
    private Integer itemId;
    private String itemName;
    private Integer quantity;
    private Double totalAmount;
    private String paymentMethod;
    private LocalDateTime saleDate;

    // No-Argument Constructor
    public SalesDTO() {
    }

    // Parameterized Constructor
    public SalesDTO(Integer saleId,
                    Integer itemId,
                    String itemName,
                    Integer quantity,
                    Double totalAmount,
                    String paymentMethod,
                    LocalDateTime saleDate) {

        this.saleId = saleId;
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.saleDate = saleDate;
    }

    // Getter for saleId
    public Integer getSaleId() {
        return saleId;
    }

    // Setter for saleId
    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
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

    // Getter for quantity
    public Integer getQuantity() {
        return quantity;
    }

    // Setter for quantity
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    // Getter for totalAmount
    public Double getTotalAmount() {
        return totalAmount;
    }

    // Setter for totalAmount
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    // Getter for paymentMethod
    public String getPaymentMethod() {
        return paymentMethod;
    }

    // Setter for paymentMethod
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    // Getter for saleDate
    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    // Setter for saleDate
    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }

    @Override
    public String toString() {
        return "SalesDTO{" +
                "saleId=" + saleId +
                ", itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", totalAmount=" + totalAmount +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", saleDate=" + saleDate +
                '}';
    }
}