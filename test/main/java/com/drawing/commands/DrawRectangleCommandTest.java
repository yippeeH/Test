package com.drawing.commands;

import com.drawing.Canvas;
import com.drawing.utils.Constants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by yinpinghou on 15/8/18.
 */
public class DrawRectangleCommandTest {

    private Canvas canvas;

    @Before
    public void prepare() {
        canvas = new Canvas(7, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidNumOfArgs1() {
        Command command = new DrawRectangleCommand(canvas, new String[]{"0", "0", "0", "0", "1"});
        command.execute();
        System.out.println(canvas);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidNumOfArgs2() {
        Command command = new DrawRectangleCommand(canvas, new String[]{"0", "0", "0"});
        command.execute();
        System.out.println(canvas);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOutOfCanvasArgs1() {
        Command command = new DrawRectangleCommand(canvas, new String[]{"1", "2", "0", "0"});
        command.execute();
        System.out.println(canvas);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOutOfCanvasArgs2() {
        Command command = new DrawRectangleCommand(canvas, new String[]{"8", "2", "1", "3"});
        command.execute();
        System.out.println(canvas);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSameRowArgs() {
        Command command = new DrawRectangleCommand(canvas, new String[]{"6", "2", "6", "3"});
        command.execute();
        System.out.println(canvas);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSameColumnArgs() {
        Command command = new DrawRectangleCommand(canvas, new String[]{"6", "2", "1", "2"});
        command.execute();
        System.out.println(canvas);
    }

    @Test
    public void testValidRectangles() {
        Command command = new DrawRectangleCommand(canvas, new String[]{"5 ", " 2", "1", "4"});
        command.execute();
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
