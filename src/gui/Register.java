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
public class Register extends Activity {

    private JTextField textFieldName;
    private JTextField textFieldPhone;
    private JTextField textFieldMail;
    private JTextField textFieldPassword;
    private JTextField textAreaAddress;

    private JButton clear, submit;

    private Checkout parent;


    public Register(Checkout checkout) {
        super("Register");
        setVisible(true);
        this.setBounds(100, 100, 425, 320);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

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

        submit.addActionListener(this);
        clear.addActionListener(this);
    }

    public void initTextForm() {
        //Name
        JLabel lblName = new JLabel("Username");
        lblName.setBounds(60, 28, 70, 14);
        this.getContentPane().add(lblName);

        textFieldName = new JTextField();
        textFieldName.setBounds(128, 28, 250, 20);
        this.getContentPane().add(textFieldName);
        textFieldName.setColumns(10);

        //Phone
        JLabel lblPhone = new JLabel("Phone Nr.");
        lblPhone.setBounds(60, 68, 70, 14);
        this.getContentPane().add(lblPhone);

        textFieldPhone = new JTextField();
        textFieldPhone.setBounds(128, 68, 250, 20);
        this.getContentPane().add(textFieldPhone);
        textFieldPhone.setColumns(10);

        //Email
        JLabel lblEmailId = new JLabel("Email");
        lblEmailId.setBounds(60, 108, 70, 14);
        this.getContentPane().add(lblEmailId);

        textFieldMail = new JTextField();
        textFieldMail.setBounds(128, 108, 250, 17);
        this.getContentPane().add(textFieldMail);
        textFieldMail.setColumns(10);

        //Address
        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(60, 148, 70, 14);
        this.getContentPane().add(lblAddress);

        textAreaAddress = new JTextField();
        textAreaAddress.setBounds(126, 148, 250, 20);
        this.getContentPane().add(textAreaAddress);

        //Address
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(60, 188, 70, 14);
        this.getContentPane().add(lblPassword);

        textFieldPassword = new JTextField();
        textFieldPassword.setBounds(126, 188, 250, 20);
        this.getContentPane().add(textFieldPassword);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (source == submit) {
            if (textFieldName.getText().isEmpty() || (textFieldPhone.getText().isEmpty()) || (textFieldMail.getText().isEmpty()) || (textAreaAddress.getText().isEmpty()))
                JOptionPane.showMessageDialog(null, "Data Missing");
            else {
                try {
                    String name = textFieldName.getText().replaceAll("\\s+", "");
                    int phone = Integer.parseInt(textFieldPhone.getText().replaceAll("\\s+", ""));
                    String mail = textFieldMail.getText().replaceAll("\\s+", "");
                    String address = textAreaAddress.getText().replaceAll("\\s+", "");
                    String password = textFieldPassword.getText().replaceAll("\\s+", "");
                    if (repo.addCustomer(new Customer(name, address, phone, mail, password))) {
                        JOptionPane.showMessageDialog(null, "Registered!");
                        if (parent != null)
                            parent.insertCurrentUser();
                    } else {
                        JOptionPane.showMessageDialog(null, "Data existed in our system.");
                        if (parent != null)
                            parent.insertCurrentUser();
                    }
                } catch (NumberFormatException exc) {
                    JOptionPane.showMessageDialog(null, "Data invalid");
                }
            }
            dispose();
        } else if (source == clear) {
            textFieldPhone.setText(null);
            textFieldMail.setText(null);
            textFieldName.setText(null);
            textAreaAddress.setText(null);
            textFieldPassword.setText(null);
        }
    }
}
