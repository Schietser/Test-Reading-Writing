package be.intecbrussel;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class Animal implements Serializable {

    private String name;
    private boolean edible;

    public Animal(String name, boolean edible) {
        this.name = name;
        this.edible = edible;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEdible() {
        return edible;
    }

    public void setEdible(boolean edible) {
        this.edible = edible;
    }

    public void transferAnimalToFile(Animal animal){

        Path path = Path.of("FromRubenToJoey/animal.txt");

        if (!Files.exists(path.getParent())){
            try {
                Files.createDirectories(path.getParent());
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        //Write animal to file

        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("FromRubenToJoey/animal.txt"))){
            objectOutputStream.writeObject(animal);
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public void readAnimal(Animal animal){
        try(ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("FromRubenToJoey/animal.txt"))){

            Animal a;

            while ((a = (Animal) objectInputStream.readObject()) != null){
                System.out.println(a);
            }
        } catch (EOFException e){
            System.out.println("End of file reached");
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return isEdible() == animal.isEdible() && Objects.equals(getName(), animal.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), isEdible());
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", edible=" + edible +
                '}';
    }
}
