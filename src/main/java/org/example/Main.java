package org.example;
import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.nio.Buffer;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        KeysMap namesMap = new KeysMap();


        File file = new File("resources/name15k.txt"); //file
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) { //read each line of file
                String[] parts = line.split(" "); //split each line into array
                if (parts.length == 51) { //lines being used should be array length 51
                    String name = parts[0]; //name(last) will always be in the first element
                    String soundexKey = SoundexKey.keyMaker(name);
                    namesMap.addEntry(soundexKey, name);
                    //System.out.println("NAME: " + name + " SOUNDEX KEY: " + soundexKey);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        File fileName = new File("soundex_names_file.txt");
        if(!fileName.exists()) {
            try {
                fileName.createNewFile();
                outputToFile(namesMap,fileName); //file creation for output
            } catch(IOException e) {
                System.out.println("File not created");
            }
        }
        namesMap.display();
        System.out.println();

        userStuff(namesMap);
    }

    private static void outputToFile(KeysMap namesMap,File filePath) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            //Redirect to file
            System.setOut(new java.io.PrintStream(new java.io.OutputStream() {
                @Override
                public void write(int x) {
                    try {
                        writer.write(x);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }, true));
            //display will print to file
            namesMap.display();
            //undo the redirect
            System.setOut(new java.io.PrintStream(new java.io.FileOutputStream(java.io.FileDescriptor.out)));
            System.out.println("FILE DONE");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void userStuff(KeysMap namesMap) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a surname: ");
        String surname = keyboard.nextLine();
        String surnameKey = SoundexKey.keyMaker(surname);
        System.out.println("Soundex key for " + surname + ": " + surnameKey);
        System.out.println("Similar sounding names: ");
        namesMap.displayNeighboringEntries(surnameKey);
    }

}