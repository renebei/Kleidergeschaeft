package gui;

import data.Repository;
import entity.Customer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 * @author René Beiermann
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
