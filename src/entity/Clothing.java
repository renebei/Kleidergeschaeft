package entity;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * @author René Beiermann
 */

public class Clothing {

    private Size size;
    private Type type;
    private Color color;
    private int quantity;
    private int cost;
    private Icon icon;

    public Clothing(Size size, Type type, Color color, int quantity) {
        this.size = size;
        this.type = type;
        this.color = color;
        this.quantity = quantity;
        this.cost = new Random().nextInt(100) + 15; //Inflation
        colorInfos();
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Type getType() {
        return type;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setType(Type type) {
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(type.toString()+ " - ");
        sb.append(size.toString() + " - ");
        sb.append(cost + " Euro");
        return sb.toString();
    }

    private void colorInfos() {
        StringBuilder sb = new StringBuilder("res/");
        sb.append(type.toString());
        sb.append("/");
        if (color.equals(Color.BLACK)) {
            sb.append("black.png");
        } else if (color.equals(Color.BLUE)) {
            sb.append("blue.png");
        } else if (color.equals(Color.GREEN)) {
            sb.append("green.png");
        } else if (color.equals(Color.CYAN)) {
            sb.append("cyan.png");
        } else if (color.equals(Color.MAGENTA)) {
            sb.append("magenta.png");
        } else if (color.equals(Color.ORANGE)) {
            sb.append("orange.png");
        }
        icon = new ImageIcon(sb.toString());
    }
}
