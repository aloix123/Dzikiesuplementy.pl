package project.service;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.model.Cart;
import project.repository.CartRepository;

import javax.persistence.SecondaryTable;
import java.math.BigInteger;
import java.util.Map;

@Service
public class CartService {
    @Autowired
    SessionFactory factory;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    ClientService clientService;

    public void saveCart(Cart cart) {
        cartRepository.save(cart);

    }
    public void deleteCartById(long id){
        cartRepository.deleteById(id);
    }
    public void deletCartByProductId(long id){
        Session session = factory.openSession();
        String sqlQuery="SELECT ID FROM CART  WHERE  PRODUCTID="+id;
        SQLQuery productquery = session.createSQLQuery(sqlQuery);
        productquery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        var productIdList = productquery.list();
        for(Object object : productIdList) {
            Map row = (Map) object;
            Long localId = Long.valueOf(((BigInteger) row.get("ID")).intValue());
            cartRepository.deleteById(localId);
            break;
        }



    }
    public  void clearCart(){
        cartRepository.deleteAll();
    }

}
