package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import project.model.Cart;
import project.model.Product;
import project.util.MainPageHandler;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
@Service
public class PreWorkoutService {
    @Autowired
    CartService cartService;
    @Autowired
    ProductService productService;
    @Autowired
    ClientService clientService;
    public List getPreWorkouts(){
        List<Product> list = productService.getproducts();
        List result=new ArrayList();
        for(Product product : list){
            if(product.getType()=="preworkout"){
                result.add(product);
            }
        }
        return result;
    }

}
