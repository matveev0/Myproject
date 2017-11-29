package netcracker.interfaces;

import netcracker.entity.Person;

public interface PersonChecker {
    boolean check(Person p, Object value);
}
