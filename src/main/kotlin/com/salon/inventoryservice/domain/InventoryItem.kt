package com.salon.inventoryservice.domain

data class InventoryItem(
    val id: String,
    val name: String,
    val category: String,
    val quantity: Int,
    val unit: String,
    val reorderThreshold: Int,
)
