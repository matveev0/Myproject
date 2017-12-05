package netcracker.PersonChecks;

import netcracker.entity.Person;
import netcracker.interfaces.Checker;

import java.util.Objects;

public class AgePersonChecker implements Checker<Person> {
    @Override
    public boolean check(Person p, Object value) {
        return Objects.equals(p.getAge(), value);
    }
}