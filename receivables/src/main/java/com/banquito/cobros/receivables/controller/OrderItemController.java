package com.banquito.cobros.receivables.controller;

import com.banquito.cobros.receivables.dto.OrderItemDTO;
import com.banquito.cobros.receivables.dto.OrderItemInfoDTO;
import com.banquito.cobros.receivables.model.OrderItem;
import com.banquito.cobros.receivables.service.OrderItemService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST,
        RequestMethod.PUT })
@RestController
@RequestMapping("/order-items")
public class OrderItemController {

    private final OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @PostMapping
    public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItem orderItem) {
        return ResponseEntity.ok(orderItemService.createOrderItem(orderItem));
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<OrderItemDTO>> getOrderItemsByOrderId(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderItemService.getOrderItemsByOrderId(orderId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItemDTO> getOrderItemById(@PathVariable Long id) {
        return ResponseEntity.ok(orderItemService.getOrderItemById(id));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Void> updateOrderItemStatus(@PathVariable Long id, @RequestParam String status) {
        orderItemService.updateOrderItemStatus(id, status);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<OrderItemInfoDTO>> getOrderItemInfoByCounterpartAndCompanyId(
            @RequestParam Long companyId) {
        List<OrderItemInfoDTO> orderItems = orderItemService.getOrderItemInfoByCompanyId(companyId);
        return ResponseEntity.ok(orderItems);
    }
}
