package netcracker.comparator;

import netcracker.entity.Person;

import java.util.Comparator;

public class Compare_by_age implements Comparator<Person> {
    @Override
    public int compare(Person lhs, Person rhs) {
        return lhs.getAge() - rhs.getAge();
    }
}
