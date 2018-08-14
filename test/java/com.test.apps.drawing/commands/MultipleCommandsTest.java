package com.test.apps.drawing.commands;

import com.test.apps.drawing.Canvas;
import com.test.apps.drawing.CommandManager;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by yinpinghou on 15/8/18.
 */
public class MultipleCommandsTest {

    CommandManager commandManager = null;

    @Before
    public void init() {
        commandManager = CommandManager.getInstance();
    }
    @Test
    public void test() throws Exception {
        Canvas canvas = Canvas.NULL_CANVAS;
        System.out.println(canvas);

        Command command = new CreateCanvasCommand();
        canvas = command.execute(canvas, new String[]{"20", "4"});
        System.out.println(canvas);

        Command command1 = new DrawLineCommand();
        canvas = command1.execute(canvas, new String[]{"1","2","6","2"});
        System.out.println(canvas);

        canvas = command1.execute(canvas, new String[]{"6","3","6","4"});
        System.out.println(canvas);

        Command command2 = new DrawRectangleCommand();
        canvas = command2.execute(canvas, new String[]{"14","1","18","3"});
        System.out.println(canvas);

        Command command3 = new BucketFillCommand();
        canvas = command3.execute(canvas, new String[]{"10","3","o"});
        System.out.println(canvas);
    }

}
