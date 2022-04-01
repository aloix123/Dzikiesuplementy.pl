package project.stuff.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "reviews", schema = "sys", catalog = "")
public class ReviewsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "review_id")
    private int reviewId;
    @Basic
    @Column(name = "product_id")
    private int productId;
    @Basic
    @Column(name = "stars_amount")
    private int starsAmount;

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getStarsAmount() {
        return starsAmount;
    }

    public void setStarsAmount(int starsAmount) {
        this.starsAmount = starsAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewsEntity that = (ReviewsEntity) o;
        return reviewId == that.reviewId && productId == that.productId && starsAmount == that.starsAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewId, productId, starsAmount);
    }
}
