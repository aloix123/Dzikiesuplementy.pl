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
public class SampleCreatineProducts implements CommandLineRunner,SampleProduct {


    @Autowired
    ProductService productService;


    @Override
    public void run(String... args) throws Exception {

        System.out.println("hello gujs");


        var creatineNameList= new ArrayList<String>();
        creatineNameList.add("creatynaczerwona.gif");
        creatineNameList.add("kreatyna.gif");
        creatineNameList.add("kreatyna400sfd.png");
        creatineNameList.add("kreatynamultipower.gif");
        creatineNameList.add("orengkreatine.gif");
        creatineNameList.add("wkcreatine.jpg");
        creatineNameList.add("creatine-monohydrate-kreatyna-w-proszku-500g.jpg");
        creatineNameList.add("rsi.png");
        int sampleproductcount=creatineNameList.toArray().length;

        for (int index = 0; index<sampleproductcount; index++){
            Product product=new Product(Long.valueOf(index+1),"ms index "+index,"desc", Math.toIntExact(index),"creatine",100,creatineNameList.get(index));

            System.out.println(product.toString());
            productService.addProduct(product);
        }

    }


}
