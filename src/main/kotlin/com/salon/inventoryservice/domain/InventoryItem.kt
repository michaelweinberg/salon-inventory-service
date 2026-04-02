package com.salon.inventoryservice.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "inventory_items")
data class InventoryItem(
    @Id
    val id: String,
    val name: String,
    val category: String,
    val quantity: Int,
    val unit: String,
    val reorderThreshold: Int,
)
