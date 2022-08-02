package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Login Page.
 *
 * @author René Beiermann
 */

public class Login extends Activity {
    private JTextField textFieldName;
    private JTextField textFieldPassword;

    private JButton clear, submit;

    private Checkout parent;


    public Login(Checkout checkout) {
        super("Login");
        setVisible(true);
        this.setBounds(100, 100, 425, 320);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        parent = checkout;

        initTextForm();
        initButtons();
    }

    /**
     * Initialisiert Buttons
     */
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

    /**
     * Füllt Pop Up mit Name, Passwort
     */
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

    /**
     * {@link #submit} Ließt Daten aus Textfeld und ueberprueft diese.
     * {@link #clear} Loescht Inhalt aus Textfeld.
     *
     * @see Activity
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (source == submit) {
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
        } else if (source == clear) {
            textFieldName.setText(null);
            textFieldPassword.setText(null);
        }
    }
}
