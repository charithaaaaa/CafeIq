package com.cafeiq.dto;

public class SalesRequestDTO {

    private Integer itemId;
    private Integer quantity;
    private String paymentMethod;

    // No-Argument Constructor
    public SalesRequestDTO() {
    }

    // Parameterized Constructor
    public SalesRequestDTO(Integer itemId,
                           Integer quantity,
                           String paymentMethod) {

        this.itemId = itemId;
        this.quantity = quantity;
        this.paymentMethod = paymentMethod;
    }

    // Getter for itemId
    public Integer getItemId() {
        return itemId;
    }

    // Setter for itemId
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    // Getter for quantity
    public Integer getQuantity() {
        return quantity;
    }

    // Setter for quantity
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    // Getter for paymentMethod
    public String getPaymentMethod() {
        return paymentMethod;
    }

    // Setter for paymentMethod
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "SalesRequestDTO{" +
                "itemId=" + itemId +
                ", quantity=" + quantity +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}