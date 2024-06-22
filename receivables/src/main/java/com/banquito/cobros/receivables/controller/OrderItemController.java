package com.banquito.cobros.receivables.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.banquito.cobros.receivables.dto.OrderItemDTO;
import com.banquito.cobros.receivables.service.OrderItemService;
import com.banquito.cobros.receivables.util.mapper.OrderItemMapper;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {

    private final OrderItemService orderItemService;
    private final OrderItemMapper orderItemMapper;

    public OrderItemController(OrderItemService orderItemService, OrderItemMapper orderItemMapper) {
        this.orderItemService = orderItemService;
        this.orderItemMapper = orderItemMapper;
    }

    @PostMapping
    public ResponseEntity<OrderItemDTO> createOrderItem(@RequestBody OrderItemDTO orderItemDTO) {
        try {
            OrderItemDTO createdOrderItem = orderItemMapper
                    .toDTO(orderItemService.createOrderItem(orderItemMapper.toPersistence(orderItemDTO)));
            return ResponseEntity.ok(createdOrderItem);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<OrderItemDTO>> getOrderItemsByOrderId(@PathVariable Long orderId) {
        List<OrderItemDTO> orderItems = orderItemService.getOrderItemsByOrderId(orderId)
                .stream()
                .map(orderItemMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(orderItems);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItemDTO> getOrderItemById(@PathVariable Long id) {
        try {
            OrderItemDTO orderItem = orderItemMapper.toDTO(orderItemService.getOrderItemById(id));
            return ResponseEntity.ok(orderItem);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Void> updateOrderItemStatus(@PathVariable Long id, @RequestParam String status) {
        try {
            orderItemService.updateOrderItemStatus(id, status);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
