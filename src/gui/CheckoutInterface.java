package gui;

import entity.Clothing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CheckoutInterface extends JFrame implements ActionListener {
    private JPanel panel;
    private JList list;
    List<Clothing> cart;

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public CheckoutInterface(List<Clothing> clothes){
        super("Kleidergeschaeft");
        this.cart = clothes;
        setLayout(new BorderLayout());
        setVisible(true);
        showPurchase();
    }

    public void showPurchase() {
        list = new JList(cart.stream().toArray());
        list.setVisibleRowCount(5);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(list);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(list));
    }
}
