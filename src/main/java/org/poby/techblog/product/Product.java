package org.poby.techblog.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.poby.techblog.product.exception.NotEnoughStockQuantityException;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    public void order(int orderStockQuantity) {

        int remain = stockQuantity - orderStockQuantity;

        if (remain < 0) {
            throw new NotEnoughStockQuantityException("주문 수량이 재고 수량을 초과합니다.");
        }

        stockQuantity = remain;
    }
}
