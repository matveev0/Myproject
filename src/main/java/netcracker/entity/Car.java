package netcracker.entity;

import org.joda.time.LocalDate;
import java.awt.*;

public class Car {
    private String VIN;
    private Color color;
    private String model;
    private LocalDate dateOfProduction;


    public Car(String VIN, Color color, String model, LocalDate dateOfProduction) {
        this.VIN = VIN;
        this.color = color;
        this.model = model;
        this.dateOfProduction = dateOfProduction;
    }

    public String getModel() {
        return model;
    }

    public LocalDate getDateOfProduction() {
        return dateOfProduction;
    }

    public String getVIN() {
        return VIN;
    }

    public int getAge() {
        return LocalDate.now().getYear() - dateOfProduction.getYear();
    }
}
