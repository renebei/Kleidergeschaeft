package entity;

import java.util.ArrayList;
import java.util.List;

public class ClothingDAO {

    private List<Clothing> testdata;

    public ClothingDAO(List<Clothing> testdata) {
        this.testdata = testdata;
    }

    public boolean sell(Clothing clothing) {
        for (Clothing c : testdata) {
            if (clothing.equals(c)) {
                c.setQuantity(c.getQuantity() - 1);
                return true;
            }
        }
        return false;
    }

    public List<Clothing> search(ClothingType type) {
        List<Clothing> temp = new ArrayList<>();
        for (Clothing c : testdata) {
            if (c.getType() == type) temp.add(c);
        }
        return temp;
    }

    public List<Clothing> search(ClothingType type, int cost) {
        List<Clothing> temp = new ArrayList<>();
        for (Clothing c : testdata) {
            if (c.getType().equals(type) && c.getCost() <= cost) temp.add(c);
        }
        return temp;
    }
}
