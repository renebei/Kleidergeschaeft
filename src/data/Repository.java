package data;

import entity.*;

import java.util.List;
import java.util.Map;

/**
 * Das Repository ist die Schnittstelle für alle Daten. Von hier greifen die Views auf Daten zu.
 *
 * @author René Beiermann, Maximilian Krebs
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

    /**
     * Sucht Kleidungen Anhand der gegebenen Parameter.
     * Nutzer kann nach type (und cost) die Suche beschränken.
     * cost darf 0 sein. In dem Fall wird Preis ignoriert.
     *
     * @param type Kleidungsstück
     * @param cost Preis
     * @return Ergebnisse der Suche.
     * @author René Beiermann
     */
    public List<Clothing> search(Type type, int cost) {
        if (cost == 0)
            return clothingDAO.search(type);
        return clothingDAO.search(type, cost);
    }

    /**
     * @param c Kleidungsstück für den Warenkorb
     * @author René Beiermann
     */
    public void addToCart(Clothing c) {
        shoppingCart.addToCart(c);
        c.setQuantity(c.getQuantity() - 1);
    }

    /**
     * @param c Kleidungsstück für den Warenkorb
     * @author Maximilian Krebs
     */
    public void removeFromCart(Clothing c) {
        shoppingCart.removeFromCart(c);
        c.setQuantity(c.getQuantity() + 1);
    }

    public List<Clothing> getCart() {
        return shoppingCart.getCart();
    }

    /**
     * Errechnet den Inhalt des Warenkorb in Euro
     *
     * @return Gesamtsumme
     * @author René Beiermann
     */
    public int calcTotal() {
        int total = 0;
        for (Clothing c : shoppingCart.getCart()) {
            total += c.getCost();
        }
        return total;
    }

    /**
     * @param clothing Liste von Kleidungsstücken die gekauft werden.
     * @author René Beiermann
     */
    public void purchase(Clothing... clothing) {
        shoppingCart.getCart().clear();
        customerDAO.addToHistory(clothing);
    }

    public boolean addCustomer(Customer c) {
        return customerDAO.save(c);
    }

    public Customer getCurrentCustomer() {
        return customerDAO.getCurrent();
    }

    public Map<Clothing, String> getHistory() {
        return customerDAO.getHistory();
    }

    /**
     * Meldet einen neuen Benutzer an.
     *
     * @param name     Benutzername des anzumeldenden.
     * @param password Passwort des anzumeldenden.
     * @return Erfolgreich eingeloggt oder nicht
     */
    public boolean logInCustomer(String name, String password) {
        return customerDAO.logIn(name, password);
    }
}
