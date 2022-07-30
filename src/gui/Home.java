package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author René Beiermann
 */

public class Home extends JFrame implements ActionListener {

    private JPanel panel;
    private JButton search, cart;

    public Home() {
        super("Store");
        panel = new JPanel();
        setLayout(new BorderLayout());
        panel.setLayout(new GridLayout(1,1));
        setSize(750, 750);
        add(panel, BorderLayout.CENTER);
        setVisible(true);
        initButtons();
        panel.validate();

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
            new Search();
            dispose();
        } else if (source == cart) {
            new Cart();
            dispose();
        }
    }
}
