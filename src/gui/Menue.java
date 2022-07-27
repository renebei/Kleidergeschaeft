package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author René Beiermann
 */

public class Menue extends JFrame implements ActionListener {

    private JPanel panel;
    private JButton search, cart;

    public Menue() {
        super("Store");
        panel = new JPanel();
        setLayout(new BorderLayout());
        panel.setLayout(new GridLayout(1,1));
        setSize(1000, 1000);
        add(panel, BorderLayout.CENTER);
        setVisible(true);
        initButtons();
    }


    private void initButtons() {
        this.search = new JButton(new ImageIcon("res/search.png"));
        this.search.addActionListener(this);
        this.search.setFont(new Font("Arial", Font.PLAIN, 40));
        this.panel.add(search);

        this.cart = new JButton(new ImageIcon("res/cart.png"));
        this.cart.addActionListener(this);
        this.cart.setFont(new Font("Arial", Font.PLAIN, 40));
        this.panel.add(cart, BorderLayout.LINE_END);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (source == search) {
            new SearchInterface();
            dispose();
        } else if (source == cart) {
            new ShoppingCartInterface();
            dispose();
        }
    }
}
