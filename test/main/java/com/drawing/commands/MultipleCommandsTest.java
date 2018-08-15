package com.drawing.commands;

import com.drawing.Canvas;
import org.junit.Test;

/**
 * Created by yinpinghou on 15/8/18.
 */
public class MultipleCommandsTest {

    @Test
    public void test() {
        Canvas canvas = new Canvas();
        System.out.println(canvas);

        Command createCanvasCommand = new CreateCanvasCommand(canvas, new String[]{"20", "4"});
        createCanvasCommand.execute();
        System.out.println(canvas);


        Command drawLineCommand1 = new DrawLineCommand(canvas, new String[]{"1", "2", "6", "2"});
        drawLineCommand1.execute();
        System.out.println(canvas);


        Command drawLineCommand2 = new DrawLineCommand(canvas, new String[]{"6", "3", "6", "4"});
        drawLineCommand2.execute();
        System.out.println(canvas);


        Command drawRectangleCommand = new DrawRectangleCommand(canvas, new String[]{"14", "1", "18", "3"});
        drawRectangleCommand.execute();
        System.out.println(canvas);

        Command bucketFillCommand = new BucketFillCommand(canvas, new String[]{"10", "3", "o"});
        bucketFillCommand.execute();
        System.out.println(canvas);

    }

}
