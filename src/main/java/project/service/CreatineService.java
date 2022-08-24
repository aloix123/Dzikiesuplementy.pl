package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.model.Product;

import java.util.ArrayList;
import java.util.List;
@Service
public class CreatineService {
    @Autowired
    ProductService productService;
    public List getCreatines(){
        List<Product> list = productService.getproducts();
        List result=new ArrayList();
        for(Product product : list){
            if(product.getType()=="creatine"){
                result.add(product);
            }
        }
        return result;
    }
}
