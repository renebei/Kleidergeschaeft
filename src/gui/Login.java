package gui;

import data.Repository;
import entity.Customer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author René Beiermann
 */

public class Login extends JFrame {
    private JTextField textFieldName;
    private JTextField textFieldPassword;

    private JButton clear, submit;

    private Repository repo;

    private Checkout parent;


    public Login(Checkout checkout) {
        setVisible(true);
        this.setBounds(100, 100, 425, 320);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        repo = new Repository();
        parent = checkout;

        initTextForm();
        initButtons();
    }

    private void initButtons() {
        clear = new JButton("Clear");
        clear.setBounds(275, 225, 89, 23);
        this.getContentPane().add(clear);

        submit = new JButton("Submit");
        submit.setBounds(65, 225, 89, 23);
        this.getContentPane().add(submit);


        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (textFieldName.getText().isEmpty() || textFieldPassword.getText().isEmpty())
                    JOptionPane.showMessageDialog(null, "Data Missing");
                else {
                        String name = textFieldName.getText().replaceAll("\\s+", "");
                        String password = textFieldPassword.getText().replaceAll("\\s+", "");
                        if (repo.logInCustomer(name, password)) {
                            JOptionPane.showMessageDialog(null, "Logged in!");
                            if (parent != null)
                                parent.insertCurrentUser();
                        } else {
                            JOptionPane.showMessageDialog(null, "Does not exist!");
                            dispose();
                        }
                }
                dispose();
            }
        });

        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textFieldName.setText(null);
                textFieldPassword.setText(null);
            }
        });
    }

    public void initTextForm() {
        JLabel lblName = new JLabel("Username");
        lblName.setBounds(60, 28, 70, 14);
        this.getContentPane().add(lblName);

        textFieldName = new JTextField();
        textFieldName.setBounds(128, 28, 250, 20);
        this.getContentPane().add(textFieldName);
        textFieldName.setColumns(10);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(60, 68, 70, 14);
        this.getContentPane().add(lblPassword);

        textFieldPassword = new JTextField();
        textFieldPassword.setBounds(128, 68, 250, 20);
        this.getContentPane().add(textFieldPassword);
    }
}
