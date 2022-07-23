package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShoppingCartInterface extends JFrame implements ActionListener {
    private JButton back, checkout;
    private JPanel  panel;

    public ShoppingCartInterface() {
        super("Shopping Cart");
        panel = new JPanel();
        setLayout(new BorderLayout());
        panel.setLayout(new GridLayout(4, 4));
        add(panel, BorderLayout.CENTER);
        setVisible(true);
        setSize(1000, 1000);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
