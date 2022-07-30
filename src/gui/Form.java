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

public class Form extends JFrame {

    private JTextField textFieldName;
    private JTextField textFieldPhone;
    private JTextField textFieldMail;

    private JTextArea textAreaAddress;

    private JButton clear, submit;

    private Repository repo;

    private Checkout parent;


    public Form(Checkout checkout) {
        setVisible(true);
        this.setBounds(100, 100, 425, 325);
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
                if (textFieldName.getText().isEmpty() || (textFieldPhone.getText().isEmpty()) || (textFieldMail.getText().isEmpty()) || (textAreaAddress.getText().isEmpty()))
                    JOptionPane.showMessageDialog(null, "Data Missing");
                else {
                    try {
                        String name = textFieldName.getText();
                        int phone = Integer.parseInt(textFieldPhone.getText());
                        String mail = textFieldMail.getText();
                        String address = textAreaAddress.getText();
                        if (repo.addCustomer(new Customer(name, address, phone, mail))) {
                           parent.insertCurrentUser();
                        } else {
                            JOptionPane.showMessageDialog(null, "Data existed in our system.");
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Data invalid");
                    }
                }
                dispose();
            }
        });

        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textFieldPhone.setText(null);
                textFieldMail.setText(null);
                textFieldName.setText(null);
                textAreaAddress.setText(null);
            }
        });
    }

    public void initTextForm() {
        //Name
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(65, 31, 46, 14);
        this.getContentPane().add(lblName);

        textFieldName = new JTextField();
        textFieldName.setBounds(128, 28, 250, 20);
        this.getContentPane().add(textFieldName);
        textFieldName.setColumns(10);

        //Phone
        JLabel lblPhone = new JLabel("Phone Number");
        lblPhone.setBounds(65, 68, 46, 14);
        this.getContentPane().add(lblPhone);

        textFieldPhone = new JTextField();
        textFieldPhone.setBounds(128, 65, 250, 20);
        this.getContentPane().add(textFieldPhone);
        textFieldPhone.setColumns(10);

        //Email
        JLabel lblEmailId = new JLabel("Email Id");
        lblEmailId.setBounds(65, 115, 46, 14);
        this.getContentPane().add(lblEmailId);

        textFieldMail = new JTextField();
        textFieldMail.setBounds(128, 112, 250, 17);
        this.getContentPane().add(textFieldMail);
        textFieldMail.setColumns(10);

        //Address
        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(65, 162, 46, 14);
        this.getContentPane().add(lblAddress);

        textAreaAddress = new JTextArea();
        textAreaAddress.setBounds(126, 157, 250, 40);
        this.getContentPane().add(textAreaAddress);
    }
}
