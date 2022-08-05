package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author René Beiermann
 */

public class ClothingDAO implements DAO<Clothing> {

    private List<Clothing> testdata;

    public ClothingDAO(List<Clothing> testdata) {
        this.testdata = testdata;
    }

    /**
     * @param clothing Kleidungsstück welches den Daten hinzugefuegt wird.
     * @see DAO
     */
    @Override
    public boolean save(Clothing clothing) {
        return testdata.add(clothing);
    }

    /**
     * @param clothing Kleidungsstück welches den Daten entfernt wird.
     * @see DAO
     */
    @Override
    public boolean delete(Clothing clothing) {
        for (Clothing c : testdata) {
            if (clothing.equals(c)) {
                c.setQuantity(c.getQuantity() - 1);
                return true;
            }
        }
        return false;
    }

    /**
     * @see DAO
     */
    @Override
    public List<Clothing> getAll() {
        return testdata;
    }

    /**
     * @param type Kleidungstück
     * @return Liste der gefilterten Ergebnisse.
     */
    public List<Clothing> search(Type type) {
        List<Clothing> temp = new ArrayList<>();
        for (Clothing c : testdata) {
            if (c.getType() == type && c.getQuantity() > 0) temp.add(c);
        }
        return temp;
    }

    public List<Clothing> search(Type type, int cost) {
        List<Clothing> temp = new ArrayList<>();
        for (Clothing c : testdata) {
            if (c.getType().equals(type) && c.getPrice() <= cost) temp.add(c);
        }
        return temp;
    }
}
