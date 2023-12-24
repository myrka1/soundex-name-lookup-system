package org.example;
import java.io.File;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");

        File file = new File("resources/name15k.txt"); //file
        try(BufferedReader reader  = new BufferedReader(new FileReader(file)))
        {
            String line;
            while((line = reader.readLine()) != null) { //read each line of file
                String[] parts = line.split(" "); //split each line into array
                if(parts.length == 51) { //lines being used should be array length 51
                    String name = parts[0]; //name(last) will always be in the first element
                    String soundexKey = SoundexKey.keyMaker(name);
                    System.out.println("NAME: " + name + " SOUNDEX KEY: " + soundexKey);
                }
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}