package data;

import entity.*;

import java.util.List;
import java.util.Map;

public class Repository {

    private ClothingDAO clothingDAO;
    private ShoppingCart shoppingCart;

    public Repository() {
        this.clothingDAO = new ClothingDAO(Testdata.generate().getData());
        this.shoppingCart = ShoppingCart.getInstance();
    }

    public List<Clothing> search(ClothingType type, int cost) {
        if (cost == 0)
            return clothingDAO.search(type);
        return clothingDAO.search(type, cost);
    }

    public boolean sell(Clothing c) {
        return clothingDAO.sell(c);
    }


    public void addToCart(Clothing c) {
        shoppingCart.addToCart(c);
    }

    public void removeFromCart(Clothing c) {
        shoppingCart.removeFromCart(c);
    }

    public List<Clothing> getCart() {
        return shoppingCart.getCart();
    }

    public void emptyCart() {
        shoppingCart.getCart().clear();
    }
}
