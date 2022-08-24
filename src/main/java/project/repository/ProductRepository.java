package project.repository;

import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.model.Client;
import project.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
