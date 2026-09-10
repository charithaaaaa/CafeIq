package com.cafeiq.dto;

public class PaymentAnalyticsDTO {

    private String paymentMethod;
    private Long transactions;
    private Double revenue;

    public PaymentAnalyticsDTO() {
    }

    public PaymentAnalyticsDTO(String paymentMethod, Long transactions, Double revenue) {
        this.paymentMethod = paymentMethod;
        this.transactions = transactions;
        this.revenue = revenue;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Long getTransactions() {
        return transactions;
    }

    public void setTransactions(Long transactions) {
        this.transactions = transactions;
    }

    public Double getRevenue() {
        return revenue;
    }

    public void setRevenue(Double revenue) {
        this.revenue = revenue;
    }

    @Override
    public String toString() {
        return "PaymentAnalyticsDTO{" +
                "paymentMethod='" + paymentMethod + '\'' +
                ", transactions=" + transactions +
                ", revenue=" + revenue +
                '}';
    }
}