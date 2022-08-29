package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.model.Cart;
import project.repository.CartRepository;

import javax.persistence.SecondaryTable;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    ClientService clientService;

    public void saveCart(Cart cart) {
        cartRepository.save(cart);

    }

}
