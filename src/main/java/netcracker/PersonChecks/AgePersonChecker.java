package netcracker.PersonChecks;


import netcracker.entity.Person;
import netcracker.interfaces.PersonChecker;

import java.util.Objects;

public class AgePersonChecker implements PersonChecker {
    @Override
    public boolean check(Person p, Object value) {
        return Objects.equals(p.getAge(), value);
    }
}