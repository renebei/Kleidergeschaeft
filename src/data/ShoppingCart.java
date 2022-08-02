package data;

import entity.Clothing;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasse nach Singelton pattern. Verwaltet die zu kaufenden Kleidungsstücke.
 *
 * @author René Beiermann
 */

class ShoppingCart {
    private List<Clothing> cart;
    private static ShoppingCart shoppingCart;

    private ShoppingCart() {
        cart = new ArrayList<>();
    }

    /**
     * Diese Methode implementiert das Singelton pattern.
     *
     * @return das Singelton.
     */
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
}
