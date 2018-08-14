package com.test.apps.drawing.commands;

import com.test.apps.drawing.Canvas;
import com.test.apps.drawing.utils.Constants;
import com.test.apps.drawing.utils.ValidateUtils;
import org.apache.log4j.Logger;

import java.util.Arrays;

import static com.test.apps.drawing.utils.ValidateUtils.isWithinCanvas;

/**
 * Created by yinpinghou on 14/8/18.
 */
public class DrawLineCommand implements Command {

    private static final Logger logger = Logger.getLogger(DrawLineCommand.class);

    @Override
    public Canvas execute(Canvas canvas, String[] args) throws Exception {
        int[] intArgs = ValidateUtils.convertStringArrToIntArr(args, 0, args.length - 1);

        if (!isValidArgs(canvas, intArgs)) {
            throw new Exception("Invalid Command. ");
        }
        int x1 = intArgs[0], y1 = intArgs[1], x2 = intArgs[2], y2 = intArgs[3];

        for (int i = Math.min(x1, x2); i <= Math.max(x1, x2); ++i) {
            for (int j = Math.min(y1, y2); j <= Math.max(y1, y2); ++j) {
                canvas.paintPixel(i, j, Constants.LINE_COLOR);
            }
        }

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
            if (x1 != x2 && y1 != y2) {
                logger.error(errPrefix + ": Only horizontal or vertical lines are supported. ");
                return false;
            }
        } catch (Exception e) {
            logger.error(errPrefix);
            return false;
        }
        return true;
    }

}
