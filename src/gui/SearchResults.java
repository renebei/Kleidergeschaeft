package gui;

import data.Repository;
import entity.Clothing;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;
/**
 * @author René Beiermann
 */

public class SearchResults extends JFrame implements ActionListener {

    private JPanel panel;
    private Menue parent;
    private List<Clothing> results;

    private JButton back;
    private JButton backToMenue;

    private Repository repo;

    public SearchResults(List<Clothing> results) {
        super("List");
        panel = new JPanel();
        setLayout(new BorderLayout());
        panel.setLayout(new GridLayout(10, 10));
        add(panel, BorderLayout.CENTER);
        setVisible(true);
        setSize(1000, 1000);
        this.results = results;

        repo = new Repository();

        initButtons(results);
    }

    private void initButtons(List<Clothing> results) {
        back = new JButton("Back to Search");
        back.addActionListener(this);
        back.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(back);

        int i = 0;
        for (Clothing c : results) {
            JButton tmp = new JButton(c.toString(), c.getIcon());
            tmp.setName(String.valueOf(i));
            tmp.addActionListener(this);
            tmp.setFont(new Font("Arial", Font.PLAIN, 20));
            panel.add(tmp);
            i++;
        }
        backToMenue = new JButton("Back to Home");
        backToMenue.addActionListener(this);
        backToMenue.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(backToMenue);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (source == back) {
            new SearchInterface();
            dispose();
        } else if (source == backToMenue) {
            new Menue();
            dispose();
        } else {
            int id = Integer.parseInt(source.getName());
            source.setBackground(Color.GREEN);
            repo.addToCart(results.get(id));
            source.setEnabled(false);
        }
    }
}
