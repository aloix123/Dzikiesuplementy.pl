package project.sampledata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import project.model.Product;
import project.service.ProductService;

import java.util.ArrayList;

@Component
@Order(1)
public class SamplePreWorkoutProducts implements CommandLineRunner,SampleProduct {
    @Autowired
    ProductService productService;
    @Override
    public void run(String... args) throws Exception {
        var preWorkoutNameList= new ArrayList<String>();
        preWorkoutNameList.add("20569.jpeg");
        preWorkoutNameList.add("boogieman.jpg");
        preWorkoutNameList.add("energizer.jpg");
        preWorkoutNameList.add("max10.jpeg");
        preWorkoutNameList.add("red.jpg");
        int precount=preWorkoutNameList.toArray().length;
        int startingId=9;
        for (int index = 0; index<precount; index++){
            Product product=new Product(Long.valueOf(index+startingId),"ms index "+index+startingId,"desc", Math.toIntExact(index),"preworkout",100, "Images/preworkout/"+preWorkoutNameList.get(index));

            System.out.println(product.toString());
            productService.addProduct(product);
        }


    }
}
