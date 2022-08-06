package entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/**
 * @author Rene Beiermann
 */
public class CustomerDAO implements DAO<Customer> {
    private List<Customer> customers;

    public CustomerDAO(List<Customer> customers) {
        this.customers = customers;
    }

    /**
     * @see DAO
     */
    @Override
    public List<Customer> getAll() {
        return customers;
    }

    /**
     * @param c Kunde
     * @see DAO
     */
    @Override
    public boolean save(Customer c) {
        if (customers.contains(c)) return false;
        logOut();
        customers.add(c);
        c.setLogin(true);
        return true;
    }

    /**
     * @param c Kunde
     * @see DAO
     */
    @Override
    public boolean delete(Customer c) {
        return customers.remove(c);
    }

    /**
     * Sucht den aktuell eingeloggten Benutzer.
     *
     * @return Benutzer mit loggedIn = true.
     */
    public Customer getCurrent() {
        for (Customer c : customers) {
            if (c.getLogIn()) return c;
        }
        return null;
    }

    /**
     * Fügt gekaufte Objekte der Bestellhistorie zu.
     *
     * @param clothing Liste von gekauften Kleidungsstücken.
     */
    public void addToHistory(Clothing... clothing) {
        for (Customer c : customers) {
            if (c.getLogIn()) {
                for (int i = 0; i < clothing.length; i++) {
                    clothing[i].setQuantity(1);
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    c.getPurchaseHistory().put(clothing[i], dtf.format(now));
                }
            }
        }
    }

    /**
     * @return Bestellhistorie des eingeloggten Nutzer.
     */
    public Map<Clothing, String> getHistory() {
        for (Customer c : customers) {
            if (c.getLogIn()) {
                return c.getPurchaseHistory();
            }
        }
        return null;
    }

    /**
     * Meldet Nutzer an
     *
     * @param name     Name des Kunden
     * @param password Passwort des Kunden
     * @return Anmelden erfolgreich oder Daten falsch/nicht vorhanden.
     */
    public boolean logIn(String name, String password) {
        logOut();
        for (Customer c : customers) {
            if (c.getName().equals(name) && c.getPassword().equals(password)) {
                c.setLogin(true);
                return true;
            }
        }
        return false;
    }

    /**
     * Meldet Nutzer ab
     */
    public void logOut() {
        for (Customer customer : customers) {
            customer.setLogin(false);
        }
    }
}
