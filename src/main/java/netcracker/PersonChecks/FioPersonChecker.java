package netcracker.PersonChecks;

import netcracker.entity.Person;
import netcracker.interfaces.PersonChecker;

public class FioPersonChecker implements PersonChecker {
    @Override
    public boolean check(Person p, Object value) {
        return p.getFIO().equals(value);
    }
}

