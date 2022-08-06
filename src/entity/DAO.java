package entity;

import java.util.List;

/**
 * Interface welches das Minimum eines Objektes vorgibt mit dem Daten bearbeitet werden.
 *
 * @param <T> Typ des zu bearbeitenden Objekt.
 * @author Rene Beiermann
 */
public interface DAO<T> {

    /**
     * Jedes DAO ist verpflichtet seine Daten komplett auszugeben.
     *
     * @return Liste aller Daten.
     */
    List<T> getAll();

    /**
     * Speichert T in DAO
     *
     * @return Ob das hinzufuegen erfolgreich war.
     */
    boolean save(T t);

    /**
     * Loescht T aus DAO
     *
     * @return Ob das loeschen erfolgreich war.
     */
    boolean delete(T t);
}
