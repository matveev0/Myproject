package netcracker.interfaces;

import org.joda.time.LocalDate;

public interface PersonInterface {
    String getFIO();

    LocalDate getDateOfBirth();

    String getId();

    int getAge();
}
