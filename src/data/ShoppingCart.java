package data;

import entity.Clothing;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Clothing> cart;

    public ShoppingCart() {
        cart = new ArrayList<>();
    }

    public void addToCart(Clothing c) {
        cart.add(c);
    }

    public void removeFromCart(Clothing c) {
        cart.remove(c);
    }

    public List<Clothing> getCart() {
        return cart;
    }
}
