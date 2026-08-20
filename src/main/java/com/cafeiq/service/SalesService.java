package com.cafeiq.service;
import com.cafeiq.exception.InsufficientStockException;

import com.cafeiq.dto.SalesDTO;
import com.cafeiq.dto.SalesRequestDTO;
import com.cafeiq.entity.Inventory;
import com.cafeiq.entity.Menu;
import com.cafeiq.entity.Sales;
import com.cafeiq.exception.InventoryNotFoundException;
import com.cafeiq.exception.MenuNotFoundException;
import com.cafeiq.exception.SalesNotFoundException;
import com.cafeiq.repository.InventoryRepository;
import com.cafeiq.repository.MenuRepository;
import com.cafeiq.repository.SalesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalesService {

    private final SalesRepository salesRepository;
    private final MenuRepository menuRepository;
    private final InventoryRepository inventoryRepository;

    public SalesService(SalesRepository salesRepository,
                        MenuRepository menuRepository,
                        InventoryRepository inventoryRepository) {

        this.salesRepository = salesRepository;
        this.menuRepository = menuRepository;
        this.inventoryRepository = inventoryRepository;
    }

    // Convert Entity to DTO
    private SalesDTO convertToDTO(Sales sales) {

        SalesDTO dto = new SalesDTO();

        dto.setSaleId(sales.getSaleId());
        dto.setItemId(sales.getMenu().getItemId());
        dto.setItemName(sales.getMenu().getItemName());
        dto.setQuantity(sales.getQuantity());
        dto.setTotalAmount(sales.getTotalAmount());
        dto.setPaymentMethod(sales.getPaymentMethod());
        dto.setSaleDate(sales.getSaleDate());

        return dto;
    }

    // Get all sales
    public List<SalesDTO> getAllSales() {

        return salesRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get sale by ID
    public SalesDTO getSaleById(Integer id) {

        Sales sales = salesRepository.findById(id)
                .orElseThrow(() ->
                        new SalesNotFoundException("Sale not found with id : " + id));

        return convertToDTO(sales);
    }

    // Add sale
    @Transactional
    public SalesDTO addSale(SalesRequestDTO requestDTO) {

        // Find Menu Item
        Menu menu = menuRepository.findById(requestDTO.getItemId())
                .orElseThrow(() ->
                        new MenuNotFoundException("Menu item not found with id : " + requestDTO.getItemId()));

        // Find Inventory
        Inventory inventory = inventoryRepository
                .findByMenuItemId(requestDTO.getItemId())
                .orElseThrow(() ->
                        new InventoryNotFoundException("Inventory not found for Menu ID : " + requestDTO.getItemId()));

        // Check Stock
        if (inventory.getCurrentStock() < requestDTO.getQuantity()) {
            throw new InsufficientStockException(
        "Insufficient stock for " + menu.getItemName()
);
        }

        // Reduce Stock
        inventory.setCurrentStock(
                inventory.getCurrentStock() - requestDTO.getQuantity());

        inventoryRepository.save(inventory);

        // Create Sale
        Sales sale = new Sales();

        sale.setMenu(menu);
        sale.setQuantity(requestDTO.getQuantity());

        // Calculate Total Amount
        sale.setTotalAmount(
                menu.getSellingPrice() * requestDTO.getQuantity());

        sale.setPaymentMethod(requestDTO.getPaymentMethod());

        Sales savedSale = salesRepository.save(sale);

        return convertToDTO(savedSale);
    }

    // Delete Sale
    public void deleteSale(Integer id) {

        if (!salesRepository.existsById(id)) {
            throw new SalesNotFoundException("Sale not found with id : " + id);
        }

        salesRepository.deleteById(id);
    }
}