package entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Rene Beiermann
 */
public class Customer {

    private String name;
    private int phoneNr;
    private String address;
    private String eMail;
    private boolean loggedIn;
    private String password;

    private Map<Clothing, String> purchaseHistory;


    public Customer(String name, String address, int phoneNr, String eMail, String password) {
        this.name = name;
        this.address = address;
        this.phoneNr = phoneNr;
        this.eMail = eMail;
        this.loggedIn = false;
        this.password = password;

        purchaseHistory = new HashMap<>();

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + " - ");
        sb.append(address + " - ");
        sb.append("Phone: " + phoneNr);
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(int phoneNr) {
        this.phoneNr = phoneNr;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public boolean getLogIn() {
        return loggedIn;
    }

    public void setLogin(boolean b) {
        this.loggedIn = b;
    }

    public Map<Clothing, String> getPurchaseHistory() {
        return purchaseHistory;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) && Objects.equals(eMail, customer.eMail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNr, address, eMail, loggedIn, password, purchaseHistory);
    }
}
