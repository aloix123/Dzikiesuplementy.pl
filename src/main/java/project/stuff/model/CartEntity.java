package project.stuff.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cart", schema = "sys", catalog = "")
public class CartEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cart_id")
    private int cartId;
    @Basic
    @Column(name = "client_id")
    private int clientId;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartEntity that = (CartEntity) o;
        return cartId == that.cartId && clientId == that.clientId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, clientId);
    }
}
