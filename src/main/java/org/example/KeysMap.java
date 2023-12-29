package org.example;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/*
    This class creates a treeMap to store the soundex keys(key)
    and the names that produced similar soundex keys as the values
 */
public class KeysMap {
    //SoundexKey,SortedNames is a TreeSet
    private Map<String,SortedNames> treeMap;

    public KeysMap() {
        treeMap = new TreeMap<>();
    }

    public void addEntry(String nameKey,String name)
    {
        if(treeMap.containsKey(nameKey)) { //if soundexKey exists in treemap
            SortedNames nameValues = treeMap.get(nameKey);
            nameValues.addEntry(name);
        }
        else {
            SortedNames nameValues = new SortedNames(); //new sorted names to be used as value
            treeMap.put(nameKey,nameValues); //put new entry in treemap with new soundex key and new sortedNames treeset for name values
            nameValues.addEntry(name); //add first name value
        }
    }

    public SortedNames getSortedNames(String keyName) {
        return treeMap.get(keyName);
    }

    public void display() {
        Iterator<Map.Entry<String,SortedNames>> iterator = treeMap.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String,SortedNames> entry = iterator.next();
            String key = entry.getKey();
            System.out.println("KEY: " + key); //to display key
            //calls method display from SortedNames to display TreeSet elements
            SortedNames value = entry.getValue();
            System.out.print("NAMES: ");
            value.display();
            System.out.println();
        }
    }

    public void displayNeighboringEntries(String surnameKey) {
        Iterator<Map.Entry<String, SortedNames>> iterator = treeMap.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, SortedNames> entry = iterator.next();
            String key = entry.getKey();

            String nameFront = surnameKey.substring(0,2); //firstpart of input soundex key
            int nameBack = Integer.parseInt(surnameKey.substring(2)); //second part of input soundex key
            int keyBack = Integer.parseInt(key.substring(2)); //

            //to make sure the first two chars of the keys match and that they are within a reasonable range of similar names
            if(key.contains(nameFront) && (keyBack >= nameBack-4) && (keyBack <= nameBack+4)) {
                System.out.println("KEY: " + key);
                SortedNames value = entry.getValue();
                System.out.print("NAMES: ");
                value.display();
                System.out.println();
            }
        }
    }
}
