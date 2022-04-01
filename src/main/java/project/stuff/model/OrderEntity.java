package project.stuff.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "order", schema = "sys", catalog = "")
public class OrderEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "order_id")
    private int orderId;
    @Basic
    @Column(name = "client_id")
    private int clientId;
    @Basic
    @Column(name = "order_date")
    private Date orderDate;
    @Basic
    @Column(name = "tracking_number")
    private String trackingNumber;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return orderId == that.orderId && clientId == that.clientId && Objects.equals(orderDate, that.orderDate) && Objects.equals(trackingNumber, that.trackingNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, clientId, orderDate, trackingNumber);
    }
}
