package com.cafeiq.service;
import com.cafeiq.entity.Inventory;
import com.cafeiq.repository.InventoryRepository;

import com.cafeiq.dto.MenuDTO;
import com.cafeiq.entity.Menu;
import com.cafeiq.exception.MenuNotFoundException;
import com.cafeiq.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuService {

    private final MenuRepository menuRepository;
    private final InventoryRepository inventoryRepository;

   public MenuService(MenuRepository menuRepository,
                   InventoryRepository inventoryRepository) {

    this.menuRepository = menuRepository;
    this.inventoryRepository = inventoryRepository;
}

    // Convert Entity to DTO
    private MenuDTO convertToDTO(Menu menu) {

        MenuDTO dto = new MenuDTO();

        dto.setItemId(menu.getItemId());
        dto.setItemName(menu.getItemName());

        if (menu.getCategory() != null) {
            dto.setCategoryId(menu.getCategory().getCategoryId());
            dto.setCategoryName(menu.getCategory().getCategoryName());
        }

        dto.setSellingPrice(menu.getSellingPrice());
        dto.setCostPrice(menu.getCostPrice());

        return dto;
    }

    // Get all ACTIVE menu items
    public List<MenuDTO> getAllMenuItems() {

        return menuRepository.findByIsActiveTrue()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get menu item by ID
    public MenuDTO getMenuItemById(Integer id) {

        Menu menu = menuRepository.findById(id)
                .orElseThrow(() ->
                        new MenuNotFoundException("Menu item not found"));

        return convertToDTO(menu);
    }

    // Add new menu item
  public Menu addMenuItem(Menu menu) {

    menu.setIsActive(true);

    Menu savedMenu = menuRepository.save(menu);

    Inventory inventory = new Inventory();

    inventory.setMenu(savedMenu);
    inventory.setCurrentStock(0);
    inventory.setMinimumStock(10);

    try {
        inventoryRepository.save(inventory);
    } catch (Exception e) {
        e.printStackTrace();
        throw e;
    }

    return savedMenu;
}

    // Update existing menu item
    public Menu updateMenuItem(Integer id, Menu updatedMenu) {

        Menu existingMenu = menuRepository.findById(id)
                .orElseThrow(() ->
                        new MenuNotFoundException("Menu item not found"));

        existingMenu.setItemName(updatedMenu.getItemName());
        existingMenu.setCategory(updatedMenu.getCategory());
        existingMenu.setSellingPrice(updatedMenu.getSellingPrice());
        existingMenu.setCostPrice(updatedMenu.getCostPrice());

        return menuRepository.save(existingMenu);
    }

    // Soft Delete
    public void deleteMenuItem(Integer id) {

        Menu menu = menuRepository.findById(id)
                .orElseThrow(() ->
                        new MenuNotFoundException("Menu item not found"));

        menu.setIsActive(false);

        menuRepository.save(menu);
    }
}