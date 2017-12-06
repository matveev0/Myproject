package netcracker.entity;

import netcracker.abstractclass.Repository;
import netcracker.config.Configurator;
import netcracker.interfaces.Sorter;

import java.io.IOException;
import java.util.Comparator;

public class CarRepository extends Repository<Car> {

    private Sorter<Car> sorter = Configurator.getInstance().getSorter();

    public CarRepository(int capacity) throws IOException {
        super(capacity);
        repository = new Car[capacity];
    }

    @Override
    public void sort(Comparator<Car> comparator) {
        sorter.sort(repository,lengthNotNull,comparator);
    }

    @Override
    public Car get(String vin){
        for (Car c : repository) {
            if (c.getVIN().equals(vin))
                return c;
        }
        return null;

    }

    @Override
    public void delete(Car obj) {

    }
}
