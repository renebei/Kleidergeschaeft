package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface extends JFrame implements ActionListener {

    private JTextField res;
    private JPanel panel;

    public Interface() {
        super("Kleidergeschaeft");
        this.res = new JTextField(10);
        panel = new JPanel();
        setLayout(new BorderLayout());
        panel.setLayout(new GridLayout(4, 4));
        add(panel, BorderLayout.CENTER);
        add(res, BorderLayout.NORTH);
        setVisible(true);
        setSize(750, 500);
        res.setFont(new Font("Arial", Font.PLAIN, 40));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
