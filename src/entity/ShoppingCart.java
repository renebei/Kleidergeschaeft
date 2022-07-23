package entity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Clothing> cart;

    public ShoppingCart() {
        cart = new ArrayList<>();
    }

    public void addToCart(Clothing c) {
        cart.add(c);
    }

    public void removeFromCart(Clothing c) {
        cart.remove(c);
    }
}
