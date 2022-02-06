package org.poby.techblog.orderItem.repository.jpql;

import java.util.List;
import org.poby.techblog.orderItem.OrderItem;

public interface OrderItemJPQLRepository {

    List<OrderItem> getOrderItemsJPQL();
}
