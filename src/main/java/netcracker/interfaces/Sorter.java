package netcracker.interfaces;

import java.util.Comparator;

public interface Sorter<T> {
    void sort(T[] repository, int length, Comparator<T> comparator);
}
