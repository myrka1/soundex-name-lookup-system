package org.example;
/*
    Soundex Key Maker
    Takes a String and returns a soundex key string
    @param name, name that will be made into soundex key
    @return key, soundex key to be returned
    December 23 2023
 */
public class SoundexKey {
    //turns name to soundex key
    public static String keyMaker(String name) {
        StringBuilder key = new StringBuilder();
        //characters in name to digits loop
        int temp = 0;
        for(int i = 0; i < name.length(); i++) {
            int current = letterCheck(name.charAt(i));
            //skip double digits, don't add 7's
            if(current != temp && current != 7) key.append(current);
            temp = current;
        }
        //replace first digit with first letter of name
        key.replace(0,1,name.charAt(0)+"");
        //make sure key is length 4
        //add 0's to lengthen, shorten if longer
        if(key.length() < 4) {
            while(key.length() < 4) key.append('0');
        }
        else if(key.length() > 4) {
            while(key.length() > 4) key.deleteCharAt(key.length()-1);
        }
        return key.toString();
    }

    //char to number
    public static int letterCheck(char character) {
        char low = Character.toLowerCase(character);
        if(low == 'b' || low == 'p' || low == 'f' || low == 'v') return 1;
        else if(low == 'c' || low == 's' || low == 'k' || low == 'g' ||
                low == 'j' || low == 'q' || low == 'x' || low == 'z')
            return 2;
        else if(low == 'd' || low == 't') return 3;
        else if(low == 'l') return 4;
        else if(low == 'm' || low == 'n') return 5;
        else if(low == 'r') return 6;
        return 7;
    }
}
