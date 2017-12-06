package netcracker.sorts;

import netcracker.entity.Person;
import netcracker.interfaces.Sorter;

import java.util.Comparator;

public class BubbleSorter<T> implements Sorter<T> {
    @Override
    public void sort(T[] repository, int length, Comparator<T> comparator) {
        int n = repository.length;
        T temp;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < (length - i); j++) {
                if (comparator.compare(repository[j - 1],repository[j]) > 0) {
                    temp = repository[j - 1];
                    repository[j - 1] = repository[j];
                    repository[j] = temp;
                }
            }
        }
    }
}