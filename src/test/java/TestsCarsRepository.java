import netcracker.entity.Car;
import netcracker.entity.CarRepository;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

import static junit.framework.Assert.assertEquals;

public class TestsCarsRepository {
    @Test
    public void testAdd() throws IOException {
        CarRepository repository = new CarRepository(2);
        Car car = new Car("213", new Color(1, 1, 1), "седан", new LocalDate(2011, 1, 1));
        repository.add(car);
        assertEquals(car, repository.get(car.getVIN()));
    }

    @Test
    public void testSort() throws IOException {
        CarRepository repository = new CarRepository(3);
        Car car1 = new Car("213", new Color(1, 1, 1), "седан", new LocalDate(2011, 1, 1));
        Car car2 = new Car("3", new Color(1, 1, 1), "седан", new LocalDate(2011, 1, 1));
        Car car3 = new Car("1234", new Color(1, 1, 1), "седан", new LocalDate(2011, 1, 1));
        repository.add(car1);
        repository.add(car2);
        repository.add(car3);
        Car[] carArray = new Car[3];
        carArray[0] = car1;
        carArray[1] = car2;
        carArray[2] = car3;

        Comparator<Car> comparatorbyVIN = Comparator.comparing(Car::getVIN);

        Arrays.sort(carArray, comparatorbyVIN);
        repository.sort(comparatorbyVIN);

        boolean ok = false;
        int i = 0;
        for (Car c : repository) {
            Assert.assertEquals(c, carArray[i]);
            i++;
        }

    }
}
