package com.salon.inventoryservice.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "inventory_items")
data class InventoryItem(
    @Id
    val id: String? = null,
    val sku: String,
    val name: String,
    val category: String,
    val subCategory: String,
    val brand: String,
    val description: String,
    val price: Double,
    val costPrice: Double,
    val stock: Int,
    val lowStockThreshold: Int,
    val unit: String,
    val weight: Weight,
    val attributes: Map<String, Any>,
    val supplier: Supplier,
    val active: Boolean,
)

data class Weight(
    val value: Double,
    val unit: String,
)

data class Supplier(
    val name: String,
    val contactEmail: String,
)
