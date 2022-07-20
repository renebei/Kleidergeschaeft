package entity;

import java.awt.*;

public class Clothing {
    private Size size;
    private ClothingType type;
    private Color color;

    public Clothing(Size size, ClothingType type, Color color) {
        this.size = size;
        this.type = type;
        this.color = color;
    }
}
