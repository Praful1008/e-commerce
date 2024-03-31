package com.pos.sales.Service;

import com.pos.sales.Dao.InventoryRepository;
import com.pos.sales.Entities.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;
    public List<Inventory> getInventory(){
        return this.inventoryRepository.findAll();
    }

    public Inventory addInventory(Inventory inventory){
        return this.inventoryRepository.save(inventory);
    }
}
