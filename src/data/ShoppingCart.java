package data;

import entity.Clothing;

import java.util.ArrayList;
import java.util.List;

/**
 * @author René Beiermann
 */

class ShoppingCart {
    private List<Clothing> cart;
    private static ShoppingCart shoppingCart;

    private ShoppingCart() {
        cart = new ArrayList<>();
    }

    public static ShoppingCart getInstance() {
        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
        }
        return shoppingCart;
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

    public int calcTotal() {
        int total = 0;
        for (Clothing c : cart) {
            total += c.getCost();
        }
        return total;
    }
}
