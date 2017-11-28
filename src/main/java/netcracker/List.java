package netcracker;

import java.util.Arrays;
import java.util.Comparator;

public class List {
    private static int id = -1;
    private Person[] listOfPerson;
    private int length;

    /**
     * @param capacity размер списка
     */
    public List(int capacity) {
        listOfPerson = new Person[capacity];
        length = capacity;
    }

    public int getLength() {
        return length;
    }

    /**
     * Увеличение размера списка в 2 раза
     */
    void resize() {
        listOfPerson = Arrays.copyOf(listOfPerson, listOfPerson.length * 2);
        length *= 2;
    }

    /**
     * Добавление в список персоны.
     * В случае отсутствия места для вставки, увеличение размера
     *
     * @param p
     */
    public void add(Person p) {
        if (++id < listOfPerson.length - 1) {
            listOfPerson[id] = p;
        } else {
            resize();
            listOfPerson[id] = p;
        }
    }

    public Person getPerson(int id) {
        for (Person p : listOfPerson) {
            if (p.getId() == id)
                return p;
        }
        return null;
    }

    /**
     * Удаление элемента в списке по id
     *
     * @param id Id удаляемого элемента. Удаляется первое вхождение.
     */
    public void delete(int id) {
        int i = -1;

        for (Person p : listOfPerson) {
            i++;
            if (p.getId() == id) {
                for (; i < listOfPerson.length - 1; i++) {
                    listOfPerson[i] = listOfPerson[i + 1];
                }
                //ListOfPerson[i+1] = null;
                return;
            }
        }
    }

    /**
     * Вывод в коноль списка персон
     */
    public void printer() {
        for (Person p : listOfPerson)
            if (p != null)
                System.out.println("ID: " + p.getId() + " SURNAME: " + p.getSurname() + " AGE: " + p.getAge());
    }

    public Person search(String surname) {
        for (Person p : listOfPerson) {
            if (p.getSurname().equals(surname))
                return p;
        }
        return null;
    }

    private void bubbleSort(Comparator<Person> comparator) {
        int n = id + 1;
        Person temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (comparator.compare(listOfPerson[j - 1], listOfPerson[j]) > 0) {
                    //swap elements
                    temp = listOfPerson[j - 1];
                    listOfPerson[j - 1] = listOfPerson[j];
                    listOfPerson[j] = temp;
                }
            }
        }
    }

    private void quickSort(Comparator<Person> comparator) {
        int startIndex = 0;
        int endIndex = id;
        doSort(startIndex, endIndex, comparator);
    }

    private void doSort(int start, int end, Comparator<Person> comparator) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && comparator.compare(listOfPerson[i], listOfPerson[cur]) <= 0) {
                i++;
            }
            while (j > cur && comparator.compare(listOfPerson[cur], listOfPerson[j]) <= 0) {
                j--;
            }
            if (i < j) {
                Person temp = listOfPerson[i];
                listOfPerson[i] = listOfPerson[j];
                listOfPerson[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSort(start, cur, comparator);
        doSort(cur + 1, end, comparator);
    }

    private void shell(Comparator<Person> comparator) {
        int l = id + 1;
        int increment = l / 2;
        while (increment > 0) {
            for (int i = increment; i < l; i++) {
                int j = i;
                Person temp = listOfPerson[i];
                while (j >= increment && comparator.compare(listOfPerson[j - increment], temp) > 0) {
                    listOfPerson[j] = listOfPerson[j - increment];
                    j = j - increment;
                }
                listOfPerson[j] = temp;
            }
            if (increment == 2) {
                increment = 1;
            } else {
                increment *= (5.0 / 11);
            }
        }
    }

    public void sort(Comparator comparator, Sorttype typesort) {
        switch (typesort.toString()) {
            case "bubble":
                bubbleSort(comparator);
                break;
            case "quick":
                quickSort(comparator);
                break;
            case "shell":
                shell(comparator);
                break;
        }
    }
}
