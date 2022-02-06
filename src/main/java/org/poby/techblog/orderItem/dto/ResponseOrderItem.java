package org.poby.techblog.orderItem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.poby.techblog.order.Order;
import org.poby.techblog.order.Payment;
import org.poby.techblog.orderItem.OrderItem;
import org.poby.techblog.product.Product;

@Data
@Builder
@AllArgsConstructor
public class ResponseOrderItem {

    private Long orderItemId;
    private int quantity;
    private int sumPrice;

    private Long orderId;
    private Payment payment;
    private int total;

    private Long productId;
    private String name;
    private int price;
    private int stockQuantity;

    public static ResponseOrderItem of(OrderItem orderItem) {

        Order order = orderItem.getOrder();
        Product product = orderItem.getProduct();

        return ResponseOrderItem.builder()
            .orderItemId(orderItem.getId())
            .quantity(orderItem.getQuantity())
            .sumPrice(orderItem.getSumPrice())
            .orderId(order.getId())
            .payment(order.getPayment())
            .total(order.getTotal())
            .productId(product.getId())
            .name(product.getName())
            .price(product.getPrice())
            .stockQuantity(product.getStockQuantity())
            .build();
    }
}
