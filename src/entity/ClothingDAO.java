package entity;

import data.Testdata;

import java.util.ArrayList;
import java.util.List;

public class ClothingDAO {

    private Testdata testdata;

    public ClothingDAO(Testdata testdata) {
        this.testdata = testdata;
    }

    public boolean sell(Clothing clothing) {
        for (Clothing c : testdata.getData()) {
            if (clothing.equals(c)) {
                c.setQuantity(c.getQuantity()-1);
                return true;
            }
        }
        return false;
    }

    public List<Clothing> search(ClothingType type) {
        List<Clothing> temp = new ArrayList<>();
        for (Clothing c : testdata.getData()) {
            if (c.getType() == type) temp.add(c);
        }
        return temp;
    }

    public List<Clothing> search(ClothingType type, Size size) {
        List<Clothing> temp = new ArrayList<>();
        for (Clothing c : testdata.getData()) {
            if (c.getType().equals(type) && c.getSize().equals(size)) temp.add(c);
        }
        return temp;
    }
}
