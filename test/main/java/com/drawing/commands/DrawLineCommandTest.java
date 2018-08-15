package com.drawing.commands;

import com.drawing.Canvas;
import com.drawing.utils.Constants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by yinpinghou on 14/8/18.
 */
public class DrawLineCommandTest {

    private Command command;
    private Canvas canvas;

    @Before
    public void prepare() {
        canvas = new Canvas(7, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidNumOfArgs1() {
        command = new DrawLineCommand(canvas, new String[]{"0", "0", "0", "0", "1"});
        command.execute();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidNumOfArgs2() {
        command = new DrawLineCommand(canvas, new String[]{"0", "0", "0"});
        command.execute();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOutOfCanvasArgs1() {
        command = new DrawLineCommand(canvas, new String[]{"1", "2", "0", "0"});
        command.execute();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOutOfCanvasArgs2() {
        command = new DrawLineCommand(canvas, new String[]{"8", "2", "1", "2"});
        command.execute();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUnsupportedLineArgs() {
        command = new DrawLineCommand(canvas, new String[]{"6", "2", "1", "3"});
        command.execute();
    }

    @Test
    public void testHorizontalLine() {
        command = new DrawLineCommand(canvas, new String[]{"6 ", "2", "1 ", " 2"});
        command.execute();
        System.out.println(canvas);
        for (int i = 1; i <= 6; ++i) {
            Assert.assertEquals(Constants.LINE_COLOR, canvas.getPixel(i, 2));
        }
    }

    @Test
    public void testVerticalLine() {
        command = new DrawLineCommand(canvas, new String[]{"1 ", " 5", "1", "2"});
        command.execute();
        System.out.println(canvas);
        for (int j = 2; j <= 5; ++j) {
            Assert.assertEquals(Constants.LINE_COLOR, canvas.getPixel(1, j));
        }
    }
}
