package netcracker.comparator;

import netcracker.entity.Person;
import netcracker.interfaces.PersonComparator;

public class Compare_by_id implements PersonComparator {
    @Override
    public int compare(Person lhs, Person rhs) {
        return lhs.getId().compareTo(rhs.getId());
    }
}
