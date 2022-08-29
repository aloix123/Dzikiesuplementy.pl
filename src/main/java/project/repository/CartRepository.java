package project.repository;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.model.Cart;
import project.model.Client;
@Repository
public interface CartRepository  extends JpaRepository<Cart, Long> {


}
