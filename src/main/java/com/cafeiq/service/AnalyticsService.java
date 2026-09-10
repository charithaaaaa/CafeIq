package com.cafeiq.service;

import com.cafeiq.dto.AnalyticsSummaryDTO;
import com.cafeiq.dto.CategoryRevenueDTO;
import com.cafeiq.dto.RevenueTrendDTO;
import com.cafeiq.dto.TopItemDTO;
import com.cafeiq.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnalyticsService {

    @Autowired
    private SalesRepository salesRepository;

    // Summary Cards
    public AnalyticsSummaryDTO getSummary() {

        Double totalRevenue = salesRepository.getTotalRevenue();
        Long totalOrders = salesRepository.getTotalOrders();
        Long totalItemsSold = salesRepository.getTotalItemsSold();

        String bestSellingItem = "N/A";

        List<TopItemDTO> items = salesRepository.getTopSellingItems();

        if (!items.isEmpty()) {
            bestSellingItem = items.get(0).getItemName();
        }

        return new AnalyticsSummaryDTO(
                totalRevenue,
                totalOrders,
                totalItemsSold,
                bestSellingItem
        );
    }

    // Revenue Trend
    public List<RevenueTrendDTO> getRevenueTrend() {

        List<Object[]> rows = salesRepository.getRevenueTrend();

        List<RevenueTrendDTO> result = new ArrayList<>();

        for (Object[] row : rows) {

            LocalDate date = ((java.sql.Date) row[0]).toLocalDate();
            Double revenue = ((Number) row[1]).doubleValue();

            result.add(new RevenueTrendDTO(date, revenue));
        }

        return result;
    }

    // Top Selling Items
    public List<TopItemDTO> getTopSellingItems() {
        return salesRepository.getTopSellingItems();
    }

    public List<CategoryRevenueDTO> getCategoryRevenue() {
    return salesRepository.getCategoryRevenue();
}

}