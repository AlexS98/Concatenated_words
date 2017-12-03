package trie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PrefixTree {
    public PrefixTreeNode node;

    public PrefixTree() {
        node = new PrefixTreeNode();
    }

    public void insert(String word){
        char letter;
        PrefixTreeNode currentNode = node;
        for (int i = 0; i < word.length(); i++){
            letter = word.charAt(i);
            if(!currentNode.hasChild(letter))
                currentNode.addChild(letter);
            currentNode = currentNode.getChild(letter);
        }
        currentNode.isFullWord = true;
    }

    public List<Integer> getSuffice(String string){
        List<Integer> indexes = new LinkedList<>();
        char letter;
        PrefixTreeNode currentNode = node;
        for (int i = 0; i < string.length(); i++) {
            letter = string.charAt(i);
            if(!currentNode.hasChild(letter)){
                return indexes;
            }
            currentNode = currentNode.getChild(letter);
            if(currentNode.isFullWord){
                indexes.add(i + 1);
            }
        }
        return indexes;
    }

    public LinkedList<String[]> build(String path) {
        File file = new File(path);
        LinkedList<String[]> list = new LinkedList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
             System.out.println(e.getStackTrace().toString());
        }
        String word;
        List<Integer> suffixIndices;
        while (scanner.hasNext()) {
            word = scanner.next();
            suffixIndices = this.getSuffice(word);
            for (int i : suffixIndices) {
                list.add(new String[]{word, word.substring(i)});
            }
            this.insert(word);
        }
        return list;
    }

    public String findWords(LinkedList<String[]> list){
        HashSet<String> concatenatedWords = new HashSet<>();
        String[] pair;
        int maxLength = 0;
        String longest = "";
        String secondLongest = "";
        List<Integer> suffixIndices;
        while(!list.isEmpty()){
            pair = list.removeFirst();
            suffixIndices = this.getSuffice(pair[1]);
            for (int i : suffixIndices) {
                if(i == pair[1].length()){
                    if(pair[0].length() > maxLength){
                        secondLongest = longest;
                        maxLength = pair[0].length();
                        longest = pair[0];
                    }
                    concatenatedWords.add(pair[0]);
                }
                else{
                    list.add(new String[]{pair[0], pair[1].substring(i)});
                }
            }
        }
        return " Concatenated words: " + concatenatedWords.size() +
                "\n First longest word: " + longest +
                "\n Second longest word: " + secondLongest;
    }
}
