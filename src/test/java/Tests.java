import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import netcracker.List;
import netcracker.Person;
import org.joda.time.LocalDate;
import org.junit.Test;
import sun.management.resources.agent;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Tests {
    @Test
    public void testAdd() {
        List l = new List(3);
        Person p1 = new Person(1, "Матвеев543", new LocalDate(1999, 10, 11));
        l.add(p1);
        Person p = l.getPerson(1);
        assertEquals(p, p1);
    }
}
