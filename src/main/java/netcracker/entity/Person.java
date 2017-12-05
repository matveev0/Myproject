package netcracker.entity;

import netcracker.interfaces.IPerson;
import org.joda.time.LocalDate;
import java.util.UUID;

public class Person implements IPerson {
    private String id;
    private String FIO;
    private LocalDate DateOfBirth;


    public Person(String id, String FIO, LocalDate DateOfBirth) {
        this.id = id;
        this.FIO = FIO;
        this.DateOfBirth = DateOfBirth;
    }

    public Person(String FIO, LocalDate DateOfBirth) {
        this.id = UUID.randomUUID().toString().substring(0,5);
        this.FIO = FIO;
        this.DateOfBirth = DateOfBirth;
    }

    @Override
    public String getFIO() {
        return FIO;
    }

    @Override
    public LocalDate getDateOfBirth() {
        return DateOfBirth;
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
        int age = LocalDate.now().getYear() - DateOfBirth.getYear();
        if (LocalDate.now().getDayOfYear() <= DateOfBirth.getDayOfYear())
            age--;
        return age;
    }
}
