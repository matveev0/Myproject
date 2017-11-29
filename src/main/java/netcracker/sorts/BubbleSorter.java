package netcracker.sorts;

import netcracker.entity.Person;
import netcracker.interfaces.PersonComparator;
import netcracker.interfaces.PersonSorter;

public class BubbleSorter implements PersonSorter {
    @Override
    public void sort(Person[] repository, int length, PersonComparator comparator) {
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