package org.poby.techblog.orderItem;

import org.poby.techblog.orderItem.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class OrderItemRepositoryTest {

    @Autowired
    OrderItemRepository orderItemRepository;

}