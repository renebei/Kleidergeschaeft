package gui;

import data.Repository;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Beinhaltet wichtige Bestandteile aller GUI Objekte.
 *
 * @author Rene Beiermann, Maximilian Krebs
 */
public abstract class Activity extends JFrame implements ActionListener {
    /**
     * Auf dieses Repository greifen alle GUI Objekte zu.
     */
    protected Repository repo;

    /**
     * @param name Fuer den Kontruktor von JFrame.
     */
    public Activity(String name) {
        super(name);
        repo = new Repository();
    }

    /**
     * Verwaltet welche Logik ausgeführt wird bei dem Event "e"
     *
     * @param e das gedrueckte ActionEvent. Beispielsweise JButton
     */
    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
