package com.test.apps.drawing;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by yinpinghou on 13/8/18.
 */
public class CanvasTest {

    @Test
    public void testCanvasConstructor() {
        int w = 20, h = 4;
        Canvas c1 = new Canvas(w, h);
        System.out.println(c1);
        Assert.assertNotNull(c1);
        Assert.assertEquals(w, c1.getWidth());
        Assert.assertEquals(h, c1.getHeight());
        Color[] firstRow = new Color[w + 2];
        Arrays.fill(firstRow, Color.HORIZONTAL_BORDER_COLOR);
        Assert.assertArrayEquals(firstRow, c1.getArray()[0]);
        Assert.assertArrayEquals(firstRow, c1.getArray()[c1.getHeight() + 1]);

    }

}
