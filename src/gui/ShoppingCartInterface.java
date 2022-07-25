package gui;
/**
 * @author René Beiermann
 */

import data.Repository;
import entity.Clothing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShoppingCartInterface extends JFrame implements ActionListener {
    private JButton back;
    private JPanel panel;

    private Repository repo;

    public ShoppingCartInterface() {
        super("Shopping Cart");
        panel = new JPanel();
        setLayout(new BorderLayout());
        panel.setLayout(new GridLayout(4, 1));
        add(panel, BorderLayout.CENTER);
        setVisible(true);
        setSize(1000, 1000);
        repo = new Repository();
        init();
    }

    private void init() {
        for (Clothing c : repo.getCart()) {
            JButton tmp = new JButton(c.toString());
            tmp.addActionListener(this);
            tmp.setFont(new Font("Arial", Font.PLAIN, 20));
            panel.add(tmp);
        }

        back = new JButton("Back");
        back.addActionListener(this);
        back.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(back);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            new Menue();
            dispose();
        }
    }
}
