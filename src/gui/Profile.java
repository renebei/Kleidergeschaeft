package gui;

import data.Repository;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author René Beiermann
 */

public class Profile extends JFrame implements ActionListener {

    private JButton home, delete, checkout;
    private JPanel panel;
    private JScrollPane pane;
    private JList jList;
    private DefaultListModel model;
    private Repository repo;

    public Profile() {
        super("Profile");
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        model = new DefaultListModel();
        jList = new JList(model);
        add(panel);
        setVisible(true);
        setSize(750, 750);
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
        for (var entry : repo.getHistory().entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(entry.getKey() +  " | " + entry.getValue().toString() + "\n");
            model.addElement(sb.toString());
        }
    }

    private void initButtons() {
        Icon homeIcon = new ImageIcon(new ImageIcon("res/home.png").getImage().getScaledInstance(60,60, Image.SCALE_DEFAULT));

        checkout = new JButton(repo.getCurrentCustomer().getAddress());
        checkout.setFont(new Font("Arial", Font.PLAIN, 20));
        checkout.setPreferredSize(new Dimension(375, 50));

        delete = new JButton(repo.getCurrentCustomer().getName());
        delete.setFont(new Font("Arial", Font.PLAIN, 20));
        delete.setPreferredSize(new Dimension(375, 50));

        home = new JButton(homeIcon);
        home.addActionListener(this);
        home.setPreferredSize(new Dimension(375, 100));


        panel.add(home, BorderLayout.NORTH);
        panel.add(checkout, BorderLayout.EAST);
        panel.add(pane, BorderLayout.SOUTH);
        panel.add(delete, BorderLayout.WEST);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if(source == home) {
            new Home();
            dispose();
        }
    }
}
