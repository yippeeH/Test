package com.test.apps.drawing.commands;

import com.test.apps.drawing.Canvas;
import com.test.apps.drawing.Color;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by yinpinghou on 15/8/18.
 */
public class BucketFillCommandTest {
    private Command command;
    private Canvas canvas;

    @Before
    public void prepare() {
        command = new BucketFillCommand();
        canvas = new Canvas(7, 5);
    }

    @Test(expected = Exception.class)
    public void testInvalidNumOfArgs1() throws Exception {
        command.execute(canvas, new String[]{"0", "0", "0", "0", "1"});
    }

    @Test(expected = Exception.class)
    public void testInvalidNumOfArgs2() throws Exception {
        command.execute(canvas, new String[]{"0", "0"});
    }

    @Test(expected = Exception.class)
    public void testOutOfCanvasArgs1() throws Exception {
        command.execute(canvas, new String[]{"0", "2", "c"});
    }

    @Test(expected = Exception.class)
    public void testOutOfCanvasArgs2() throws Exception {
        command.execute(canvas, new String[]{"8", "2", "c"});
    }

    @Test(expected = Exception.class)
    public void testInvalidColor() throws Exception {
        command.execute(canvas, new String[]{"3", "2", "ca"});
    }

    @Test
    public void testValidFill() throws Exception {
        command.execute(canvas, new String[]{"1", "1", "c"});
        System.out.println(canvas);
        Color newColor = new Color('c');
        for (int i = 1; i <= 7; ++i) {
            for (int j = 1; j <= 5; ++j) {
                Assert.assertEquals(newColor, canvas.getPixel(i, j));
            }
        }
    }
}
