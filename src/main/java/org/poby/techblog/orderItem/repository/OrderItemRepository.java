package org.poby.techblog.orderItem.repository;

import java.util.List;
import org.poby.techblog.orderItem.OrderItem;
import org.poby.techblog.orderItem.repository.jpql.OrderItemJPQLRepository;
import org.poby.techblog.orderItem.repository.querydsl.OrderItemQuerydslRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>, OrderItemQuerydslRepository, OrderItemJPQLRepository {

    @Query("select oi, o, p "
        + "from OrderItem oi "
        + "join oi.order o "
        + "join oi.product p")
    List<OrderItem> getOrderItemsDataJPA(Pageable pageable);

    @EntityGraph(attributePaths = {"product", "order"})
    List<OrderItem> getOrderItemsBy(Pageable pageable);
}
