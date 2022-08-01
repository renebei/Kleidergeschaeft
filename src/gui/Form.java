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
public class Form extends JFrame {

    private JButton login, register;

    private Repository repo;

    private Checkout parent;


    public Form(Checkout checkout) {
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
        add(login);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login(parent);
                dispose();
            }
        });

        register = new JButton("Register");
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Register(parent);
                dispose();
            }
        });
        add(register);
    }
}
