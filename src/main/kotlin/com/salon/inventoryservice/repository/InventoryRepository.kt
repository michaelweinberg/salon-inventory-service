package com.salon.inventoryservice.repository

import com.salon.inventoryservice.domain.InventoryItem
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface InventoryRepository : MongoRepository<InventoryItem, String>
