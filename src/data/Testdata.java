package data;

import entity.Clothing;
import entity.Size;
import entity.Type;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Klasse nach Singelton pattern.
 *
 * @author Rene Beiermann
 */

class Testdata {

    private static List<Clothing> data;
    private static Testdata database;

    private Testdata() {
    }

    /**
     * Generiert Kleidungsstücke mit zufaelliger Farbe, Groesse & Stueckzahl
     *
     * @return das Singelton.
     */
    public static Testdata generate() {
        if (database == null) {
            database = new Testdata();
            data = new ArrayList<>();
            Color[] colors = {Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.ORANGE};
            Random rand = new Random();
            for (int i = 0; i < 25; i++) {
                Size size = Size.values()[rand.nextInt(5)];
                Type type = Type.values()[rand.nextInt(4)];
                Color color = colors[rand.nextInt(colors.length)];

                database.data.add(new Clothing(size, type, color, rand.nextInt(4)));
            }
        }
        return database;
    }

    public List<Clothing> getData() {
        return data;
    }
}
