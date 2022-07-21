package data;

import entity.Clothing;
import entity.ClothingDAO;
import entity.ClothingType;
import entity.Size;

import java.util.List;
import java.util.Map;

public class Repository {

    private ClothingDAO clothingDAO;

    public Repository() {
        this.clothingDAO = new ClothingDAO(Testdata.generate());
    }

    public List<Clothing> search(ClothingType type, Size size) {
        if (size == null)
            return clothingDAO.search(type);
        return clothingDAO.search(type, size);
    }

    public boolean sell(Clothing c) {
        return clothingDAO.sell(c);
    }
}
