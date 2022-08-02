package gui;

import data.Repository;
import entity.Clothing;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @author René Beiermann
 */
public class Checkout extends Activity {
    private JPanel panel;
    private JButton home, cart, purchase, total;
    private JScrollPane pane;
    private JList jList;
    private DefaultListModel model;


    public Checkout() {
        super("Shopping Cart");
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        model = new DefaultListModel();
        jList = new JList(model);
        add(panel);
        setVisible(true);
        setSize(750, 750);
        initList();
        initButtons();
    }

    private void initButtons() {
        Icon homeIcon = new ImageIcon(new ImageIcon("res/home.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        Icon checkoutIcon = new ImageIcon(new ImageIcon("res/money.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        Icon cartIcon = new ImageIcon(new ImageIcon("res/cart.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));


        this.home = new JButton(homeIcon);
        this.home.setFont(new Font("Arial", Font.PLAIN, 20));
        this.home.addActionListener(this);
        this.panel.add(this.home, BorderLayout.SOUTH);

        this.purchase = new JButton(checkoutIcon);
        this.purchase.setFont(new Font("Arial", Font.PLAIN, 20));
        this.purchase.addActionListener(this);
        this.purchase.setPreferredSize(new Dimension(375, 50));
        this.panel.add(this.purchase, BorderLayout.EAST);

        this.cart = new JButton(cartIcon);
        this.cart.setFont(new Font("Arial", Font.PLAIN, 20));
        this.cart.addActionListener(this);
        this.cart.setPreferredSize(new Dimension(375, 50));
        this.panel.add(this.cart, BorderLayout.WEST);

        this.total = new JButton(repo.calcTotal() + "€");
        this.total.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(pane, BorderLayout.NORTH);
        this.panel.add(this.total, BorderLayout.CENTER);
    }

    private void initList() {
        jList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jList.setFont(new Font("Arial", Font.PLAIN, 20));
        jList.setBorder(new EmptyBorder(10, 50, 10, 10));
        jList.setFixedCellHeight(60);
        pane = new JScrollPane(jList);
        model.addElement("Total is: " + repo.calcTotal() + "€");

        if (repo.getCurrentCustomer() != null) {
            insertCurrentUser();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (source == home) {
            new Home();
            dispose();
        } else if (source == cart) {
            new Cart();
        } else if (source == purchase) {
            if (repo.getCurrentCustomer() == null) {
                new Form(this);
            } else {
                repo.purchase(repo.getCart().toArray(new Clothing[0]));
                JOptionPane.showMessageDialog(null, "Purchase completed!");
                new Home();
                dispose();
            }
        }
    }

    public void insertCurrentUser() {
        model.addElement("\n");
        model.addElement("Deliver to: ");
        model.addElement(repo.getCurrentCustomer().toString());
    }
}
