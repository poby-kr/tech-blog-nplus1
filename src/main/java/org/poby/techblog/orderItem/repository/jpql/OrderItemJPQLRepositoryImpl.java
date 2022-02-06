package org.poby.techblog.orderItem.repository.jpql;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.poby.techblog.orderItem.OrderItem;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderItemJPQLRepositoryImpl implements OrderItemJPQLRepository{

    @PersistenceContext
    private final EntityManager em;

    @Override
    public List<OrderItem> getOrderItemsJPQL() {
        String query = "select oi from OrderItem oi "
            + "join fetch oi.order o "
            + "join fetch oi.product p";

        return em.createQuery(query, OrderItem.class)
            .setMaxResults(1000)
            .getResultList();
    }
}
