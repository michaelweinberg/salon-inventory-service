package com.salon.inventoryservice.repository

import com.salon.inventoryservice.domain.InventoryItem
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface InventoryRepository : MongoRepository<InventoryItem, String> {
    fun findByCategory(category: String): List<InventoryItem>
    fun findByBrand(brand: String): List<InventoryItem>
    fun findByCategoryAndBrand(category: String, brand: String): List<InventoryItem>
}
