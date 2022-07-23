package gui;

import data.Repository;
import entity.ClothingType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchInterface extends JFrame implements ActionListener {
    private ClothingType cType;
    private JButton enter;
    private JButton tShirt, jeans, jacket, hoodie;
    private JButton backToParent;

    private JPanel panel;
    private JTextField res;

    private Menue parent;

    public SearchInterface(Menue parent) {
        super("Search");
        this.res = new JTextField(10);
        panel = new JPanel();
        setLayout(new BorderLayout());
        panel.setLayout(new GridLayout(4, 4));
        add(panel, BorderLayout.CENTER);
        add(res, BorderLayout.NORTH);
        setVisible(true);
        setSize(1000, 1000);
        res.setFont(new Font("Arial", Font.PLAIN, 40));
        res.setText("Enter Price Range");

        initButtons();
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (source == tShirt) {
            cType = ClothingType.TShirt;
        } else if (source == jeans) {
            cType = ClothingType.Jeans;
        } else if (source == jacket) {
            cType = ClothingType.Jacket;
        } else if (source == hoodie) {
            cType = ClothingType.Hoodie;
        } else if (source == backToParent) {
            new Menue(parent);
            dispose();
        } else if (source == enter) {
            try {
               int maxPrice = Integer.parseInt(res.getText());
                parent.getRepo().search(cType, maxPrice);
            } catch (Exception exc) {
                if(cType != null) {
                    new SearchResults(parent.getRepo().search(cType, 0));
                    dispose();
                }
            }
        }
    }

    private void initButtons() {
        this.tShirt = new JButton("TShirt");
        this.tShirt.addActionListener(this);
        this.tShirt.setFont(new Font("Arial", Font.PLAIN, 40));
        this.panel.add(tShirt);

        this.jeans = new JButton("Jeans");
        this.jeans.addActionListener(this);
        this.jeans.setFont(new Font("Arial", Font.PLAIN, 40));
        this.panel.add(jeans);

        this.hoodie = new JButton("hoodie");
        this.hoodie.addActionListener(this);
        this.hoodie.setFont(new Font("Arial", Font.PLAIN, 40));
        this.panel.add(hoodie);

        this.jacket = new JButton("Jacket");
        this.jacket.addActionListener(this);
        this.jacket.setFont(new Font("Arial", Font.PLAIN, 40));
        this.panel.add(jacket);

        this.enter = new JButton("Enter");
        this.enter.addActionListener(this);
        this.enter.setFont(new Font("Arial", Font.PLAIN, 40));
        this.panel.add(enter);

        this.backToParent = new JButton("Back to Homescreen");
        this.backToParent.addActionListener(this);
        this.backToParent.setFont(new Font("Arial", Font.PLAIN, 40));
        this.panel.add(backToParent);
    }
}
