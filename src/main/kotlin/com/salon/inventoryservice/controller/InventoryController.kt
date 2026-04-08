package com.salon.inventoryservice.controller

import com.salon.inventoryservice.domain.InventoryItem
import com.salon.inventoryservice.domain.InventoryResponse
import com.salon.inventoryservice.service.InventoryService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/inventory")
class InventoryController(private val inventoryService: InventoryService) {

    @GetMapping
    fun listInventoryItems(
        @RequestParam(required = false) category: String?,
        @RequestParam(required = false) brand: String?,
    ): ResponseEntity<List<InventoryItem>> =
        ResponseEntity.ok(inventoryService.listInventoryItems(category, brand))

    @GetMapping("/{id}")
    fun getInventoryItem(@PathVariable id: String): ResponseEntity<InventoryItem> {
        val item = inventoryService.getInventoryItem(id)
            ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(item)
    }

    @PostMapping
    fun addInventoryItem(@RequestBody item: InventoryItem): ResponseEntity<InventoryResponse> {
        return try {
            inventoryService.addInventoryItem(item)
            ResponseEntity.status(HttpStatus.CREATED)
                .body(InventoryResponse(success = true, message = "Inventory item '${item.name}' added successfully"))
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(InventoryResponse(success = false, message = "Failed to add inventory item: ${e.message}"))
        }
    }
}
