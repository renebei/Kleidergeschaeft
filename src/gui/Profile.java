package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Profil des Nutzer
 *
 * @author Rene Beiermann
 */

public class Profile extends Activity {

    private JButton home, delete, logout;
    private JPanel panel;
    private JScrollPane pane;
    private JList jList;
    private DefaultListModel model;

    public Profile() {
        super("Profile");
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        model = new DefaultListModel();
        jList = new JList(model);
        add(panel);
        setVisible(true);
        setSize(750, 750);
        init();
    }

    private void init() {
        initList();
        initButtons();
    }

    /**
     * Füllt Profil mit einer Liste der zuletzt bestellten Kleider.
     *
     * @see entity.Customer
     */
    private void initList() {
        jList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jList.setFont(new Font("Arial", Font.PLAIN, 20));
        jList.setBorder(new EmptyBorder(10, 50, 10, 10));
        jList.setFixedCellHeight(60);
        pane = new JScrollPane(jList);
        for (var entry : repo.getHistory().entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(entry.getKey() + "   |   " + entry.getValue() + "\n");
            model.addElement(sb.toString());
        }
    }

    private void initButtons() {
        Icon homeIcon = new ImageIcon(new ImageIcon("res/home.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        logout = new JButton(new ImageIcon("res/logout.png"));
        logout.addActionListener(this);
        logout.setFont(new Font("Arial", Font.PLAIN, 20));
        logout.setPreferredSize(new Dimension(375, 50));

        delete = new JButton(repo.getCurrentCustomer().getName());
        delete.setFont(new Font("Arial", Font.PLAIN, 20));
        delete.setPreferredSize(new Dimension(375, 50));

        home = new JButton(homeIcon);
        home.addActionListener(this);
        home.setPreferredSize(new Dimension(375, 100));


        panel.add(home, BorderLayout.NORTH);
        panel.add(logout, BorderLayout.EAST);
        panel.add(pane, BorderLayout.SOUTH);
        panel.add(delete, BorderLayout.WEST);
    }

    /**
     * {@link #home} Hauptmenue.
     * {@link #logout} Meldet angemeldeten Nutzer ab.
     *
     * @see Home
     * @see Activity
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (source == home) {
            new Home();
            dispose();
        } else if (source == logout) {
            repo.getCurrentCustomer().setLogin(false);
            new Home();
            dispose();
        }
    }
}
