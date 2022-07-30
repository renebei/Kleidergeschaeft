package data;

import entity.*;

import java.util.List;

/**
 * @author René Beiermann
 */

public class Repository {

    private ClothingDAO clothingDAO;
    private ShoppingCart shoppingCart;
    private CustomerDAO customerDAO;

    public Repository() {
        this.clothingDAO = new ClothingDAO(Testdata.generate().getData());
        this.shoppingCart = ShoppingCart.getInstance();
        this.customerDAO = new CustomerDAO(CustomerBook.getInstance().getCustomers());
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
        c.setQuantity(c.getQuantity() - 1);
    }

    public void removeFromCart(Clothing c) {
        shoppingCart.removeFromCart(c);
        c.setQuantity(c.getQuantity() + 1);
    }

    public List<Clothing> getCart() {
        return shoppingCart.getCart();
    }
    public void emptyCart() {
        shoppingCart.getCart().clear();
    }

    public int calcTotal() {
        return shoppingCart.calcTotal();
    }

    public void purchase() {
        for (Clothing c : getCart()) {
            shoppingCart.getCart().remove(c);
            clothingDAO.sell(c);
        }
    }

    public boolean addCustomer(Customer c) {
        return customerDAO.addCustomer(c);
    }

    public Customer getCurrentCustomer() {
        return customerDAO.getCurrent();
    }
}
