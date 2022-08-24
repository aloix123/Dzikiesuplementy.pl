package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.model.Product;
import project.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;




    public void addProduct(Product product) {
        productRepository.save(product);
    }
    public List<Product> getproducts(){
        return productRepository.findAll();
    }
}
