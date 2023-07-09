package project.service;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.model.Product;
import project.repository.ProductRepository;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

@Service
public class BasketService {
    @Autowired
    SessionFactory factory;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    ClientService clientService;

    public List<Product> getUserProducts() throws FileNotFoundException {
        int uersId = clientService.getclientid();
        String Sqlproductquery = "SELECT PRODUCTID FROM CART WHERE CLIENTID=" + uersId;
        Session session = factory.openSession();
        SQLQuery productquery = session.createSQLQuery(Sqlproductquery);
        productquery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        var productIdList = productquery.list();
        List<Product> resultlist = new ArrayList<>();
        for (Object object : productIdList) {
            Map row = (Map) object;
            String SQLquery = "SELECT * FROM PRODUCT WHERE ID=" + row.get("PRODUCTID");
            SQLQuery query = session.createSQLQuery(SQLquery);
            query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            List results = query.list();
            List elementList = new ArrayList();
            for (Object t : results) {
                Map r = (Map) t;
                Long id = Long.valueOf(((BigInteger) r.get("ID")).intValue());
                Product userproduct = new Product(id, (String) r.get("NAME"), (String) r.get("DESCRIPTION"), (int) r.get("PRICE"), (String) r.get("TYPE"), (int) r.get("AMOUNT"), (String) r.get("IMAGE"));
                System.out.println(resultlist.contains(userproduct));
                boolean isThesameFlag = true;
                for (Product p : resultlist) {
                    if (userproduct.getName().equals(p.getName())) {
                        p.increaseAmount();
                        isThesameFlag = false;
                    }
                }
                if (isThesameFlag) {
                    resultlist.add(userproduct);
                }
            }
        }
        Collections.sort(resultlist);
        return resultlist;
    }
    public boolean isBacketClear(long userid){
        Session session = factory.openSession();
        Transaction transaction=session.beginTransaction();
        String sqlQuery="SELECT ID FROM CART  WHERE  CLIENTID="+userid;
        var backetlist=session.createSQLQuery(sqlQuery).list();
        return backetlist.isEmpty();


    }
}
