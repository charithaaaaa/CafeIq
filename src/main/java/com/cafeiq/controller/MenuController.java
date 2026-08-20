package com.cafeiq.controller;

import com.cafeiq.dto.MenuDTO;
import com.cafeiq.entity.Menu;
import com.cafeiq.service.MenuService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
@CrossOrigin(origins = "http://localhost:5173")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    public List<MenuDTO> getAllMenuItems() {
        return menuService.getAllMenuItems();
    }

    @GetMapping("/{id}")
    public MenuDTO getMenuItemById(@PathVariable Integer id) {
        return menuService.getMenuItemById(id);
    }

   @PostMapping
public String addMenuItem(@RequestBody Menu menu) {

    menuService.addMenuItem(menu);

    return "Menu item added successfully";
}

    @PutMapping("/{id}")
    public Menu updateMenuItem(@PathVariable Integer id,
                               @RequestBody Menu updatedMenu) {
        return menuService.updateMenuItem(id, updatedMenu);
    }

    @DeleteMapping("/{id}")
    public String deleteMenuItem(@PathVariable Integer id) {
        menuService.deleteMenuItem(id);
        return "Menu item deleted successfully";
    }
}