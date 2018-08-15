package com.drawing.commands;

import com.drawing.Canvas;
import com.drawing.Color;
import com.drawing.utils.ValidateUtils;

import java.util.Arrays;

/**
 * Created by yinpinghou on 15/8/18.
 */
public class BucketFillCommand implements Command {

    private final Canvas canvas;
    private final int x;
    private final int y;
    private final Color color;

    public BucketFillCommand(Canvas canvas, String[] args) {
        int[] intArgs = ValidateUtils.convertStringArrToIntArr(args, 0, args.length - 2);
        String colorArg = args[args.length - 1];
        validateArgs(canvas, intArgs, colorArg);
        this.canvas = canvas;
        this.x = intArgs[0];
        this.y = intArgs[1];
        this.color = new Color(colorArg.charAt(0));
    }

    @Override
    public void execute() {
        fill(canvas, x, y, canvas.getPixel(x, y), color);
    }

    private boolean validateArgs(Canvas canvas, int[] args, String colorArg) {
        if (canvas == null || !canvas.isInit()) {
            throw new IllegalArgumentException("No Canvas available. Please create a canvas first. ");
        }
        String errPrefix = "Invalid arguments for command " + getClass().getSimpleName() + ": " + Arrays.toString(args);
        if (args == null || args.length + 1 != getExpectedNumArgs()) {
            throw new IllegalArgumentException(errPrefix + "; " +
                    "Expected " + getExpectedNumArgs() + ", but got " + (args == null ? "1" : args.length + 1) + ". ");
        }

        int x = args[0], y = args[1];
        if (!ValidateUtils.isWithinCanvas(canvas, x, y)) {
            throw new IllegalArgumentException(errPrefix + ": out of range coordination. ");
        }

        if (colorArg == null || colorArg.length() != 1) {
            throw new IllegalArgumentException(errPrefix + ": Invalid color for painting. ");
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

    private static int getExpectedNumArgs() {
        return 3;
    }
}
