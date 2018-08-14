package com.test.apps.drawing.commands;

import com.test.apps.drawing.Canvas;
import com.test.apps.drawing.Color;
import com.test.apps.drawing.utils.ValidateUtils;
import org.apache.log4j.Logger;

import java.util.Arrays;

import static com.test.apps.drawing.utils.ValidateUtils.isWithinCanvas;

/**
 * Created by yinpinghou on 15/8/18.
 */
public class BucketFillCommand implements Command {

    private static final Logger logger = Logger.getLogger(BucketFillCommand.class);

    @Override
    public Canvas execute(Canvas canvas, String[] args) throws Exception {
        int[] intArgs = ValidateUtils.convertStringArrToIntArr(args, 0, args.length - 2);
        String colorArg = args[args.length - 1];
        if (!isValidArgs(canvas, intArgs, colorArg)) {
            throw new Exception("Invalid Command. ");
        }

        fill(canvas, intArgs[0], intArgs[1], canvas.getPixel(intArgs[0], intArgs[1]), new Color(colorArg.charAt(0)));
        return canvas;
    }

    private boolean isValidArgs(Canvas canvas, int[] args, String colorArg) {
        if (canvas == Canvas.NULL_CANVAS) {
            logger.error("No Canvas available. Please create a canvas first. ");
        }
        int expectedNumArgs = 3;
        String errPrefix = "Invalid arguments for command " + getClass().getSimpleName() + ": " + Arrays.toString(args);
        if (args == null || args.length + 1 != expectedNumArgs) {
            logger.error(errPrefix + "; " +
                    "Expected " + expectedNumArgs + ", but got " + (args == null ? "1" : args.length + 1) + ". ");
            return false;
        }
        try {
            int x = args[0], y = args[1];
            if (!isWithinCanvas(canvas, x, y)) {
                logger.error(errPrefix + ": out of range coordination. ");
                return false;
            }
        } catch (Exception e) {
            logger.error(errPrefix);
            return false;
        }
        if (colorArg == null || colorArg.length() != 1) {
            logger.error(errPrefix + ": Invalid color for painting. ");
            return false;
        }
        return true;
    }

    private void fill(Canvas canvas, int x, int y, Color oldColor, Color newColor) {
        if (x >= 0 && x <= canvas.getWidth() && y >= 0 && y <= canvas.getHeight()) {
            if (!oldColor.equals(newColor) && oldColor.equals(canvas.getPixel(x, y))) {
                canvas.paintPixel(x, y, newColor);
                fill(canvas, x + 1, y, oldColor, newColor);
                fill(canvas, x - 1, y, oldColor, newColor);
                fill(canvas, x, y + 1, oldColor, newColor);
                fill(canvas, x, y - 1, oldColor, newColor);
            }
        }

    }
}
