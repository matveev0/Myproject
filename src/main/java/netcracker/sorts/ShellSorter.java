package netcracker.sorts;

import netcracker.entity.Person;

import netcracker.interfaces.Sorter;

import java.util.Comparator;

public class ShellSorter<T> implements Sorter<T> {
    @Override
    public void sort(T[] repository, int length, Comparator<T> comparator) {
        int increment = length / 2;
        while (increment > 0) {
            for (int i = increment; i < length; i++) {
                int j = i;
                T temp = repository[i];
                while (j >= increment && comparator.compare(repository[j - increment], temp) > 0) {
                    repository[j] = repository[j - increment];
                    j = j - increment;
                }
                repository[j] = temp;
            }
            if (increment == 2) {
                increment = 1;
            } else {
                increment *= (5.0 / 11);
            }
        }
    }
}
