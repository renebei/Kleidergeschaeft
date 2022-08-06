package gui;

import data.Repository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Hauptmenue
 *
 * @author Rene Beiermann
 */

public class Home extends Activity {

    private JPanel panel;
    private JButton search, cart, profile;

    public Home() {
        super("Home");
        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        add(panel);
        setVisible(true);
        setSize(750, 750);
        initButtons();
        panel.validate();

    }

    private void initButtons() {
        this.profile = new JButton(new ImageIcon("res/profile.png"));
        this.profile.addActionListener(this);
        this.profile.setFont(new Font("Arial", Font.PLAIN, 40));
        this.panel.add(profile);

        this.search = new JButton(new ImageIcon("res/search.png"));
        this.search.addActionListener(this);
        this.search.setFont(new Font("Arial", Font.PLAIN, 40));
        this.panel.add(search);

        this.cart = new JButton(new ImageIcon("res/cart.png"));
        this.cart.addActionListener(this);
        this.cart.setFont(new Font("Arial", Font.PLAIN, 40));
        this.panel.add(cart);
    }

    /**
     * {@link #search} Fuehrt zu Shopkatalog.
     * {@link #cart} Fuehrt zu Warenkorb.
     * {@link #profile} Prueft ob eingeloggt. Wenn ja zum Profile wenn nein einloggen.
     *
     * @see Activity
     * @see Form
     * @see Search
     * @see Profile
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (source == search) {
            new Search();
            dispose();
        } else if (source == cart) {
            new Cart();
            dispose();
        } else if (source == profile) {
            if (new Repository().getHistory() == null) {
                new Form(null);
            } else {
                new Profile();
                dispose();
            }
        }
    }
}
