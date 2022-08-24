package project.sampledata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import project.model.Product;
import project.repository.ProductRepository;
import project.service.ProductService;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;

@Component
@Order(1)
public class SampleProducts implements CommandLineRunner {


    @Autowired
    ProductService productService;


    @Override
    public void run(String... args) throws Exception {

        System.out.println("hello gujs");

        int sampleproductcount=10;
        for (Long index = Long.valueOf(0); index<sampleproductcount; index++){
            File file = new File("static/Images/kreatyna.gif");
            BufferedImage bImage = ImageIO.read(new File("src/main/resources/static/Images/Projekt-bez-tytulu-2.jpg"));
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(bImage, "jpg", bos );
            byte [] data = bos.toByteArray();
            Product product=new Product(index+1,"ms index "+index,"desc", Math.toIntExact(index),"creatine",100,data);

            System.out.println(product.toString());
            productService.addProduct(product);
        }

    }
}
