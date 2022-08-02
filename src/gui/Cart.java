package gui;

import entity.Clothing;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 * Warenkorb GUI
 *
 * @author Maximilian Krebs
 */
public class Cart extends Activity {
    private JButton back, delete, checkout;
    private JPanel panel;
    private JScrollPane pane;
    private JList<Clothing> jList;
    private DefaultListModel<Clothing> model;

    public Cart() {
        super("Shopping Cart");
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        model = new DefaultListModel<Clothing>();
        jList = new JList<Clothing>(model);
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
     * Initialisiert die Liste die den Inhalt des Warenkorb listet.
     */
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

    /**
     * Initialisiert die Knöpfe und weißt Ihnen die passenden Bilder zu.
     */
    private void initButtons() {
        Icon homeIcon = new ImageIcon(new ImageIcon("res/home.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        Icon deleteIcon = new ImageIcon(new ImageIcon("res/delete.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        Icon checkoutIcon = new ImageIcon(new ImageIcon("res/money.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));


        delete = new JButton(deleteIcon);
        delete.setFont(new Font("Arial", Font.PLAIN, 20));
        delete.setPreferredSize(new Dimension(375, 50));
        delete.addActionListener(this);

        checkout = new JButton(checkoutIcon);
        checkout.setFont(new Font("Arial", Font.PLAIN, 20));
        checkout.setPreferredSize(new Dimension(375, 50));
        checkout.addActionListener(this);

        back = new JButton(homeIcon);
        back.addActionListener(this);
        back.setPreferredSize(new Dimension(375, 100));

        panel.add(back, BorderLayout.SOUTH);
        panel.add(checkout, BorderLayout.EAST);
        panel.add(pane, BorderLayout.NORTH);
        panel.add(delete, BorderLayout.WEST);
    }

    /**
     * {@link #checkout} Leitet Nutzer zu der Oberflaeche wo er bestellt.
     * {@link #delete} Löscht Eintrag aus Warenkorb.
     * {@link #back} Bringt Nutzer ins Hauptmenue.
     *
     * @see Activity
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            List<Clothing> selectedValues = jList.getSelectedValuesList();
            for (Object o : selectedValues) {
                System.out.println(o.toString());
            }
            new Home();
            dispose();
        } else if (e.getSource() == checkout) {
            new Checkout();
            dispose();
        } else if (e.getSource() == delete) {
            int counter = 0;
            if (jList.getSelectedIndices().length == 0)
                JOptionPane.showMessageDialog(null, "Select items to delete.");
            for (int i : jList.getSelectedIndices()) {
                if (model.getSize() > 0) {
                    repo.removeFromCart(model.get(i - counter));
                    model.remove(i - counter);
                    counter++;
                }
            }
        }
    }
}