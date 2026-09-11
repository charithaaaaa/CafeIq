package com.cafeiq.controller;

import com.cafeiq.dto.CategoryRevenueDTO;
import com.cafeiq.dto.DashboardSummaryDTO;
import com.cafeiq.dto.LowStockDTO;
import com.cafeiq.dto.PaymentAnalyticsDTO;
import com.cafeiq.dto.RecentSaleDTO;
import com.cafeiq.dto.RevenueTrendDTO;
import com.cafeiq.dto.TopSellingItemDTO;
import com.cafeiq.service.DashboardService;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins = {"http://localhost:5173", "https://cafeiq-frontend.vercel.app"})
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/today-summary")
    public DashboardSummaryDTO getTodaySummary() {
        return dashboardService.getTodaySummary();
    }

    @GetMapping("/revenue-trend")
    public List<RevenueTrendDTO> getRevenueTrend() {
        return dashboardService.getRevenueTrend();
    }

    @GetMapping("/top-selling")
    public List<TopSellingItemDTO> getTopSellingItems() {
        return dashboardService.getTopSellingItems();
    }

    @GetMapping("/low-stock")
    public List<LowStockDTO> getLowStockItems() {
        return dashboardService.getLowStockItems();
    }

    @GetMapping("/payment-analytics")
    public List<PaymentAnalyticsDTO> getPaymentAnalytics() {
        return dashboardService.getPaymentAnalytics();
    }

    @GetMapping("/category-revenue")
    public List<CategoryRevenueDTO> getCategoryRevenue() {
        return dashboardService.getCategoryRevenue();
    }

    @GetMapping("/recent-sales")
    public List<RecentSaleDTO> getRecentSales() {
        return dashboardService.getRecentSales();
    }
}