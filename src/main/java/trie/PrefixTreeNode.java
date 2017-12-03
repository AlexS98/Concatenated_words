package trie;

import java.util.HashMap;

public class PrefixTreeNode {
    public HashMap<Character, PrefixTreeNode> children;
    public boolean isFullWord;

    public PrefixTreeNode() {
        children = new HashMap<>();
        isFullWord = false;
    }

    public void addChild(char child){
        children.put(child, new PrefixTreeNode());
    }

    public PrefixTreeNode getChild(char child){
        return (children.keySet().contains(child))? children.get(child): null;
    }

    public boolean hasChild(char child){
        return children.keySet().contains(child);
    }
}
