package netcracker.abstractclass;

import netcracker.interfaces.IRepository;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class Repository<T> implements IRepository<T>, Iterable<T> {
    protected static int id = -1;
    protected T[] repository;
    protected int lengthNotNull;

    public Repository(int capacity) {
        lengthNotNull  =0;
    }

    @Override
    public void add(T p) {
        if (++id < repository.length - 1) {
            repository[id] = p;
        } else {
            resize();
            repository[id] = p;
        }
        lengthNotNull++;
    }

    /**
     * Увеличение размера списка в 2 раза
     */
    @Override
    public void resize() {
        repository = Arrays.copyOf(repository, repository.length * 2);
    }

    @Override
    public int getLength() {
        return lengthNotNull;
    }

    class ArrayIterator implements Iterator<T> {
        int current = 0;

        public boolean hasNext() {
            return current < Repository.this.lengthNotNull;
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return repository[current++];
        }
    }

    public Iterator<T> iterator() {
        return new ArrayIterator();
    }
}
