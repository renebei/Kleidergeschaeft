package data;

import entity.Clothing;
import entity.ClothingDAO;

import java.util.Map;

public class Repository {

    private ClothingDAO clothingDAO;

    public Repository() {
        this.clothingDAO = new ClothingDAO(Testdata.generate());
    }

    //Search, Order, Add... Polymorphie im DAO

    public boolean search() {
        return false;
    }

    public boolean order() {
        return false;
    }

    public boolean  add() {
        return false;
    }
}
