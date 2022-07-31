package entity;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @author René Beiermann
 */
public class Customer {

    private String name;
    private int phoneNr;
    private String address;
    private String eMail;
    private boolean loggedIn;

    private Map<Clothing, String> purchaseHistory;

    private long customerID;

    public Customer(String name, String address, int phoneNr, String eMail) {
        this.name = name;
        this.address = address;
        this.phoneNr = phoneNr;
        this.eMail = eMail;
        this.loggedIn = false;
        purchaseHistory = new HashMap<>();
        this.customerID = new Random().nextLong(1000000000000L) + 100000000000L;
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

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
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
}
