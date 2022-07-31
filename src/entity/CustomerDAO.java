package entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/**
 * @author René Beiermann
 */
public class CustomerDAO {
    private List<Customer> customers;

    public CustomerDAO(List<Customer> customers) {
        this.customers = customers;
    }

    public boolean addCustomer(Customer c) {
        if (customers.contains(c)) return false;
        customers.add(c);
        c.setLogin(true);
        return true;
    }

    public void removeCustomer(Customer c) {
        customers.remove(c);
    }

    public Customer getCurrent() {
        for (Customer c : customers) {
            if (c.getLogIn()) return c;
        }
        return null;
    }

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

    public Map<Clothing, String> getHistory() {
        for (Customer c : customers) {
            if (c.getLogIn()) {
                return c.getPurchaseHistory();
            }
        }
        return null;
    }
}
