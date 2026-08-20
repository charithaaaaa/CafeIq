package com.cafeiq.service;

import com.cafeiq.dto.InventoryDTO;
import com.cafeiq.dto.InventoryRequestDTO;
import com.cafeiq.entity.Inventory;
import com.cafeiq.entity.Menu;
import com.cafeiq.exception.InventoryNotFoundException;
import com.cafeiq.exception.MenuNotFoundException;
import com.cafeiq.repository.InventoryRepository;
import com.cafeiq.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final MenuRepository menuRepository;

    public InventoryService(InventoryRepository inventoryRepository,
                            MenuRepository menuRepository) {
        this.inventoryRepository = inventoryRepository;
        this.menuRepository = menuRepository;
    }

    // Convert Entity to DTO
    private InventoryDTO convertToDTO(Inventory inventory) {

        InventoryDTO dto = new InventoryDTO();

        dto.setInventoryId(inventory.getInventoryId());
        dto.setItemId(inventory.getMenu().getItemId());
        dto.setItemName(inventory.getMenu().getItemName());
        dto.setCurrentStock(inventory.getCurrentStock());
        dto.setMinimumStock(inventory.getMinimumStock());
        dto.setLastUpdated(inventory.getLastUpdated());

        return dto;
    }

    // Get all inventory
    public List<InventoryDTO> getAllInventory() {

        return inventoryRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get inventory by id
    public InventoryDTO getInventoryById(Integer id) {

        Inventory inventory = inventoryRepository.findById(id)
                .orElseThrow(() ->
                        new InventoryNotFoundException("Inventory not found with id : " + id));

        return convertToDTO(inventory);
    }

    // Add inventory
    public InventoryDTO addInventory(InventoryRequestDTO requestDTO) {

        Menu menu = menuRepository.findById(requestDTO.getItemId())
                .orElseThrow(() ->
                        new MenuNotFoundException("Menu item not found"));

        Inventory inventory = new Inventory();

        inventory.setMenu(menu);
        inventory.setCurrentStock(requestDTO.getCurrentStock());
        inventory.setMinimumStock(requestDTO.getMinimumStock());

        return convertToDTO(inventoryRepository.save(inventory));
    }

    // Update inventory
    public InventoryDTO updateInventory(Integer id,
                                        InventoryRequestDTO requestDTO) {

        Inventory inventory = inventoryRepository.findById(id)
                .orElseThrow(() ->
                        new InventoryNotFoundException("Inventory not found with id : " + id));

        inventory.setCurrentStock(requestDTO.getCurrentStock());
        inventory.setMinimumStock(requestDTO.getMinimumStock());

        return convertToDTO(inventoryRepository.save(inventory));
    }

    // Delete inventory
    public void deleteInventory(Integer id) {

        if (!inventoryRepository.existsById(id)) {
            throw new InventoryNotFoundException("Inventory not found with id : " + id);
        }

        inventoryRepository.deleteById(id);
    }
}