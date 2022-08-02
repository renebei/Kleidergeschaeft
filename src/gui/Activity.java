package gui;

import data.Repository;

import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class Activity extends JFrame implements ActionListener {
    protected Repository repo;

    public Activity(String name) {
        super(name);
        repo = new Repository();
    }

}
