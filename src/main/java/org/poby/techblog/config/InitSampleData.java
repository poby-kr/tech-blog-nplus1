package org.poby.techblog.config;

import java.util.ArrayList;
import java.util.stream.IntStream;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.poby.techblog.order.Order;
import org.poby.techblog.order.Payment;
import org.poby.techblog.orderItem.OrderItem;
import org.poby.techblog.product.Product;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class InitSampleData {

    private final InitSampleDataService sampleDataService;

    @PostConstruct
    public void init() {
        sampleDataService.init();
    }

    @Component
    static class InitSampleDataService {

        @PersistenceContext
        EntityManager em;

        @Transactional
        public void init() {
            ArrayList<Product> products = new ArrayList<>();
            ArrayList<Order> orders = new ArrayList<>();

            //create Product 2000
            IntStream.rangeClosed(1, 2000).forEach(i -> {
                Product product = Product.builder()
                    .name("product " + i)
                    .price(100 * i)
                    .stockQuantity(10 * i)
                    .build();

                em.persist(product);
                products.add(product);
            });
            //create Order 2000
            IntStream.rangeClosed(1, 2000).forEach(i -> {
                Order order = Order.builder()
                    .payment(i % 2 == 0 ? Payment.CARD : Payment.CASH)
                    .build();

                em.persist(order);
                orders.add(order);
            });
            //create OrderItem 2000
            IntStream.rangeClosed(1, 2000).forEach(i -> {
                OrderItem orderItem = new OrderItem(orders.get(i - 1), products.get(i - 1), i);

                em.persist(orderItem);
            });
        }
    }
}
