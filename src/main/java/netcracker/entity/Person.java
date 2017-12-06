package netcracker.entity;

import netcracker.interfaces.IPerson;
import org.joda.time.LocalDate;
import java.util.UUID;

public class Person implements IPerson {
    private String id;
    private String FIO;
    private LocalDate dateOfBirth;


    public Person(String id, String FIO, LocalDate dateOfBirth) {
        this.id = id;
        this.FIO = FIO;
        this.dateOfBirth = dateOfBirth;
    }

    public Person(String FIO, LocalDate DateOfBirth) {
        this.id = UUID.randomUUID().toString().substring(0,5);
        this.FIO = FIO;
        this.dateOfBirth = DateOfBirth;
    }

    @Override
    public String getFIO() {
        return FIO;
    }

    @Override
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String getId() {
        return id;
    }

    /**
     * Возвращает возраст персоны с помощью указанного дня рождения
     * @return
     */
    @Override
    public int getAge() {
        int age = LocalDate.now().getYear() - dateOfBirth.getYear();
        if (LocalDate.now().getDayOfYear() <= dateOfBirth.getDayOfYear())
            age--;
        return age;
    }
}
