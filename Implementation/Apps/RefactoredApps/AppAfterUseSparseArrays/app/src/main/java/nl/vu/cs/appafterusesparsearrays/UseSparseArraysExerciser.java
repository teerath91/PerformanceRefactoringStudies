package nl.vu.cs.appafterusesparsearrays;


import android.util.SparseIntArray;


public class UseSparseArraysExerciser implements Exerciser {

    @Override
    public void exercise() {
        int mapSize = 10;
        SparseIntArray myMap = new SparseIntArray(mapSize);
        myMap.put(6, 100);
    }
}
