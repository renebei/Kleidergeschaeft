package gui;

import data.Repository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Pop Up welches zu Login oder Register führt.
 *
 * @author Rene Beiermann
 */
public class Form extends Activity {

    private JButton login, register;

    private Checkout parent;


    public Form(Checkout checkout) {
        super(null);
        setVisible(true);
        this.setBounds(100, 100, 425, 320);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2));

        repo = new Repository();
        parent = checkout;

        initButtons();
    }

    private void initButtons() {
        login = new JButton("Login");
        login.addActionListener(this);
        add(login);

        register = new JButton("Register");
        register.addActionListener(this);
        add(register);
    }

    /**
     * @see Login
     * @see Register
     * @see Activity
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (source == login) {
            new Login(parent);
            dispose();
        } else if (source == register) {
            new Register(parent);
            dispose();
        }
    }
}
