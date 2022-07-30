package entity;

import java.util.List;

public class CustomerDAO {
    private List<Customer> customers;

    public CustomerDAO(List<Customer> customers) {
        this.customers = customers;
    }

    public boolean addCustomer(Customer c) {
        if (customers.contains(c)) return false;
        customers.add(c);
        c.logIn();
        return true;
    }

    public void removeCustomer(Customer c) {
        customers.remove(c);
    }

    public Customer getCurrent() {
        for (Customer c : customers) {
            if (c.isLoggedIn()) return c;
        }
        return null;
    }
}
