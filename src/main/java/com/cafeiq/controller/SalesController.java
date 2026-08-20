package com.cafeiq.controller;

import com.cafeiq.dto.SalesDTO;
import com.cafeiq.dto.SalesRequestDTO;
import com.cafeiq.service.SalesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
@CrossOrigin(origins = "http://localhost:5173")
public class SalesController {

    private final SalesService salesService;

    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    // GET all sales
    @GetMapping
    public List<SalesDTO> getAllSales() {
        return salesService.getAllSales();
    }

    // GET sale by ID
    @GetMapping("/{id}")
    public SalesDTO getSaleById(@PathVariable Integer id) {
        return salesService.getSaleById(id);
    }

    // POST new sale
    @PostMapping
    public SalesDTO addSale(@RequestBody SalesRequestDTO requestDTO) {
        return salesService.addSale(requestDTO);
    }

    // DELETE sale
    @DeleteMapping("/{id}")
    public String deleteSale(@PathVariable Integer id) {

        salesService.deleteSale(id);

        return "Sale deleted successfully";
    }

}