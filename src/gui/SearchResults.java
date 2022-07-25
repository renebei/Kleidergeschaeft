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
    private Menue parent;
    private List<Clothing> results;

    private JButton back;

    public SearchResults(List<Clothing> results, Menue parent) {
        super("List");
        panel = new JPanel();
        setLayout(new BorderLayout());
        panel.setLayout(new GridLayout(10, 10));
        add(panel, BorderLayout.CENTER);
        setVisible(true);
        setSize(1000, 1000);
        this.parent = parent;
        this.results = results;

        initButtons(results);
    }

    private void initButtons(List<Clothing> results) {
        back = new JButton("Back to Search");
        back.addActionListener(this);
        back.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(back);

        int i = 0;
        for (Clothing c : results) {
            JButton tmp = new JButton(c.toString());
            tmp.setName(String.valueOf(i));
            tmp.addActionListener(this);
            tmp.setFont(new Font("Arial", Font.PLAIN, 20));
            panel.add(tmp);
            i++;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (source == back) {
            new SearchInterface(parent);
            dispose();
        } else {
            int id = Integer.parseInt(source.getName());
            source.setBackground(Color.GREEN);
            parent.getShoppingCart().addToCart(results.get(id));
            source.setEnabled(false);
        }
    }
}
