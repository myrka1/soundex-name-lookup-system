package org.example;

import static org.junit.Assert.*;

public class SoundexKeyTest {

    @org.junit.Test
    public void keyMaker() { //tests that correct soundexkey for a name is returned
        SoundexKey soundexMaker = new SoundexKey();

        String name1 = "Briggs";
        String testKey1 = soundexMaker.keyMaker(name1);
        assertEquals("B620",testKey1);

        String name2 = "Bailey";
        String testKey2 = soundexMaker.keyMaker(name2);
        assertEquals("B400",testKey2);

        String name3 = "Ballie";
        String testKey3 = soundexMaker.keyMaker(name3);
        assertEquals("B400",testKey3);

        String name4 = "Knuth";
        String testKey4 = soundexMaker.keyMaker(name4);
        assertEquals("K530",testKey4);
    }

    @org.junit.Test
    public void letterCheck() { //for correct letter check
        SoundexKey soundexMaker = new SoundexKey();

        Character letter1 = 'h';
        int test1 = soundexMaker.letterCheck(letter1);
        assertEquals(7,test1);

        Character letter2 = '&';
        int test2 = soundexMaker.letterCheck(letter2);
        assertEquals(7,test2);

        Character letter3 = 'm';
        int test3 = soundexMaker.letterCheck(letter3);
        assertEquals(5,test3);

        Character letter4 = 'f';
        int test4 = soundexMaker.letterCheck(letter4);
        assertEquals(1,test4);

        Character letter5 = 'q';
        int test5 = soundexMaker.letterCheck(letter5);
        assertEquals(2,test5);
    }
}