package netcracker;

import java.util.Comparator;

class MyComparator{
    public static final Comparator<Person> COMPARE_BY_ID = new Comparator<Person>() {
        @Override
        public int compare(Person lhs, Person rhs) {
            return lhs.getId() - rhs.getId();
        }
    };
    public static final Comparator<Person> COMPARE_BY_SURNAME = new Comparator<Person>() {
        @Override
        public int compare(Person lhs, Person rhs) {
            return lhs.getSurname().compareTo(rhs.getSurname());
        }
    };
    public static final Comparator<Person> COMPARE_BY_AGE = new Comparator<Person>() {
        @Override
        public int compare(Person lhs, Person rhs) {
            return lhs.getAge() - rhs.getAge();
        }
    };
}

