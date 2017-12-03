package main;

import trie.PrefixTree;

import java.util.LinkedList;

public class Main {

    private static long startTime = 0, endTime = 0, startMemory = 0, endMemory = 0, nanoTime = 0, bytesMemory = 0;
    private static double secondsTime = 0.0, megaBytesMemory = 0.0;

    public static void main(String[] args) {
        System.out.println(takeMetrics());
    }

    public static String takeMetrics(){
        startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        startTime = System.nanoTime();
        PrefixTree myTrie = new PrefixTree();
        LinkedList<String[]> list = myTrie.build("words.txt");
        String result = myTrie.findWords(list);
        endTime = System.nanoTime();
        nanoTime = endTime - startTime;
        secondsTime = nanoTime / 1000000000.0;
        endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        bytesMemory = endMemory - startMemory;
        megaBytesMemory = bytesMemory / (1024.0 * 1024.0);
        return result + "\nUsing " + secondsTime + " seconds & " + megaBytesMemory + " MBytes of memory";
    }
}
