package project.stuff.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_details", schema = "sys", catalog = "")
public class OrderDetailsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "order_details_id")
    private int orderDetailsId;
    @Basic
    @Column(name = "order_id")
    private int orderId;
    @Basic
    @Column(name = "product_id")
    private int productId;
    @Basic
    @Column(name = "amount_ordered")
    private int amountOrdered;

    public int getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(int orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getAmountOrdered() {
        return amountOrdered;
    }

    public void setAmountOrdered(int amountOrdered) {
        this.amountOrdered = amountOrdered;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailsEntity that = (OrderDetailsEntity) o;
        return orderDetailsId == that.orderDetailsId && orderId == that.orderId && productId == that.productId && amountOrdered == that.amountOrdered;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderDetailsId, orderId, productId, amountOrdered);
    }
}
