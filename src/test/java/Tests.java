
import netcracker.comparator.Compare_by_age;
import netcracker.entity.PersonRepository;
import netcracker.entity.Person;

import org.joda.time.LocalDate;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Tests {
    @Test
    public void testAdd() {
        PersonRepository l = null;
        try {
            l = new PersonRepository(3);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Person p1 = new Person("1","Матвеев543", new LocalDate(1999, 10, 11));
        l.add(p1);
        Person p = l.getPerson(l.getPerson("1").getId());

        assertEquals(p, p1);
    }

    public void testSort() {
        PersonRepository l = null;
        try {
            l = new PersonRepository(3);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Person p1 = new Person("Матвеев543", new LocalDate(1995, 10, 11));
        Person p2 = new Person("Матвеев5213213", new LocalDate(1929, 10, 11));
        Person p3 = new Person("Матвеев51", new LocalDate(2000, 10, 11));
        l.add(p1);
        l.add(p2);
        l.add(p3);

        Person[] arrayperson = new Person[3];

        arrayperson[0] = p1;
        arrayperson[1] = p2;
        arrayperson[2] = p3;

        //Arrays.sort(arrayperson, new Compare_by_age());
        l.sort(new Compare_by_age());

        assertEquals(l, arrayperson);
    }
}
