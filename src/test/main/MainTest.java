package main;

import org.junit.Assert;
import org.junit.Test;

import static main.Main.takeMetrics;

public class MainTest {
    @Test
    public void takeMetricsTest() throws Exception {
        String metrics = takeMetrics("test.txt");
        Assert.assertEquals(metrics.substring(0,metrics.indexOf('U')),
                " Concatenated words: 3\n First longest word: ratcatdogcat\n Second longest word: catsdogcats\n");
    }

}