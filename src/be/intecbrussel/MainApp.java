package be.intecbrussel;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class MainApp {

    public static void main(String[] args) {

        FromMeToYou.writeMessage();
        FromMeToYou.readMessage();

        System.out.println();

        Animal animal = new Animal("Skippy", false);

        animal.transferAnimalToFile(animal);
        animal.readAnimal(animal);

    }
}
