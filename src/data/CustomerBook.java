package data;

import entity.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasse nach Singelton pattern.
 *
 * @author Rene Beiermann
 */
class CustomerBook {

    private static CustomerBook customerBook;
    private List<Customer> customers;

    private CustomerBook() {
        customers = new ArrayList<>();
    }

    /**
     * Diese Methode implementiert das Singelton pattern.
     *
     * @return das Singelton.
     */
    public static CustomerBook getInstance() {
        if (customerBook == null) {
            customerBook = new CustomerBook();
            customerBook.getCustomers().add(new Customer("Max234", "Musterweg", 12345, "maxEmail", "password1"));
            customerBook.getCustomers().add(new Customer("Babara Beispiel", "Beispielweg", 12345, "babaraEmail", "password2"));
        }
        return customerBook;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

}
