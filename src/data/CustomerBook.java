package data;

import entity.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author René Beiermann
 */
class CustomerBook {

    private static CustomerBook customerBook;
    private List<Customer> customers;

    private CustomerBook() {
        customers = new ArrayList<>();
    }

    public static CustomerBook getInstance() {
        if (customerBook == null) {
            customerBook = new CustomerBook();
        }
        return customerBook;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

}
