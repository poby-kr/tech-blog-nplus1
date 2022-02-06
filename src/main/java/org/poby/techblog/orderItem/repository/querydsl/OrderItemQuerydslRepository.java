package org.poby.techblog.orderItem.repository.querydsl;

import java.util.List;
import org.poby.techblog.orderItem.OrderItem;

public interface OrderItemQuerydslRepository {

    List<OrderItem> getOrderItems();
}
