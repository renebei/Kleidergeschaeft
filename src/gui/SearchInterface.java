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
        panel.setLayout(new GridLayout(3, 3));
        add(panel, BorderLayout.CENTER);
        add(res, BorderLayout.NORTH);
        setVisible(true);
        setSize(1000, 1000);
        res.setFont(new Font("Arial", Font.PLAIN, 40));
        res.setText("Enter Price Range");

        initButtons();
        clearButtons();
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        clearButtons();
        source.setBackground(Color.lightGray);
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
                new SearchResults(parent.getRepo().search(cType, maxPrice), parent);
            } catch (Exception exc) {
                if (cType != null) {
                    new SearchResults(parent.getRepo().search(cType, 0), parent);
                }
            }
            dispose();
        }

    }

    private void initButtons() {
        Icon tshirtIcon = new ImageIcon("res/Tshirt.png");
        Icon jeansIcon = new ImageIcon("res/Jeans.png");
        Icon hoodieIcon = new ImageIcon("res/hoodie.png");
        Icon jacketIcon = new ImageIcon("res/Jacket.png");

        this.tShirt = new JButton(tshirtIcon);
        this.tShirt.addActionListener(this);
        this.tShirt.setFont(new Font("Arial", Font.PLAIN, 40));
        this.panel.add(tShirt);

        this.jeans = new JButton(jeansIcon);
        this.jeans.addActionListener(this);
        this.jeans.setFont(new Font("Arial", Font.PLAIN, 40));
        this.panel.add(jeans);

        this.hoodie = new JButton(hoodieIcon);
        this.hoodie.addActionListener(this);
        this.hoodie.setFont(new Font("Arial", Font.PLAIN, 40));
        this.panel.add(hoodie);

        this.jacket = new JButton(jacketIcon);
        this.jacket.addActionListener(this);
        this.jacket.setFont(new Font("Arial", Font.PLAIN, 40));
        this.panel.add(jacket);

        this.enter = new JButton("Enter");
        this.enter.setBackground(Color.LIGHT_GRAY);
        this.enter.addActionListener(this);
        this.enter.setFont(new Font("Arial", Font.PLAIN, 40));
        this.panel.add(enter);

        this.backToParent = new JButton("Back to Homescreen");
        this.backToParent.setBackground(Color.LIGHT_GRAY);
        this.backToParent.addActionListener(this);
        this.backToParent.setFont(new Font("Arial", Font.PLAIN, 40));
        this.panel.add(backToParent);
    }

    private void clearButtons() {
        hoodie.setBackground(Color.white);
        tShirt.setBackground(Color.white);
        jacket.setBackground(Color.white);
        jeans.setBackground(Color.white);
    }
}
