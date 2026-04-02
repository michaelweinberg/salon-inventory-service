package com.salon.inventoryservice.service

import com.salon.inventoryservice.domain.InventoryItem
import com.salon.inventoryservice.repository.InventoryRepository
import org.springframework.stereotype.Service

@Service
class InventoryService(private val inventoryRepository: InventoryRepository) {

    fun getInventoryItem(id: String): InventoryItem? =
        inventoryRepository.findById(id).orElse(null)

    fun addInventoryItem(item: InventoryItem): InventoryItem =
        inventoryRepository.save(item)
}
