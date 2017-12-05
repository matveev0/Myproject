package netcracker.interfaces;

import java.util.Comparator;

public interface Repository<T> {
    void sort(Comparator<T> comparator);

    void resize();

    int getLength();

    void add(T p);

    T get(String  id);

    //void delete(int index);

    void delete(T obj);
}
