package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        //Initializing App
        startSequenceSearch();
    }

    private static void startSequenceSearch() {
        boolean keepRunning;
        do {
            keepRunning = SequenceSearch.process();
        }
        while (keepRunning);
    }
}
