package netcracker.menu;

import netcracker.comparator.*;
import netcracker.entity.Person;
import netcracker.entity.PersonRepository;
import netcracker.exceptions.MyException;
import org.joda.time.LocalDate;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    private PersonRepository personRepository;

    public Menu() throws IOException {
        personRepository = new PersonRepository(5);
    }

    /**
     * Метод для вывода меню в консоль для работы со списком
     *
     * @throws MyException
     */
    public void ShowMenu() throws MyException {
        int Case = 0;
        addRndPerson();

        while (Case != -1) {
            System.out.println("1 - Add person");
            System.out.println("2 - Delete person");
            System.out.println("3 - Printer");
            System.out.println("4 - Sort");
            System.out.println("5 - Search by ID");
            System.out.println("6 - Search by FIO");
            System.out.println("7 - Search by age");


            Scanner in = new Scanner(System.in);
            Case = in.nextInt();

            switch (Case) {
                case 1: {
                    try {
                        Person p;
                        System.out.print("Surname: ");
                        String surname = in.nextLine();
                        surname = in.nextLine();
                        System.out.print("Date of birth (YYYY MM DD): ");
                        String[] DateOfBirth = in.nextLine().split(" ");
                        p = new Person(surname, new LocalDate(Integer.parseInt(DateOfBirth[0]),
                                Integer.parseInt(DateOfBirth[1]),
                                Integer.parseInt(DateOfBirth[2])));
                        personRepository.add(p);

                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                }

                case 2: {
                    try {
                        System.out.print("ID: ");
                        in.nextLine();
                        String id = in.nextLine();
                        personRepository.delete(personRepository.get(id));
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                }

                case 3: {
                    personRepository.printer();
                    break;
                }

                case 4: {
                    String typeField = "";
                    System.out.println("Select the field");
                    System.out.println("1) ID    2)FIO   3)Age");
                    in.nextLine();
                    typeField = in.nextLine();
                    switch (typeField) {
                        case "1":
                            personRepository.sort(new Compare_by_id());
                            break;
                        case "2":
                            personRepository.sort(new Compare_by_fio());
                            break;
                        case "3":
                            personRepository.sort(new Compare_by_age());
                            break;
                    }
                    System.out.println("Sorted!");
                    break;
                }

                case 5: {
                    try {
                        System.out.println("Enter ID");
                        String ID = in.nextLine();
                        ID = in.nextLine();
                        PersonRepository result = personRepository.searchbyID(ID);
                        if (result != null)
                            result.printer();
                        else
                            System.out.println("Person doesn`t exist");

                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                }

                case 6: {
                    try {
                        System.out.println("Enter FIO");
                        String FIO = in.nextLine();
                        FIO = in.nextLine();
                        PersonRepository result = personRepository.searchbyFIO(FIO);
                        if (result != null)
                            result.printer();
                        else
                            System.out.println("Person doesn`t exist");
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                }

                case 7: {
                    try {
                        System.out.println("Enter age");
                        String age = in.nextLine();
                        age = in.nextLine();
                        PersonRepository result = personRepository.searchbyAge(Integer.parseInt(age));
                        if (result != null)
                            result.printer();
                        else
                            System.out.println("Person doesn`t exist");
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        }
    }

    void addRndPerson() {
        Person p1 = new Person("Матвеев543", new LocalDate(1999, 10, 11));
        Person p2 = new Person("Матвеев123", new LocalDate(1990, 1, 25));
        Person p3 = new Person("Матвеев4", new LocalDate(1977, 3, 8));
        Person p4 = new Person("Матвеев1", new LocalDate(1917, 1, 1));
        Person p5 = new Person("Матвеев3423", new LocalDate(1927, 5, 15));
        Person p6 = new Person("Матвеев7", new LocalDate(1977, 3, 8));
        Person p7 = new Person("Матвеев3", new LocalDate(1931, 1, 15));

        personRepository.add(p1);
        personRepository.add(p2);
        personRepository.add(p3);
        personRepository.add(p4);
        personRepository.add(p5);
        personRepository.add(p6);
        personRepository.add(p7);
    }
}
