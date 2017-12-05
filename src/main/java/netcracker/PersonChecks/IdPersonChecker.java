package netcracker.PersonChecks;

import netcracker.entity.Person;
import netcracker.interfaces.Checker;

public class IdPersonChecker implements Checker<Person> {
    @Override
    public boolean check(Person p, Object value) {
        return p.getId().equals(value);
    }
}