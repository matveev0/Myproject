package netcracker.comparator;

import netcracker.entity.Person;

import java.util.Comparator;

public class Compare_by_id implements Comparator<Person> {
    @Override
    public int compare(Person lhs, Person rhs) {
        return lhs.getId().compareTo(rhs.getId());
    }
}
