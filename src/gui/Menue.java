package gui;

import data.Repository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menue extends JFrame implements ActionListener {

    private JPanel panel;
    private JButton search, checkout;

    public Menue() {
        super("Store");
        panel = new JPanel();
        setLayout(new BorderLayout());
        panel.setLayout(new GridLayout(4, 4));
        add(panel, BorderLayout.CENTER);
        setVisible(true);
        setSize(1000, 1000);

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
            new SearchInterface();
            dispose();
        } else if (source == checkout) {
            new ShoppingCartInterface();
            dispose();
        }
    }
}
