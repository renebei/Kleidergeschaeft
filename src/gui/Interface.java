package gui;

import data.Repository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface extends JFrame implements ActionListener {

    private JTextField res;
    private JPanel panel;
    private JButton add, remove, search, checkout;
    private Repository repo;

    public Interface() {
        super("Kleidergeschaeft");
        this.res = new JTextField(10);
        panel = new JPanel();
        setLayout(new BorderLayout());
        panel.setLayout(new GridLayout(4, 4));
        add(panel, BorderLayout.CENTER);
        add(res, BorderLayout.NORTH);
        setVisible(true);
        setSize(1000, 1000);
        res.setFont(new Font("Arial", Font.PLAIN, 40));

        repo = new Repository();

        initButtons();
    }

    private void initButtons() {
        this.add = new JButton("add");
        this.add.addActionListener(this);
        this.add.setFont(new Font("Arial", Font.PLAIN, 40));
        this.panel.add(add);

        this.remove = new JButton("remove");
        this.remove.addActionListener(this);
        this.remove.setFont(new Font("Arial", Font.PLAIN, 40));
        this.panel.add(remove);

        this.search = new JButton("search");
        this.search.addActionListener(this);
        this.search.setFont(new Font("Arial", Font.PLAIN, 40));
        this.panel.add(search);

        this.checkout = new JButton("checkout");
        this.checkout.addActionListener(this);
        this.checkout.setFont(new Font("Arial", Font.PLAIN, 40));
        this.panel.add(checkout);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (source == add) {
            res.setText("add to cart");
        } else if(source == search) {
            res.setText("search for clothings");
        } else if(source == remove) {
            res.setText("remove from cart");
        } else if(source == checkout) {
            res.setText("checkout");
        }
    }
}
