package com.cafeiq.controller;

import com.cafeiq.dto.AnalyticsSummaryDTO;
import com.cafeiq.dto.CategoryRevenueDTO;
import com.cafeiq.dto.RevenueTrendDTO;
import com.cafeiq.dto.TopItemDTO;
import com.cafeiq.service.AnalyticsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/analytics")
@CrossOrigin(origins = {"http://localhost:5173", "https://cafeiq-frontend.vercel.app"})
public class AnalyticsController {

    @Autowired
    private AnalyticsService analyticsService;

    // Summary Cards
    @GetMapping("/summary")
    public AnalyticsSummaryDTO getSummary() {
        return analyticsService.getSummary();
    }

    // Revenue Trend
    @GetMapping("/revenue-trend")
    public List<RevenueTrendDTO> getRevenueTrend() {
        return analyticsService.getRevenueTrend();
    }

    // Top Selling Items
    @GetMapping("/top-items")
    public List<TopItemDTO> getTopSellingItems() {
        return analyticsService.getTopSellingItems();
    }

    @GetMapping("/category-revenue")
public ResponseEntity<List<CategoryRevenueDTO>> getCategoryRevenue() {
    return ResponseEntity.ok(analyticsService.getCategoryRevenue());
}

}