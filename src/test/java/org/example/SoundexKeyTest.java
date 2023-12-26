package org.example;

import static org.junit.Assert.*;

public class SoundexKeyTest {

    @org.junit.Test
    public void keyMaker() {
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
    public void letterCheck() {
        SoundexKey soundexMaker = new SoundexKey();
        
    }
}