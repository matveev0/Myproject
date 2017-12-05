package netcracker.sorts;

import netcracker.entity.Person;
import netcracker.interfaces.Sorter;

import java.util.Comparator;

public class BubbleSorter implements Sorter<Person> {
    @Override
    public void sort(Person[] repository, int length, Comparator<Person> comparator) {
        int n = repository.length;
        Person temp;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < (length - i); j++) {
                if (comparator.compare(repository[j - 1], repository[j]) > 0) {
                    temp = repository[j - 1];
                    repository[j - 1] = repository[j];
                    repository[j] = temp;
                }
            }
        }
    }
}