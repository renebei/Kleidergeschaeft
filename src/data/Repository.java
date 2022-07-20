package data;

import entity.Clothing;

import java.util.Map;

public class Repository {
    private Map<Integer, Clothing> storage;

    public Repository() {
        storage = Testdata.generate();
    }

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
