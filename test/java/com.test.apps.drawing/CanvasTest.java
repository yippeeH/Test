package com.test.apps.drawing;

import com.test.apps.drawing.utils.Constants;
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

        Color[] borderRow = new Color[w + 2];
        Arrays.fill(borderRow, Constants.HORIZONTAL_BORDER_COLOR);
        Assert.assertArrayEquals(borderRow, c1.getArray()[0]);
        Assert.assertArrayEquals(borderRow, c1.getArray()[c1.getHeight() + 1]);

        Color[] blankRow = new Color[w + 2];
        Arrays.fill(blankRow, Constants.BLANK_COLOR);
        blankRow[0] = Constants.VERTICAL_BORDER_COLOR;
        blankRow[c1.getArray()[0].length - 1] = Constants.VERTICAL_BORDER_COLOR;
        for (int i = 1; i < c1.getArray().length - 1; ++i) {
            Assert.assertArrayEquals(blankRow, c1.getArray()[i]);
        }

        // vertical Border
        for (int j = 1; j < c1.getArray().length - 1; ++j) {
            Assert.assertEquals(Constants.VERTICAL_BORDER_COLOR, c1.getArray()[j][0]);
            Assert.assertEquals(Constants.VERTICAL_BORDER_COLOR, c1.getArray()[j][c1.getArray()[j].length - 1]);
        }
    }

    @Test
    public void testEquals() {
        Canvas c1 = new Canvas(2, 3);
        Canvas c2 = new Canvas(2, 3);
        Canvas c3 = new Canvas(3, 2);
        Assert.assertEquals(c1, c2);
        Assert.assertNotEquals(c1, c3);
    }

}
