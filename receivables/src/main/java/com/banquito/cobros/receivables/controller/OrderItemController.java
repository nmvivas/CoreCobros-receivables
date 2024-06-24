package com.banquito.cobros.receivables.controller;

import com.banquito.cobros.receivables.dto.OrderItemDTO;
import com.banquito.cobros.receivables.dto.OrderItemInfoDTO;
import com.banquito.cobros.receivables.model.OrderItem;
import com.banquito.cobros.receivables.service.OrderItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ResponseEntity<List<OrderItemDTO>> getAllOrderItems() {
        return ResponseEntity.ok(orderItemService.getAllOrderItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItemDTO> getOrderItemById(@PathVariable Long id) {
        try {
            OrderItemDTO orderItemDTO = orderItemService.getOrderItemById(id);
            return ResponseEntity.ok(orderItemDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Void> updateOrderItemStatus(@PathVariable Long id, @RequestParam String status) {
        orderItemService.updateOrderItemStatus(id, status);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<OrderItemInfoDTO>> getOrderItemInfoByCompanyId(@RequestParam Long companyId) {
        List<OrderItemInfoDTO> orderItems = orderItemService.getOrderItemInfoByCompanyId(companyId);
        return ResponseEntity.ok(orderItems);
    }

    @GetMapping("/search/by-counterpart")
    public ResponseEntity<List<OrderItemInfoDTO>> getOrderItemInfoByCounterpartAndCompanyId(
            @RequestParam String counterpart, @RequestParam Long companyId) {
        List<OrderItemInfoDTO> orderItems = orderItemService.getOrderItemInfoByCounterpartAndCompanyId(counterpart,
                companyId);
        return ResponseEntity.ok(orderItems);
    }

    @GetMapping("/search/by-type")
    public ResponseEntity<List<OrderItemDTO>> getOrderItemsByReceivableType(@RequestParam String type) {
        List<OrderItemDTO> orderItems = orderItemService.getOrderItemsByReceivableType(type);
        return ResponseEntity.ok(orderItems);
    }
}
