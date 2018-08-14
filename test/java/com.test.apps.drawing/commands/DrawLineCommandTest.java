package com.test.apps.drawing.commands;

import com.test.apps.drawing.Canvas;
import com.test.apps.drawing.utils.Constants;
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
        command = new DrawLineCommand();
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
        command.execute(canvas, new String[]{"8", "2", "1", "2"});
    }

    @Test(expected = Exception.class)
    public void testUnsupportedLineArgs() throws Exception {
        command.execute(canvas, new String[]{"6", "2", "1", "3"});
    }

    @Test
    public void testHorizontalLine() throws Exception {
        command.execute(canvas, new String[]{"6 ", "2", "1 ", " 2"});
        System.out.println(canvas);
        for (int i = 1; i <= 6; ++i) {
            Assert.assertEquals(Constants.LINE_COLOR, canvas.getPixel(i, 2));
        }
    }

    @Test
    public void testVerticalLine() throws Exception {
        command.execute(canvas, new String[]{"1 ", " 5", "1", "2"});
        System.out.println(canvas);
        for (int j = 2; j <= 5; ++j) {
            Assert.assertEquals(Constants.LINE_COLOR, canvas.getPixel(1, j));
        }
    }
}
