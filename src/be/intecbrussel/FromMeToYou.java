package be.intecbrussel;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FromMeToYou {

    public static void writeMessage(){

        Path path = Path.of("FromRubenToJoey/message.txt");

        if (!Files.exists(path.getParent())){
            try {
                Files.createDirectories(path.getParent());
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
                "FromRubenToJoey/message.txt"))){
            bufferedWriter.write("Why do java programmers wear glasses?\nBecause they don't C#.");
        } catch (IOException e){
            e.printStackTrace();
        }


    }

    public static void readMessage(){

        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader("FromRubenToJoey/message.txt"))) {

            String line;

            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }

        } catch (IOException e){
            e.printStackTrace();
        }


    }


}
