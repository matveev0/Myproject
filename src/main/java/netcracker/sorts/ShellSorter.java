package netcracker.sorts;

import netcracker.entity.Person;
import netcracker.interfaces.PersonComparator;
import netcracker.interfaces.PersonSorter;

public class ShellSorter implements PersonSorter {
    @Override
    public void sort(Person[] repository, int length, PersonComparator comparator) {
        int increment = length / 2;
        while (increment > 0) {
            for (int i = increment; i < length; i++) {
                int j = i;
                Person temp = repository[i];
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
