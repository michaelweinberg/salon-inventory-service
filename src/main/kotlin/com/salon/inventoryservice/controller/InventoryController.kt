package com.salon.inventoryservice.controller

import com.salon.inventoryservice.domain.InventoryItem
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
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
}
