package data;

import entity.*;

import java.util.List;
import java.util.Map;

public class Repository {

    private ClothingDAO clothingDAO;

    public Repository() {
        this.clothingDAO = new ClothingDAO(Testdata.generate());
    }

    public List<Clothing> search(ClothingType type, int cost) {
        if (cost == 0)
            return clothingDAO.search(type);
        return clothingDAO.search(type, cost);
    }

    public boolean sell(Clothing c) {
        return clothingDAO.sell(c);
    }


}
