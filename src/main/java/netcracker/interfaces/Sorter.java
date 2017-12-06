package netcracker.interfaces;

import netcracker.entity.Person;

import java.time.Period;
import java.util.Comparator;

public interface Sorter<T>{
    void sort(T[] repository, int length, Comparator<T> comparator);
}
