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
public class SampleProteinProducts implements CommandLineRunner,SampleProduct{
    @Autowired
    ProductService productService;
    @Override
    public void run(String... args) throws Exception {
        var proteinNameList= new ArrayList<String>();
        proteinNameList.add("dobrewhey.jpeg");
        proteinNameList.add("proteincookies.jpg");
        proteinNameList.add("weganpwhey.jpg");
        proteinNameList.add("wheycomplex.jpeg");

        int precount=proteinNameList.toArray().length;
        int startingId=14;
        for (int index = 0; index<precount; index++){
            Product product=new Product(Long.valueOf(index+startingId),"ms index "+index+startingId,"desc", Math.toIntExact(index),"whey",100,  "Images/protein/"+proteinNameList.get(index));

            System.out.println(product.toString());
            productService.addProduct(product);
        }


    }
}
