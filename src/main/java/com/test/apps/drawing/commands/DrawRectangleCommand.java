package com.test.apps.drawing.commands;

import com.test.apps.drawing.Canvas;
import com.test.apps.drawing.utils.ValidateUtils;
import org.apache.log4j.Logger;

import java.util.Arrays;

import static com.test.apps.drawing.utils.ValidateUtils.isWithinCanvas;

/**
 * Created by yinpinghou on 15/8/18.
 */
public class DrawRectangleCommand implements Command {

    private static final Logger logger = Logger.getLogger(DrawRectangleCommand.class);

    @Override
    public Canvas execute(Canvas canvas, String[] args) throws Exception {
        int[] intArgs = ValidateUtils.convertStringArrToIntArr(args, 0, args.length - 1);
        if (!isValidArgs(canvas, intArgs)) {
            throw new Exception("Invalid Command. ");
        }
        String x1 = args[0], y1 = args[1], x2 = args[2], y2 = args[3];
        Command drawLineCommand = new DrawLineCommand();
        drawLineCommand.execute(canvas, new String[]{x1, y1, x2, y1});
        drawLineCommand.execute(canvas, new String[]{x2, y1, x2, y2});
        drawLineCommand.execute(canvas, new String[]{x2, y2, x1, y2});
        drawLineCommand.execute(canvas, new String[]{x1, y2, x1, y1});

        return canvas;
    }

    private boolean isValidArgs(Canvas canvas, int[] args) {
        if (canvas == Canvas.NULL_CANVAS) {
            logger.error("No Canvas available. Please create a canvas first. ");
        }
        int expectedNumArgs = 4;
        String errPrefix = "Invalid arguments for command " + getClass().getSimpleName() + ": " + Arrays.toString(args);
        if (args == null || args.length != expectedNumArgs) {
            logger.error(errPrefix + "; " +
                    "Expected " + expectedNumArgs + ", but got " + (args == null ? "0" : args.length) + ". ");
            return false;
        }
        try {
            int x1 = args[0], y1 = args[1], x2 = args[2], y2 = args[3];

            if (!isWithinCanvas(canvas, x1, y1) || !isWithinCanvas(canvas, x2, y2)) {
                logger.error(errPrefix + ": out of range coordination. ");
                return false;
            }
            if (x1 == x2 || y1 == y2) {
                logger.error(errPrefix + ": coordinations can not be in the same row/column. ");
                return false;
            }
        } catch (Exception e) {
            logger.error(errPrefix);
            return false;
        }
        return true;
    }
}
