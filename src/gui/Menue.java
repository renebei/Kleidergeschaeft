package gui;

import data.Repository;
import data.ShoppingCart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menue extends JFrame implements ActionListener {

    private JTextField res;
    private JPanel panel;
    private JButton search, checkout;

    private ShoppingCart shoppingCart;
    private Repository repo;

    public Menue() {
        super("Store");
        init();
        repo = new Repository();
        shoppingCart = new ShoppingCart();
    }

    public Menue(Menue m) {
        super("Store");
        init();
        repo = m.repo;
        shoppingCart = m.shoppingCart;
    }

    private void init() {
        this.res = new JTextField(10);
        panel = new JPanel();
        setLayout(new BorderLayout());
        panel.setLayout(new GridLayout(4, 4));
        add(panel, BorderLayout.CENTER);
        add(res, BorderLayout.NORTH);
        setVisible(true);
        setSize(1000, 1000);
        res.setFont(new Font("Arial", Font.PLAIN, 40));
        initButtons();
    }

    private void initButtons() {
        this.search = new JButton("Search for Clothes");
        this.search.addActionListener(this);
        this.search.setFont(new Font("Arial", Font.PLAIN, 40));
        this.panel.add(search);

        this.checkout = new JButton("Shopping Cart");
        this.checkout.addActionListener(this);
        this.checkout.setFont(new Font("Arial", Font.PLAIN, 40));
        this.panel.add(checkout);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (source == search) {
            new SearchInterface(this);
            dispose();
        } else if (source == checkout) {
            res.setText("checkout");
        }
    }

    public Repository getRepo() {
        return repo;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

}
