package gui;

import entity.Clothing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartInterface extends JFrame implements ActionListener {
    private List<Clothing> cart;
    private JButton back, checkout;
    private JPanel  panel;

    public ShoppingCartInterface() {
        super("Shopping Cart");
        cart = new ArrayList<>();
        panel = new JPanel();
        setLayout(new BorderLayout());
        panel.setLayout(new GridLayout(4, 4));
        add(panel, BorderLayout.CENTER);
        setVisible(true);
        setSize(1000, 1000);
    }

    public void addToCart(Clothing c) {
        cart.add(c);
    }
    public void removeFromCart(Clothing c) {
        cart.remove(c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
