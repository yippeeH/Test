package com.drawing.commands;

import com.drawing.Canvas;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CreateCanvasCommandTest {

    private Canvas canvas;

    @Before
    public void before() {
        canvas = new Canvas();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidNumOfArgs() {
        Command command = new CreateCanvasCommand(canvas, new String[]{"1"});
        command.execute();
        System.out.println(canvas);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidNumOfArgs2() {
        Command command = new CreateCanvasCommand(canvas, new String[]{"1", "3", "2"});
        command.execute();
        System.out.println(canvas);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidArgs1() {
        Command command = new CreateCanvasCommand(canvas, new String[]{"0", "1"});
        command.execute();
        System.out.println(canvas);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidArgs2() {
        Command command = new CreateCanvasCommand(canvas, new String[]{"1", "0"});
        command.execute();
        System.out.println(canvas);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidArgs3() {
        Command command = new CreateCanvasCommand(canvas, new String[]{"0", "0"});
        command.execute();
        System.out.println(canvas);
    }

    @Test
    public void testValidArg() {
        Command command = new CreateCanvasCommand(canvas, new String[]{"5 ", " 4"});
        command.execute();
        Canvas expected = new Canvas(5, 4);
        System.out.println(canvas);
        Assert.assertEquals(expected, canvas);
    }

}
