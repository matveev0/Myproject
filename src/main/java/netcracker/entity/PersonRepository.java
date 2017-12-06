package netcracker.entity;

import netcracker.PersonChecks.*;
import netcracker.abstractclass.Repository;
import netcracker.config.Configurator;
import netcracker.interfaces.Checker;
import netcracker.interfaces.Sorter;

import java.io.IOException;
import java.util.Comparator;

public class PersonRepository extends Repository<Person>/* PersonRepositoryInterface */ {

    private Sorter<Person> sorter = Configurator.getInstance().getSorter();

    public PersonRepository(int capacity) throws IOException {
        super(capacity);
        repository = new Person[capacity];
    }

    @Override
    public void delete(Person pp) {
        int i = -1;

        for (Object p1 : repository) {
            Person p = (Person) p1;
            i++;

            if (p.getId().equals(pp.getId())) {
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
    public Person get(String id) {
        for (Person p : repository) {
            if (p.getId().equals(id))
                return p;
        }
        return null;
    }

    @Override
    public void sort(Comparator<Person> comparator) {
        sorter.sort(repository, lengthNotNull, comparator);
    }

    void setSorter() {
    }

    /**
     * Вывод в консоль списка персон
     */
    public void printer() {
        for (Object p1 : repository) {
            Person p = (Person) p1;
            if (p != null)
                System.out.println("ID: " + p.getId() + " FIO: " + p.getFIO() + " AGE: " + p.getAge());
        }
    }

    private PersonRepository search(Checker checker, Object value) {
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
