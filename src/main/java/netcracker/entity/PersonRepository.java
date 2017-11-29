package netcracker.entity;

import netcracker.PersonChecks.*;
import netcracker.config.Configurator;
import netcracker.interfaces.PersonComparator;
import netcracker.interfaces.PersonRepositoryInterface;
import netcracker.interfaces.PersonChecker;
import netcracker.interfaces.PersonSorter;

import java.io.IOException;
import java.util.Arrays;

public class PersonRepository implements PersonRepositoryInterface {
    private static int id = -1;
    private Person[] repository;
    private int lengthNotNull;
    private PersonSorter sorter = Configurator.getInstance().getSorter();

    /**
     * @param capacity размер списка
     */
    public PersonRepository(int capacity) throws IOException {
        repository = new Person[capacity];
        lengthNotNull = 0;
    }

    public int getLength() {
        return lengthNotNull;
    }

    /**
     * Увеличение размера списка в 2 раза
     */
    void resize() {
        repository = Arrays.copyOf(repository, repository.length * 2);
        //length *= 2;
    }

    /**
     * Добавление в список персоны.
     * В случае отсутствия места для вставки, увеличение размера
     *
     * @param p
     */
    @Override
    public void add(Person p) {
        if (++id < repository.length - 1) {
            repository[id] = p;
        } else {
            resize();
            repository[id] = p;
        }
        lengthNotNull++;
    }

    /**
     * Удаление элемента в списке по id
     *
     * @param id Id удаляемого элемента. Удаляется первое вхождение.
     */
    @Override
    public void delete(String id) {
        int i = -1;

        for (Person p : repository) {
            i++;
            if (p.getId().equals(id)) {
                for (; i < repository.length - 1; i++) {
                    repository[i] = repository[i + 1];
                }
                lengthNotNull--;
                this.id--;
                return;
            }
        }

    }

    @Override
    public Person getPerson(String id) {
        for (Person p : repository) {
            if (p.getId().equals(id))
                return p;
        }
        return null;
    }

    @Override
    public void sort(PersonComparator comparator) {
        sorter.sort(repository, lengthNotNull, comparator);
    }

    void setSorter() {
    }

    /**
     * Вывод в консоль списка персон
     */
    public void printer() {
        for (Person p : repository)
            if (p != null)
                System.out.println("ID: " + p.getId() + " FIO: " + p.getFIO() + " AGE: " + p.getAge());
    }

    private PersonRepository search(PersonChecker checker, Object value) {
        PersonRepository result = null;
        try {
           result = new PersonRepository(5);
            for (int i = 0; i < lengthNotNull; i++) {
                if (checker.check(repository[i], value))
                    result.add(repository[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public PersonRepository searchbyAge(int age) {
        //return search((p, a) -> Objects.equals(p.getAge(), a), age);
        return search(new AgePersonChecker(), age);
    }

    public PersonRepository searchbyFIO(String FIO) {
        //return search((p, fio) -> p.getFIO().equals(fio), FIO);
        return search(new FioPersonChecker(), FIO);
    }

    public PersonRepository searchbyID(String ID) {
        //return search((p, id) -> p.getId().equals(id), ID);
        return search(new IdPersonChecker(), ID);
    }
}
