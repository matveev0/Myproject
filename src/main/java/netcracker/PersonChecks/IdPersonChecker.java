package netcracker.PersonChecks;

import netcracker.entity.Person;
import netcracker.interfaces.PersonChecker;

public class IdPersonChecker implements PersonChecker {
    @Override
    public boolean check(Person p, Object value) {
        return p.getId().equals(value);
    }
}