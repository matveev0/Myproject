package netcracker.interfaces;

import org.joda.time.LocalDate;

public interface IPerson {
    String getFIO();

    LocalDate getDateOfBirth();

    String getId();

    int getAge();
}
