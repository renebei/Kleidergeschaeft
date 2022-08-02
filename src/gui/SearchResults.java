package gui;

import data.Repository;
import entity.Clothing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 * Gefilterter Shopkatalog.
 *
 * @author René Beiermann, Maximimilian Krebs
 */

public class SearchResults extends Activity {

    private JPanel panel2, panel1;

    private List<Clothing> results;

    private JButton back;
    private JButton backToMenue;


    /**
     * @param results Kleidungsstücke die den Bedingungen der Filter entsprechen
     * @see Search
     */
    public SearchResults(List<Clothing> results) {
        super("List");
        panel1 = new JPanel();
        panel2 = new JPanel();
        setLayout(new BorderLayout());
        panel1.setLayout(new BorderLayout());
        panel2.setLayout(new GridLayout(10, 10));
        add(panel1, BorderLayout.CENTER);
        panel1.add(panel2, BorderLayout.CENTER);
        setVisible(true);
        setSize(750, 750);
        this.results = results;
        repo = new Repository();

        initButtons(results);
    }

    private void initButtons(List<Clothing> results) {
        /**
         * Falls wir später nochmal ne Liste draus machen wollen :)
         * https://thewall.hehoe.de/content/coding:java:java_tut_7
         */
        int i = 0;
        for (Clothing c : results) {
            JButton tmp = new JButton(c.toString(), c.getIcon());
            tmp.setName(String.valueOf(i));
            tmp.addActionListener(this);
            tmp.setFont(new Font("Arial", Font.PLAIN, 20));
            tmp.setSize(new Dimension(1000, 500));
            panel2.add(tmp);
            i++;
        }
        Icon homeIcon = new ImageIcon(new ImageIcon("res/home.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        backToMenue = new JButton(homeIcon);
        backToMenue.addActionListener(this);
        backToMenue.setFont(new Font("Arial", Font.PLAIN, 40));
        panel1.add(backToMenue, BorderLayout.SOUTH);

        /**
         * Rezise Icons:
         * https://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon
         */
        Icon searchIcon = new ImageIcon(new ImageIcon("res/search.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        back = new JButton(searchIcon);
        back.addActionListener(this);
        back.setFont(new Font("Arial", Font.PLAIN, 5));
        add(back, BorderLayout.SOUTH);
    }

    /**
     * {@link #back} Zurueck zur Suche.
     * {@link #backToMenue} Zurueck ins Menue.
     *
     * @param e Wird ein Kleidungsstueck ausgewaehlt, so wird es den Warenkorb hinzugefuegt.
     * @see Activity
     * @see Home
     * @see Search
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (source == back) {
            new Search();
            dispose();
        } else if (source == backToMenue) {
            new Home();
            dispose();
        } else {
            int id = Integer.parseInt(source.getName());
            int sameItemsInCart = 0;
            if (sameItemsInCart < results.get(id).getQuantity()) {
                source.setBackground(Color.GREEN);
                repo.addToCart(results.get(id));
                source.setEnabled(false);
            }
        }
    }
}
