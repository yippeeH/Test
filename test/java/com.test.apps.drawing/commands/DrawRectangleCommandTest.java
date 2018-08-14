package com.test.apps.drawing.commands;

import com.test.apps.drawing.Canvas;
import com.test.apps.drawing.utils.Constants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by yinpinghou on 15/8/18.
 */
public class DrawRectangleCommandTest {
    private Command command;
    private Canvas canvas;

    @Before
    public void prepare() {
        command = new DrawRectangleCommand();
        canvas = new Canvas(7, 5);
    }

    @Test(expected = Exception.class)
    public void testInvalidNumOfArgs1() throws Exception {
        command.execute(canvas, new String[]{"0", "0", "0", "0", "1"});
    }

    @Test(expected = Exception.class)
    public void testInvalidNumOfArgs2() throws Exception {
        command.execute(canvas, new String[]{"0", "0", "0"});
    }

    @Test(expected = Exception.class)
    public void testOutOfCanvasArgs1() throws Exception {
        command.execute(canvas, new String[]{"1", "2", "0", "0"});
    }

    @Test(expected = Exception.class)
    public void testOutOfCanvasArgs2() throws Exception {
        command.execute(canvas, new String[]{"8", "2", "1", "3"});
    }

    @Test(expected = Exception.class)
    public void testSameRowArgs() throws Exception {
        command.execute(canvas, new String[]{"6", "2", "6", "3"});
    }

    @Test(expected = Exception.class)
    public void testSameColumnArgs() throws Exception {
        command.execute(canvas, new String[]{"6", "2", "1", "2"});
    }

    @Test
    public void testValidRectangles() throws Exception {
        command.execute(canvas, new String[]{"5 ", " 2", "1", "4"});
        System.out.println(canvas);
        for (int i = 1; i <= 5; ++i) {
            Assert.assertEquals(Constants.LINE_COLOR, canvas.getPixel(i, 2));
            Assert.assertEquals(Constants.LINE_COLOR, canvas.getPixel(i, 4));
        }
        for (int j = 2; j <= 4; ++j) {
            Assert.assertEquals(Constants.LINE_COLOR, canvas.getPixel(1, j));
            Assert.assertEquals(Constants.LINE_COLOR, canvas.getPixel(5, j));
        }
    }
}
