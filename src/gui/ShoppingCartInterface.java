package gui;

import data.Repository;
import entity.Clothing;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ShoppingCartInterface extends JFrame implements ActionListener {
    private JButton back, delete, checkout;
    private JPanel panel;
    private JScrollPane pane;
    private JList jList;
    private DefaultListModel model;
    private Repository repo;

    public ShoppingCartInterface() {
        super("Shopping Cart");
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        model = new DefaultListModel();
        jList = new JList(model);
        add(panel);
        setVisible(true);
        setSize(1000, 1000);
        repo = new Repository();
        init();
    }

    private void init() {
        initList();
        initButtons();
    }

    private void initList() {
        jList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jList.setFont(new Font("Arial", Font.PLAIN, 20));
        jList.setBorder(new EmptyBorder(10, 50, 10, 10));
        jList.setFixedCellHeight(60);
        pane = new JScrollPane(jList);
        for (Clothing c : repo.getCart()) {
            model.addElement(c);
        }
    }

    private void initButtons() {

        delete = new JButton("delete");
        delete.setFont(new Font("Arial", Font.PLAIN, 20));
        delete.setPreferredSize(new Dimension(500, 50));
        delete.addActionListener(this);

        checkout = new JButton("Checkout");
        checkout.setFont(new Font("Arial", Font.PLAIN, 20));
        checkout.setPreferredSize(new Dimension(500, 100));
        checkout.addActionListener(this);

        back = new JButton("Back");
        back.addActionListener(this);
        back.setPreferredSize(new Dimension(500, 50));
        back.setFont(new Font("Arial", Font.PLAIN, 20));

        panel.add(checkout, BorderLayout.SOUTH);
        panel.add(delete, BorderLayout.WEST);
        panel.add(pane, BorderLayout.NORTH);
        panel.add(back, BorderLayout.EAST);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            List selectedValues = jList.getSelectedValuesList();
            for (Object o : selectedValues) {
                System.out.println(o.toString());
            }
            new Menue();
            dispose();
        } else if (e.getSource() == checkout) {
            for (Clothing c : repo.getCart()) {
                repo.sell(c);
            }
            repo.emptyCart();
            new Menue();
            dispose();
        } else if (e.getSource() == delete) {
            int counter = 0;
            for (int i : jList.getSelectedIndices()) {
                if (model.getSize() > 0) {
                    repo.removeFromCart((Clothing) model.get(i - counter));
                    model.remove(i - counter);
                    counter++;
                }
            }
        }
    }
}