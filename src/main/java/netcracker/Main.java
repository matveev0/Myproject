package netcracker;

import netcracker.exceptions.MyException;
import netcracker.menu.Menu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws MyException, IOException {
        Menu menu = new Menu();
        menu.ShowMenu();
    }
}
