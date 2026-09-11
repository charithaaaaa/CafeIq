package com.cafeiq.controller;

import com.cafeiq.dto.InventoryDTO;
import com.cafeiq.dto.InventoryRequestDTO;
import com.cafeiq.service.InventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@CrossOrigin(origins = {"http://localhost:5173", "https://cafeiq-frontend.vercel.app"})
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    // GET all inventory
    @GetMapping
    public List<InventoryDTO> getAllInventory() {
        return inventoryService.getAllInventory();
    }

    // GET inventory by ID
    @GetMapping("/{id}")
    public InventoryDTO getInventoryById(@PathVariable Integer id) {
        return inventoryService.getInventoryById(id);
    }

    // POST inventory
    @PostMapping
    public InventoryDTO addInventory(@RequestBody InventoryRequestDTO requestDTO) {
        return inventoryService.addInventory(requestDTO);
    }

    // PUT inventory
    @PutMapping("/{id}")
    public InventoryDTO updateInventory(@PathVariable Integer id,
                                        @RequestBody InventoryRequestDTO requestDTO) {

        return inventoryService.updateInventory(id, requestDTO);
    }

    // DELETE inventory
    @DeleteMapping("/{id}")
    public String deleteInventory(@PathVariable Integer id) {

        inventoryService.deleteInventory(id);

        return "Inventory deleted successfully";
    }
}