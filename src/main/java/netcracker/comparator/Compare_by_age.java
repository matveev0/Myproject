package netcracker.comparator;

import netcracker.entity.Person;
import netcracker.interfaces.PersonComparator;

public class Compare_by_age implements PersonComparator {
    @Override
    public int compare(Person lhs, Person rhs) {
        return lhs.getAge() - rhs.getAge();
    }
}
