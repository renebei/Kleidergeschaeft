package gui;

import entity.Clothing;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SearchResults extends JFrame implements ActionListener {

    private JPanel panel;
    private List<JButton> buttons;

    public SearchResults(List<Clothing> results) {
        super("List");
        panel = new JPanel();
        setLayout(new BorderLayout());
        panel.setLayout(new GridLayout(4, 4));
        add(panel, BorderLayout.CENTER);
        setVisible(true);
        setSize(1000, 1000);

        initButtons(results);
        listButtons();

    }

    private void initButtons(List<Clothing> results) {
        buttons = new ArrayList<>();
        for (Clothing c : results) {
            JButton tmp = new JButton(c.toString());
            tmp.addActionListener(this);
            tmp.setFont(new Font("Arial", Font.PLAIN, 20));
            buttons.add(tmp);
        }
    }

    private void listButtons() {
        //print buttons to screen
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


}
