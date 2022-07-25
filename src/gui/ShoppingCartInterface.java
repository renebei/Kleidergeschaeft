package gui;

import data.Repository;
import entity.Clothing;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartInterface extends JFrame implements ActionListener {
    private JButton back, checkout;
    private JPanel panel;
    private JList jList;

    private Repository repo;

    public ShoppingCartInterface() {
        super("Shopping Cart");
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        add(panel);
        setVisible(true);
        setSize(1000, 1000);
        repo = new Repository();
        init();
    }

    private void init() {
       /*
        for (Clothing c : repo.getCart()) {
            JButton tmp = new JButton(c.toString());
            tmp.addActionListener(this);
            tmp.setFont(new Font("Arial", Font.PLAIN, 20));
            panel.add(tmp);
        }
        */
        jList = new JList(repo.getCart().toArray());
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(jList);
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jList.setFont(new Font("Arial", Font.PLAIN, 20));
        jList.setBorder(new EmptyBorder(10,50,10,10));
        jList.setFixedCellHeight(60);


        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int id = jList.getSelectedIndex();
                System.out.println(id);
                repo.getCart().remove(id);
                new ShoppingCartInterface();
                dispose();

            }
        });


        panel.add(new JScrollPane(jList), BorderLayout.CENTER);
        back = new JButton("Back");
        back.setPreferredSize(new Dimension(getWidth(), 200));
        back.addActionListener(this);
        back.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(back, BorderLayout.PAGE_END);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            List selectedValues = jList.getSelectedValuesList();
            for (Object o: selectedValues){
                System.out.println(o.toString());
            }
            new Menue();
            dispose();
        }
    }
}
