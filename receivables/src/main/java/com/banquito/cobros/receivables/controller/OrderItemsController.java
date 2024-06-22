package com.banquito.cobros.receivables.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.banquito.cobros.receivables.dto.OrderItemsDTO;
import com.banquito.cobros.receivables.service.OrderItemsService;
import com.banquito.cobros.receivables.util.mapper.OrderItemsMapper;

@RestController
@RequestMapping("/order-items")
public class OrderItemsController {

    private final OrderItemsService orderItemsService;
    private final OrderItemsMapper orderItemsMapper;

    public OrderItemsController(OrderItemsService orderItemsService, OrderItemsMapper orderItemsMapper) {
        this.orderItemsService = orderItemsService;
        this.orderItemsMapper = orderItemsMapper;
    }

    @PostMapping
    public ResponseEntity<OrderItemsDTO> createOrderItem(@RequestBody OrderItemsDTO orderItemsDTO) {
        try {
            OrderItemsDTO createdOrderItem = orderItemsMapper
                    .toDTO(orderItemsService.createOrderItem(orderItemsMapper.toPersistence(orderItemsDTO)));
            return ResponseEntity.ok(createdOrderItem);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<OrderItemsDTO>> getOrderItemsByOrderId(@PathVariable Long orderId) {
        List<OrderItemsDTO> orderItems = orderItemsService.getOrderItemsByOrderId(orderId)
                .stream()
                .map(orderItemsMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(orderItems);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItemsDTO> getOrderItemById(@PathVariable Long id) {
        try {
            OrderItemsDTO orderItems = orderItemsMapper.toDTO(orderItemsService.getOrderItemById(id));
            return ResponseEntity.ok(orderItems);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Void> updateOrderItemStatus(@PathVariable Long id, @RequestParam String status) {
        try {
            orderItemsService.updateOrderItemStatus(id, status);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
