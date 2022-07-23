package entity;

import java.awt.*;
import java.util.Random;

public class Clothing {

    private Size size;
    private ClothingType type;
    private Color color;
    private int quantity;
    private int cost;

    public Clothing(Size size, ClothingType type, Color color, int quantity) {
        this.size = size;
        this.type = type;
        this.color = color;
        this.quantity = quantity;
        this.cost = new Random().nextInt(100);
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public ClothingType getType() {
        return type;
    }

    public void setType(ClothingType type) {
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCost() {
        return cost;
    }
}
