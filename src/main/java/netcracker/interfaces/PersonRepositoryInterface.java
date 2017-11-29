package netcracker.interfaces;

import netcracker.entity.Person;

public interface PersonRepositoryInterface {
    void sort(PersonComparator comparator);

    void add(Person p);

    Person getPerson(String id);

    void delete(String id);
}
