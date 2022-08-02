package gui;

import data.Repository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author René Beiermann
 */

public class Search extends Activity {
    private entity.Type cType;
    private JButton tShirt, jeans, jacket, hoodie, home;

    private JPanel panel;
    private JTextField res;



    public Search() {
        super("Search");
        this.res = new JTextField(10);
        panel = new JPanel();
        setLayout(new BorderLayout());
        panel.setLayout(new GridLayout(2, 2));
        add(panel, BorderLayout.CENTER);
        add(res, BorderLayout.NORTH);
        setVisible(true);
        setSize(750, 750);
        res.setFont(new Font("Arial", Font.PLAIN, 40));
        res.setText("Enter Price Range");

        initButtons();
        clearButtons();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        clearButtons();
        source.setBackground(Color.lightGray);
        if (source == tShirt) {
            cType = entity.Type.TShirt;
        } else if (source == jeans) {
            cType = entity.Type.Jeans;
        } else if (source == jacket) {
            cType = entity.Type.Jacket;
        } else if (source == hoodie) {
            cType = entity.Type.Hoodie;
        } else if (source == home){
            new Home();
            dispose();
        }
        try {
            int maxPrice = Integer.parseInt(res.getText());
            new SearchResults(repo.search(cType, maxPrice));
        } catch (Exception exc) {
            if (cType != null) {
                new SearchResults(repo.search(cType, 0));
            }
        }
        dispose();
    }

    private void initButtons() {
        Icon homeIcon = new ImageIcon(new ImageIcon("res/home.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
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

        this.home = new JButton(homeIcon);
        this.home.addActionListener(this);
        this.home.setFont(new Font("Arial", Font.PLAIN, 40));
        add(home, BorderLayout.SOUTH);
    }

    private void clearButtons() {
        hoodie.setBackground(Color.white);
        tShirt.setBackground(Color.white);
        jacket.setBackground(Color.white);
        jeans.setBackground(Color.white);
    }
}
