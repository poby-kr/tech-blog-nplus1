package org.poby.techblog.orderItem.repository.querydsl;

import static org.poby.techblog.order.QOrder.order;
import static org.poby.techblog.orderItem.QOrderItem.orderItem;
import static org.poby.techblog.product.QProduct.product;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.poby.techblog.orderItem.OrderItem;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderItemQuerydslRepositoryImpl implements OrderItemQuerydslRepository{

    private final JPAQueryFactory factory;

    @Override
    public List<OrderItem> getOrderItems() {
        return factory
            .selectFrom(orderItem)
            .join(orderItem.order, order).fetchJoin()
            .join(orderItem.product, product).fetchJoin()
            .limit(1000)
            .fetch();
    }
}
