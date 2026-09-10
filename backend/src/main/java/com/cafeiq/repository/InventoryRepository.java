package com.cafeiq.repository;

import com.cafeiq.entity.Inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    Optional<Inventory> findByMenuItemId(Integer itemId);


    // =====================================================
    // INVENTORY DATA FOR BUSINESS ADVISOR
    // =====================================================

    @Query(value = """
        SELECT
            m.item_name,
            i.current_stock,
            i.minimum_stock
        FROM inventory i
        JOIN menu m
            ON i.menu_item_id = m.item_id
        WHERE m.is_active = true
        ORDER BY m.item_name
        """, nativeQuery = true)
    List<Object[]> getInventoryForBusinessAdvisor();

}