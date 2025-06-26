package com.olayinka.Service;


import com.olayinka.DTOs.InventoryDTO;
import com.olayinka.Model.Inventory;
import com.olayinka.Repository.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryService {

@Autowired
private InventoryRepo inventoryRepo;
private InventoryDTO inventoryDTO;
private Inventory inventory;

    public InventoryDTO getInventory(Integer id ){

     inventory = inventoryRepo.findByIdWithProduct(id)
              .orElseThrow(() -> new RuntimeException("Inventory not found"));

     inventoryDTO.setInventoryId(inventory.getInventoryId());
     inventoryDTO.setProductId(inventory.getProduct().getProductId());
     inventoryDTO.setProductName(inventory.getProduct().getName());
     inventoryDTO.setQuantityAdded(inventory.getQuantityStock());
     inventoryDTO.setQuantityRemoved(inventory.getQuantityRemoved());
     inventoryDTO.setReason(inventory.getReason());
     inventoryDTO.setCreatedAt(inventory.getCreatedAt());


      return inventoryDTO;
    }
}
