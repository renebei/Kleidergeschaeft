package entity;

import java.awt.*;

public class Clothing {
    private Size size;
    private ClothingType type;
    private Color color;
    private int quantity;

    public Clothing(Size size, ClothingType type, Color color, int quantity) {
        this.size = size;
        this.type = type;
        this.color = color;
        this.quantity = quantity;
    }
}
