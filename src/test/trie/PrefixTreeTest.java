package trie;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class PrefixTreeTest {
    @Test
    public void trieTest() throws Exception {
        PrefixTree myTrie = new PrefixTree();
        LinkedList<String[]> list = myTrie.build("test.txt");
        Assert.assertEquals(myTrie.findWords(list),
                " Concatenated words: 3\n First longest word: ratcatdogcat\n Second longest word: catsdogcats");
    }

}