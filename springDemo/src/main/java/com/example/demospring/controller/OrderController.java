package com.example.demospring.controller;

import com.example.demospring.service.OrderService;
import com.example.demospring.specification.SearchBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin()
@RestController
@RequestMapping("api/v1/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> getAllOrders(@RequestBody SearchBody search) {
        return ResponseEntity.ok(orderService.findAllAndSorting(search));
    }
}
