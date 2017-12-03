package trie;

import org.junit.Assert;
import org.junit.Test;

public class PrefixTreeNodeTest {
    @Test
    public void nodeTest() throws Exception {
        PrefixTreeNode node = new PrefixTreeNode();
        PrefixTreeNode newNode = new PrefixTreeNode();
        node.addChild('a');
        newNode.addChild('a');
        Assert.assertNotEquals(node.getChild('a'), newNode.getChild('a'));
        Assert.assertEquals(node.hasChild('a'), newNode.hasChild('a'));
    }
}