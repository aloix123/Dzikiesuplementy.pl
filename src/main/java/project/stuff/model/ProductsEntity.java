package project.stuff.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "products", schema = "sys", catalog = "")
public class ProductsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_id")
    private int productId;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "category_id")
    private int categoryId;
    @Basic
    @Column(name = "review_id")
    private int reviewId;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "price")
    private double price;
    @Basic
    @Column(name = "discount")
    private Integer discount;
    @Basic
    @Column(name = "amount_in_stock")
    private int amountInStock;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public int getAmountInStock() {
        return amountInStock;
    }

    public void setAmountInStock(int amountInStock) {
        this.amountInStock = amountInStock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductsEntity that = (ProductsEntity) o;
        return productId == that.productId && categoryId == that.categoryId && reviewId == that.reviewId && Double.compare(that.price, price) == 0 && amountInStock == that.amountInStock && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(discount, that.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, title, categoryId, reviewId, description, price, discount, amountInStock);
    }
}
