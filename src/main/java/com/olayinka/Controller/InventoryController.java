package com.olayinka.Controller;

import com.olayinka.DTOs.InventoryDTO;
import com.olayinka.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventories")
public class InventoryController {

    @Autowired
    private InventoryService service;

    @GetMapping
    public String getConnect(){
        return "Connected to the controller";
    }
    @GetMapping("/{id}")
    public ResponseEntity<InventoryDTO> getInventory(@PathVariable Integer id){
        InventoryDTO response = service.getInventory(id);

       return ResponseEntity.ok(response);
    }

}
