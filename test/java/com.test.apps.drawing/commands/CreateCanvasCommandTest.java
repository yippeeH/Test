package com.test.apps.drawing.commands;

import com.sun.tools.javah.Util;
import com.test.apps.drawing.Canvas;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CreateCanvasCommandTest {

    private Command command;

    @Before
    public void prepare() {
        command = new CreateCanvasCommand();
    }

    @Test(expected = Exception.class)
    public void testInvalidNumOfArgs() throws Exception {
        Canvas canvas = command.execute(Canvas.NULL_CANVAS, new String[]{"1"});
    }

    @Test(expected = Exception.class)
    public void testInvalidNumOfArgs2() throws Exception {
        Canvas canvas = command.execute(Canvas.NULL_CANVAS, new String[]{"1", "3", "2"});
    }

    @Test(expected = Exception.class)
    public void testInvalidArgs1() throws Exception {
        Canvas canvas = command.execute(Canvas.NULL_CANVAS, new String[]{"0", "1"});
    }

    @Test(expected = Exception.class)
    public void testInvalidArgs2() throws Exception {
        Canvas canvas = command.execute(Canvas.NULL_CANVAS, new String[]{"1", "0"});
    }

    @Test(expected = Exception.class)
    public void testInvalidArgs3() throws Exception {
        Canvas canvas = command.execute(Canvas.NULL_CANVAS, new String[]{"0", "0"});
    }

    @Test
    public void testValidArg() throws Exception {
        Canvas canvas = command.execute(Canvas.NULL_CANVAS, new String[]{"5 ", " 4"});
        Canvas expected = new Canvas(5, 4);
        System.out.println(canvas);
        Assert.assertEquals(expected, canvas);
    }

}
