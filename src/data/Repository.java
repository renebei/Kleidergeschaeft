package data;

import entity.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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

    public List<Clothing> search(Type type, int cost) {
        if (cost == 0)
            return clothingDAO.search(type);
        return clothingDAO.search(type, cost);
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

    public int calcTotal() {
        return shoppingCart.calcTotal();
    }

    public void purchase(Clothing... clothing) {
       shoppingCart.getCart().clear();
       customerDAO.addToHistory(clothing);
    }

    public boolean addCustomer(Customer c) {
        return customerDAO.addCustomer(c);
    }

    public Customer getCurrentCustomer() {
        return customerDAO.getCurrent();
    }

    public Map<Clothing, String> getHistory() {
        return customerDAO.getHistory();
    }
}
