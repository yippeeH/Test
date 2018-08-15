package com.drawing.commands;

import com.drawing.Canvas;
import com.drawing.Color;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by yinpinghou on 15/8/18.
 */
public class BucketFillCommandTest {
    private com.drawing.commands.Command command;
    private Canvas canvas;

    @Before
    public void prepare() {
        canvas = new Canvas(7, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidNumOfArgs1() {
        command = new BucketFillCommand(canvas, new String[]{"0", "0", "0", "0", "1"});
        command.execute();

    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidNumOfArgs2() {
        command = new BucketFillCommand(canvas, new String[]{"0", "0"});
        command.execute();

    }

    @Test(expected = IllegalArgumentException.class)
    public void testOutOfCanvasArgs1() {
        command = new BucketFillCommand(canvas, new String[]{"0", "2", "c"});
        command.execute();

    }

    @Test(expected = IllegalArgumentException.class)
    public void testOutOfCanvasArgs2() {
        command = new BucketFillCommand(canvas, new String[]{"8", "2", "c"});
        command.execute();

    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidColor() {
        command = new BucketFillCommand(canvas, new String[]{"3", "2", "ca"});
        command.execute();

    }

    @Test
    public void testValidFill() {
        command = new BucketFillCommand(canvas, new String[]{"1", "1", "c"});
        command.execute();
        System.out.println(canvas);
        Color newColor = new Color('c');
        for (int i = 1; i <= 7; ++i) {
            for (int j = 1; j <= 5; ++j) {
                Assert.assertEquals(newColor, canvas.getPixel(i, j));
            }
        }
    }
}
