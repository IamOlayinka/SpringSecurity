package com.olayinka.Repository;

import com.olayinka.Model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory, Integer> {
    @Query("SELECT i FROM Inventory i JOIN FETCH i.product WHERE i.inventoryId = :id")
    Optional<Inventory> findByIdWithProduct(@Param("id") Integer id);

}
