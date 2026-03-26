package com.salon.inventoryservice.controller

import com.salon.inventoryservice.domain.InventoryItem
import com.salon.inventoryservice.domain.InventoryResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/inventory")
class InventoryController {

    @GetMapping("/{id}")
    fun getInventoryItem(@PathVariable id: String): InventoryItem {
        return InventoryItem(
            id = id,
            name = "Keratin Shampoo",
            category = "Hair Care",
            quantity = 24,
            unit = "bottles",
            reorderThreshold = 5,
        )
    }

    @PostMapping
    fun addInventoryItem(@RequestBody item: InventoryItem): ResponseEntity<InventoryResponse> {
        return try {
            ResponseEntity.status(HttpStatus.CREATED)
                .body(InventoryResponse(success = true, message = "Inventory item '${item.name}' added successfully"))
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(InventoryResponse(success = false, message = "Failed to add inventory item: ${e.message}"))
        }
    }
}
