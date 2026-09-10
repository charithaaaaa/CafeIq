package com.cafeiq.repository;

import com.cafeiq.dto.TopItemDTO;
import com.cafeiq.dto.CategoryRevenueDTO;
import com.cafeiq.entity.Sales;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SalesRepository extends JpaRepository<Sales, Integer> {


    // =========================================================
    // ALL-TIME DATA
    // =========================================================

    // Total Revenue
    @Query("""
        SELECT COALESCE(SUM(s.totalAmount), 0)
        FROM Sales s
    """)
    Double getTotalRevenue();


    // Total Orders
    @Query("""
        SELECT COUNT(s)
        FROM Sales s
    """)
    Long getTotalOrders();


    // Total Items Sold
    @Query("""
        SELECT COALESCE(SUM(s.quantity), 0)
        FROM Sales s
    """)
    Long getTotalItemsSold();


    // Top Selling Items - All Time
    @Query("""
        SELECT new com.cafeiq.dto.TopItemDTO(
            s.menu.itemName,
            SUM(s.quantity)
        )
        FROM Sales s
        GROUP BY s.menu.itemName
        ORDER BY SUM(s.quantity) DESC
    """)
    List<TopItemDTO> getTopSellingItems();


    // Revenue Trend - All Time
    @Query(value = """
        SELECT
            DATE(s.sale_date) AS saleDate,
            SUM(s.total_amount) AS revenue
        FROM sales s
        GROUP BY DATE(s.sale_date)
        ORDER BY DATE(s.sale_date)
        """, nativeQuery = true)
    List<Object[]> getRevenueTrend();


    // Category Revenue - All Time
    @Query("""
        SELECT new com.cafeiq.dto.CategoryRevenueDTO(
            m.category.categoryName,
            SUM(s.totalAmount)
        )
        FROM Sales s
        JOIN s.menu m
        GROUP BY m.category.categoryName
        ORDER BY SUM(s.totalAmount) DESC
    """)
    List<CategoryRevenueDTO> getCategoryRevenue();



    // =========================================================
    // TODAY
    // =========================================================

    // Today's Revenue
    @Query(value = """
        SELECT COALESCE(SUM(total_amount), 0)
        FROM sales
        WHERE DATE(sale_date) = CURRENT_DATE
        """, nativeQuery = true)
    Double getTodayRevenue();


    // Today's Orders
    @Query(value = """
        SELECT COUNT(*)
        FROM sales
        WHERE DATE(sale_date) = CURRENT_DATE
        """, nativeQuery = true)
    Long getTodayOrders();


    // Today's Items Sold
    @Query(value = """
        SELECT COALESCE(SUM(quantity), 0)
        FROM sales
        WHERE DATE(sale_date) = CURRENT_DATE
        """, nativeQuery = true)
    Long getTodayItemsSold();


    // Today's Top Selling Items
    @Query(value = """
        SELECT
            m.item_name,
            SUM(s.quantity) AS quantity_sold
        FROM sales s
        JOIN menu m
            ON s.menu_item_id = m.item_id
        WHERE DATE(s.sale_date) = CURRENT_DATE
        GROUP BY m.item_name
        ORDER BY quantity_sold DESC
        """, nativeQuery = true)
    List<Object[]> getTodayTopSellingItems();



    // =========================================================
    // LAST 7 COMPLETED DAYS
    // Yesterday → 7 days ago
    // =========================================================

    @Query(value = """
        SELECT COALESCE(SUM(total_amount), 0)
        FROM sales
        WHERE sale_date >= CURRENT_DATE - INTERVAL '7 days'
          AND sale_date < CURRENT_DATE
        """, nativeQuery = true)
    Double getLast7DaysRevenue();


    @Query(value = """
        SELECT COUNT(*)
        FROM sales
        WHERE sale_date >= CURRENT_DATE - INTERVAL '7 days'
          AND sale_date < CURRENT_DATE
        """, nativeQuery = true)
    Long getLast7DaysOrders();



    // =========================================================
    // PREVIOUS 7 COMPLETED DAYS
    // 8 days ago → 14 days ago
    // =========================================================

    @Query(value = """
        SELECT COALESCE(SUM(total_amount), 0)
        FROM sales
        WHERE sale_date >= CURRENT_DATE - INTERVAL '14 days'
          AND sale_date < CURRENT_DATE - INTERVAL '7 days'
        """, nativeQuery = true)
    Double getPrevious7DaysRevenue();


    @Query(value = """
        SELECT COUNT(*)
        FROM sales
        WHERE sale_date >= CURRENT_DATE - INTERVAL '14 days'
          AND sale_date < CURRENT_DATE - INTERVAL '7 days'
        """, nativeQuery = true)
    Long getPrevious7DaysOrders();



    // =========================================================
// TOP ITEMS - LAST 7 COMPLETED DAYS
// =========================================================

@Query(value = """
    SELECT
        m.item_name,
        SUM(s.quantity) AS quantity_sold
    FROM sales s
    JOIN menu m
        ON s.menu_item_id = m.item_id
    WHERE s.sale_date >= CURRENT_DATE - INTERVAL '7 days'
      AND s.sale_date < CURRENT_DATE
    GROUP BY m.item_name
    ORDER BY quantity_sold DESC
    """, nativeQuery = true)
List<Object[]> getLast7DaysItemSales();


// =========================================================
// TOP ITEMS - PREVIOUS 7 COMPLETED DAYS
// =========================================================

@Query(value = """
    SELECT
        m.item_name,
        SUM(s.quantity) AS quantity_sold
    FROM sales s
    JOIN menu m
        ON s.menu_item_id = m.item_id
    WHERE s.sale_date >= CURRENT_DATE - INTERVAL '14 days'
      AND s.sale_date < CURRENT_DATE - INTERVAL '7 days'
    GROUP BY m.item_name
    ORDER BY quantity_sold DESC
    """, nativeQuery = true)
List<Object[]> getPrevious7DaysItemSales();

@Query(value = """
    SELECT
        m.item_name,

        COALESCE(SUM(
            CASE
                WHEN s.sale_date >= CURRENT_DATE - INTERVAL '7 days'
                 AND s.sale_date < CURRENT_DATE
                THEN s.quantity
                ELSE 0
            END
        ), 0) AS last_7_days,

        COALESCE(SUM(
            CASE
                WHEN s.sale_date >= CURRENT_DATE - INTERVAL '14 days'
                 AND s.sale_date < CURRENT_DATE - INTERVAL '7 days'
                THEN s.quantity
                ELSE 0
            END
        ), 0) AS previous_7_days

    FROM menu m

    LEFT JOIN sales s
        ON s.menu_item_id = m.item_id
        AND s.sale_date >= CURRENT_DATE - INTERVAL '14 days'
        AND s.sale_date < CURRENT_DATE

    WHERE m.is_active = true

    GROUP BY m.item_id, m.item_name

    HAVING
        COALESCE(SUM(
            CASE
                WHEN s.sale_date >= CURRENT_DATE - INTERVAL '7 days'
                 AND s.sale_date < CURRENT_DATE
                THEN s.quantity
                ELSE 0
            END
        ), 0) > 0

        OR

        COALESCE(SUM(
            CASE
                WHEN s.sale_date >= CURRENT_DATE - INTERVAL '14 days'
                 AND s.sale_date < CURRENT_DATE - INTERVAL '7 days'
                THEN s.quantity
                ELSE 0
            END
        ), 0) > 0

    ORDER BY last_7_days DESC
    """, nativeQuery = true)
List<Object[]> getRecentItemPerformance();



}