package project.stuff.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "carted_item", schema = "sys", catalog = "")
public class CartedItemEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "carted_item_id")
    private int cartedItemId;
    @Basic
    @Column(name = "product_id")
    private int productId;
    @Basic
    @Column(name = "cart_id")
    private int cartId;
    @Basic
    @Column(name = "amount")
    private int amount;

    public int getCartedItemId() {
        return cartedItemId;
    }

    public void setCartedItemId(int cartedItemId) {
        this.cartedItemId = cartedItemId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartedItemEntity that = (CartedItemEntity) o;
        return cartedItemId == that.cartedItemId && productId == that.productId && cartId == that.cartId && amount == that.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartedItemId, productId, cartId, amount);
    }
}
