package netcracker.abstractclass;

import netcracker.config.Configurator;
import netcracker.interfaces.Sorter;

import java.io.IOException;
import java.util.Arrays;

public abstract class Repository<T> implements netcracker.interfaces.Repository<T> {
    protected static int id = -1;
    protected Object[] repository;
    protected int lengthNotNull;
    protected Sorter sorter = Configurator.getInstance().getSorter();

    public Repository(int capacity) throws IOException {
        repository = new Object[capacity];
        lengthNotNull = 0;
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
}
