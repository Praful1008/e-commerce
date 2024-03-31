package com.pos.sales.Controller;

import com.pos.sales.Entities.Brand;
import com.pos.sales.Entities.Inventory;
import com.pos.sales.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/inventory")
    public List<Inventory> getInventory() {
        return this.inventoryService.getInventory();
    }

    @PostMapping("/inventory")
    public Inventory addInventory(@RequestBody Inventory inventory) {
        return this.inventoryService.addInventory(inventory);
    }
}
