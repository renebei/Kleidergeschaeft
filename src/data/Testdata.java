package data;

import entity.Clothing;
import entity.ClothingType;
import entity.Size;
import gui.Interface;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Testdata {

    public static Map<Integer, Clothing> generate() {
        Map<Integer, Clothing> temp = new HashMap<>();
        Random rand = new Random();
        Color[] color = {Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.ORANGE};

        for (int i = 0; i < 50; i++) {
            temp.put(rand.nextInt(10), new Clothing(Size.values()[rand.nextInt(5)], ClothingType.values()[rand.nextInt(3)], color[rand.nextInt(color.length)]));
        }

        return temp;
    }
}
