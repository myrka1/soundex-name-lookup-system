package org.example;
import java.util.*;

/*
    Creates a tree set to store names in natural order
 */

public class SortedNames {
    TreeSet<String> sortedNames;

    public SortedNames() { //constructor
        sortedNames = new TreeSet<>();
    }

    public void addEntry(String name) {
        sortedNames.add(name);
    }

    public SortedNames getValue() {
        return this; //returns sortedNames TreeSet
    }

    public void display() //to print each item in sortedNames
    {
        Iterator<String> iterator = sortedNames.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
            System.out.println("");
        }
        System.out.println();
    }
}
