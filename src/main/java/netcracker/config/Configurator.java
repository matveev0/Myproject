package netcracker.config;

import netcracker.interfaces.Sorter;
import netcracker.interfaces.Sorter;
import netcracker.sorts.*;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configurator {
    private static String sort;

    private Configurator() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream(new File("D:\\Универ\\Netcracker\\Java\\Myproject\\src\\main\\resources\\properties")));
        sort = props.getProperty("sort");
    }

    public Sorter getSorter() {
        switch (sort) {
            case "bubble": {
                return new BubbleSorter();
            }
            case "quick": {
                return new QuickSorter();
            }
            case "shell": {
                return new ShellSorter();
            }
            default:
                return new BubbleSorter();
        }
    }

    public static Configurator getInstance() throws IOException {
        return new Configurator();
    }
}
