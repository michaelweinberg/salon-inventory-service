package com.salon.inventoryservice.service

import com.salon.inventoryservice.domain.InventoryItem
import com.salon.inventoryservice.repository.InventoryRepository
import org.springframework.stereotype.Service

@Service
class InventoryService(private val inventoryRepository: InventoryRepository) {

    fun listInventoryItems(category: String?, brand: String?): List<InventoryItem> = when {
        category != null && brand != null -> inventoryRepository.findByCategoryAndBrand(category, brand)
        category != null -> inventoryRepository.findByCategory(category)
        brand != null -> inventoryRepository.findByBrand(brand)
        else -> inventoryRepository.findAll()
    }

    fun getInventoryItem(id: String): InventoryItem? =
        inventoryRepository.findById(id).orElse(null)

    fun addInventoryItem(item: InventoryItem): InventoryItem =
        inventoryRepository.save(item)
}
