package nl.vu.cs.appusesparsearrays;

import java.util.HashMap;


public class UseSparseArraysExerciser implements Exerciser {

    @Override
    public void exercise() {
        int mapSize = 10;
        HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>(mapSize);
        myMap.put(6, 100);
    }
}