package com.cafeiq.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cafeiq.entity.Sales;

@Repository
public interface DashboardRepository extends JpaRepository<Sales, Integer> {

    // ===================== Today's Dashboard Summary =====================
    @Query(value = """
            SELECT
                COALESCE(SUM(total_amount), 0) AS totalRevenue,
                COUNT(*) AS totalOrders,
                COALESCE(AVG(total_amount), 0) AS averageOrderValue,
                COALESCE(SUM(quantity), 0) AS totalItemsSold
            FROM sales
            WHERE DATE(sale_date) = CURRENT_DATE
            """, nativeQuery = true)
    List<Object[]> getDashboardSummary();


  


    // ===================== Top Selling Items =====================
    @Query(value = """
            SELECT
                m.item_name,
                SUM(s.quantity) AS quantitySold
            FROM sales s
            JOIN menu m
                ON s.menu_item_id = m.item_id
            GROUP BY m.item_name
            ORDER BY quantitySold DESC
            """, nativeQuery = true)
    List<Object[]> getTopSellingItems();


    // ===================== Low Stock Items =====================
    @Query(value = """
            SELECT
                m.item_name,
                i.current_stock,
                i.minimum_stock
            FROM inventory i
            JOIN menu m
                ON i.menu_item_id = m.item_id
            WHERE i.current_stock <= i.minimum_stock
            ORDER BY i.current_stock ASC
            """, nativeQuery = true)
    List<Object[]> getLowStockItems();


    // ===================== Payment Analytics =====================
    @Query(value = """
            SELECT
                payment_method,
                COUNT(*) AS transactions,
                SUM(total_amount) AS revenue
            FROM sales
            GROUP BY payment_method
            ORDER BY COUNT(*) DESC, SUM(total_amount) DESC
            """, nativeQuery = true)
    List<Object[]> getPaymentAnalytics();


    // ===================== Category Revenue =====================
    @Query(value = """
            SELECT
                c.category_name,
                SUM(s.total_amount) AS revenue
            FROM sales s
            JOIN menu m
                ON s.menu_item_id = m.item_id
            JOIN category c
                ON m.category_id = c.category_id
            GROUP BY c.category_name
            ORDER BY SUM(s.total_amount) DESC
            """, nativeQuery = true)
    List<Object[]> getCategoryRevenue();


    @Query(value = """
        SELECT
            s.sale_date,
            m.item_name,
            s.quantity,
            s.payment_method,
            s.total_amount
        FROM sales s
        JOIN menu m
            ON s.menu_item_id = m.item_id
        ORDER BY s.sale_date DESC
        LIMIT 10
        """, nativeQuery = true)
List<Object[]> getRecentSales();

// ===================== Last 30 Days Revenue Trend =====================
@Query(value = """
        SELECT
            DATE(sale_date) AS saleDate,
            SUM(total_amount) AS revenue
        FROM sales
        WHERE sale_date >= CURRENT_DATE - INTERVAL '30 days'
          AND sale_date < CURRENT_DATE + INTERVAL '1 day'
        GROUP BY DATE(sale_date)
        ORDER BY DATE(sale_date)
        """, nativeQuery = true)
List<Object[]> getRevenueTrend();






}