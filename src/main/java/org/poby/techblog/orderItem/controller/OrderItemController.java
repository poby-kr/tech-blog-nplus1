package org.poby.techblog.orderItem.controller;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.poby.techblog.orderItem.dto.ResponseOrderItem;
import org.poby.techblog.orderItem.repository.OrderItemRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order-items")
public class OrderItemController {

    private final OrderItemRepository repository;

    @GetMapping({"/querydsl"})
    public ResponseEntity<List<ResponseOrderItem>> getOrderItems() {
        return ResponseEntity.ok(repository.getOrderItems().stream().map(ResponseOrderItem::of).collect(Collectors.toList()));
    }

    @GetMapping("/data-jpa")
    public ResponseEntity<List<ResponseOrderItem>> getOrderItemsDataJPA() {
        return ResponseEntity.ok(repository.getOrderItemsBy(PageRequest.of(0, 1000)).stream().map(ResponseOrderItem::of).collect(Collectors.toList()));
    }

    @GetMapping("/jpql")
    public ResponseEntity<List<ResponseOrderItem>> getOrderItemsJPQL() {
        return ResponseEntity.ok(repository.getOrderItemsJPQL().stream().map(ResponseOrderItem::of).collect(Collectors.toList()));
    }
}
