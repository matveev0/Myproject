package netcracker.sorts;

import netcracker.entity.Person;
import netcracker.interfaces.Sorter;

import java.util.Comparator;

public class QuickSorter implements Sorter<Person> {
    @Override
    public void sort(Person[] repository, int length, Comparator<Person> comparator) {
        int startIndex = 0;
        int endIndex = length;
        doSort(repository, startIndex, endIndex-1, comparator);
    }

    private void doSort(Person[] repository, int start, int end, Comparator<Person> comparator) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && comparator.compare(repository[i], repository[cur]) <= 0) {
                i++;
            }
            while (j > cur && comparator.compare(repository[cur], repository[j]) <= 0) {
                j--;
            }
            if (i < j) {
                Person temp = repository[i];
                repository[i] = repository[j];
                repository[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSort(repository, start, cur, comparator);
        doSort(repository, cur + 1, end, comparator);
    }
}
