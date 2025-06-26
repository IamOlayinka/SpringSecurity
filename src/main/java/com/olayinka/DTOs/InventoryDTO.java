package com.olayinka.DTOs;

import java.time.LocalDateTime;

public class InventoryDTO {
    private Integer inventoryId;
    private Integer productId;
    private String productName;
    private Integer quantityAdded;
    private Integer quantityRemoved;
    private String reason;
    private LocalDateTime createdAt;

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantityAdded() {
        return quantityAdded;
    }

    public void setQuantityAdded(Integer quantityAdded) {
        this.quantityAdded = quantityAdded;
    }

    public Integer getQuantityRemoved() {
        return quantityRemoved;
    }

    public void setQuantityRemoved(Integer quantityRemoved) {
        this.quantityRemoved = quantityRemoved;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }




}
