package com.cafeiq.service;
import com.cafeiq.dto.LowStockDTO;
import com.cafeiq.dto.CategoryRevenueDTO;

import com.cafeiq.dto.RecentSaleDTO;
import java.sql.Timestamp;
import com.cafeiq.dto.DashboardSummaryDTO;
import com.cafeiq.dto.RevenueTrendDTO;
import com.cafeiq.dto.TopSellingItemDTO;
import com.cafeiq.repository.DashboardRepository;
import com.cafeiq.dto.PaymentAnalyticsDTO;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardService {

    private final DashboardRepository dashboardRepository;

    public DashboardService(DashboardRepository dashboardRepository) {
        this.dashboardRepository = dashboardRepository;
    }

    // Dashboard Summary
    public DashboardSummaryDTO getTodaySummary() {

        Object[] result = dashboardRepository.getDashboardSummary().get(0);

        DashboardSummaryDTO dto = new DashboardSummaryDTO();

        dto.setTotalRevenue(((Number) result[0]).doubleValue());
        dto.setTotalOrders(((Number) result[1]).longValue());
        dto.setAverageOrderValue(((Number) result[2]).doubleValue());
        dto.setTotalItemsSold(((Number) result[3]).longValue());

        return dto;
    }

    // Revenue Trend
    public List<RevenueTrendDTO> getRevenueTrend() {

        List<Object[]> results = dashboardRepository.getRevenueTrend();

        List<RevenueTrendDTO> revenueTrend = new ArrayList<>();

        for (Object[] row : results) {

            RevenueTrendDTO dto = new RevenueTrendDTO();

            dto.setDate(((Date) row[0]).toLocalDate());
            dto.setRevenue(((Number) row[1]).doubleValue());

            revenueTrend.add(dto);
        }

        return revenueTrend;
    }

    // Top Selling Items
    public List<TopSellingItemDTO> getTopSellingItems() {

        List<Object[]> results = dashboardRepository.getTopSellingItems();

        List<TopSellingItemDTO> topSellingItems = new ArrayList<>();

        for (Object[] row : results) {

            TopSellingItemDTO dto = new TopSellingItemDTO();

            dto.setItemName((String) row[0]);
            dto.setQuantitySold(((Number) row[1]).longValue());

            topSellingItems.add(dto);
        }

        return topSellingItems;
    }
    public List<LowStockDTO> getLowStockItems() {

    List<Object[]> results = dashboardRepository.getLowStockItems();

    List<LowStockDTO> lowStockItems = new ArrayList<>();

    for (Object[] row : results) {

        LowStockDTO dto = new LowStockDTO();

        dto.setItemName((String) row[0]);
        dto.setCurrentStock(((Number) row[1]).intValue());
        dto.setMinimumStock(((Number) row[2]).intValue());

        lowStockItems.add(dto);
    }

    return lowStockItems;
}
    public List<PaymentAnalyticsDTO> getPaymentAnalytics() {

    List<Object[]> results = dashboardRepository.getPaymentAnalytics();

    List<PaymentAnalyticsDTO> paymentAnalytics = new ArrayList<>();

    for (Object[] row : results) {

        PaymentAnalyticsDTO dto = new PaymentAnalyticsDTO();

        dto.setPaymentMethod((String) row[0]);
        dto.setTransactions(((Number) row[1]).longValue());
        dto.setRevenue(((Number) row[2]).doubleValue());

        paymentAnalytics.add(dto);
    }

    return paymentAnalytics;
}

    public List<CategoryRevenueDTO> getCategoryRevenue() {

    List<Object[]> results = dashboardRepository.getCategoryRevenue();

    List<CategoryRevenueDTO> categoryRevenue = new ArrayList<>();

    for (Object[] row : results) {

        CategoryRevenueDTO dto = new CategoryRevenueDTO();

        dto.setCategoryName((String) row[0]);
        dto.setRevenue(((Number) row[1]).doubleValue());

        categoryRevenue.add(dto);
    }

    return categoryRevenue;
}
    public List<RecentSaleDTO> getRecentSales() {

    List<Object[]> results = dashboardRepository.getRecentSales();

    List<RecentSaleDTO> recentSales = new ArrayList<>();

    for (Object[] row : results) {

        RecentSaleDTO dto = new RecentSaleDTO();

        dto.setSaleDate(((Timestamp) row[0]).toLocalDateTime());
        dto.setItemName((String) row[1]);
        dto.setQuantity(((Number) row[2]).intValue());
        dto.setPaymentMethod((String) row[3]);
        dto.setTotalAmount(((Number) row[4]).doubleValue());

        recentSales.add(dto);
    }

    return recentSales;
}
}