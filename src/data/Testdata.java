package data;

import entity.Clothing;
import entity.ClothingDAO;
import entity.ClothingType;
import entity.Size;
import gui.Interface;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Testdata {

    private static List<Clothing> data;
    private static Testdata database;

    public static Testdata generate() {
        database = new Testdata();
        data = new ArrayList<>();
        Color[] colors = {Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.ORANGE};
        Random rand = new Random();
        for (int i = 0; i < 15; i++) {
            Size size = Size.values()[rand.nextInt(5)];
            ClothingType type = ClothingType.values()[rand.nextInt(3)];
            Color color = colors[rand.nextInt(colors.length)];

            database.data.add(new Clothing(size, type, color, rand.nextInt(4)));
        }
        return database;
    }

}
