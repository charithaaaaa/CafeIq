package com.cafeiq.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "sales")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id")
    private Integer saleId;

    @ManyToOne
    @JoinColumn(name = "menu_item_id")
    private Menu menu;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "sale_date")
    private LocalDateTime saleDate;

    // No-Argument Constructor
    public Sales() {
    }

    // Parameterized Constructor
    public Sales(Integer saleId,
                 Menu menu,
                 Integer quantity,
                 Double totalAmount,
                 String paymentMethod,
                 LocalDateTime saleDate) {

        this.saleId = saleId;
        this.menu = menu;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.saleDate = saleDate;
    }

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }

    @PrePersist
    public void prePersist() {
        this.saleDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Sales{" +
                "saleId=" + saleId +
                ", menu=" + menu +
                ", quantity=" + quantity +
                ", totalAmount=" + totalAmount +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", saleDate=" + saleDate +
                '}';
    }
}