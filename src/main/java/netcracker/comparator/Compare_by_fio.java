package netcracker.comparator;

import netcracker.entity.Person;
import java.util.Comparator;

public class Compare_by_fio implements Comparator<Person> {
    @Override
    public int compare(Person lhs, Person rhs) {
        return lhs.getFIO().compareTo(rhs.getFIO());
    }
}
