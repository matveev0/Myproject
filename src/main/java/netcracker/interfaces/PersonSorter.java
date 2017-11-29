package netcracker.interfaces;

import netcracker.entity.Person;
import netcracker.entity.PersonRepository;

public interface PersonSorter {
    void sort(Person[] repository, int length, PersonComparator comparator);
}
