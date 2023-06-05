package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.model.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class WheyService {
    @Autowired
    ProductService productService;
    public List getproteins(){
        List<Product> list = productService.getproducts();
        List result=new ArrayList();
        for(Product product : list){
            if(product.getType()=="whey"){
                result.add(product);
            }
        }
        return result;
    }
}
