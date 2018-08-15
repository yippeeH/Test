package com.drawing.commands;

import com.drawing.Canvas;
import com.drawing.utils.Constants;
import com.drawing.utils.ValidateUtils;

import java.util.Arrays;

import static com.drawing.utils.ValidateUtils.isWithinCanvas;

/**
 * Created by yinpinghou on 14/8/18.
 */
public class DrawLineCommand implements Command {

    private final Canvas canvas;
    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;

    public DrawLineCommand(Canvas canvas, String[] args) {
        int[] intArgs = ValidateUtils.convertStringArrToIntArr(args, 0, args.length - 1);
        validateArgs(canvas, intArgs);
        this.canvas = canvas;
        x1 = intArgs[0];
        y1 = intArgs[1];
        x2 = intArgs[2];
        y2 = intArgs[3];
    }

    @Override
    public void execute() {
        for (int i = Math.min(x1, x2); i <= Math.max(x1, x2); ++i) {
            for (int j = Math.min(y1, y2); j <= Math.max(y1, y2); ++j) {
                canvas.paintPixel(i, j, Constants.LINE_COLOR);
            }
        }
    }

    private boolean validateArgs(Canvas canvas, int[] args) {
        if (canvas == null || !canvas.isInit()) {
            throw new IllegalArgumentException("No Canvas available. Please create a canvas first. ");
        }
        String errPrefix = "Invalid arguments for command " + getClass().getSimpleName() + ": " + Arrays.toString(args);
        if (args == null || args.length != getExpectedNumArgs()) {
            throw new IllegalArgumentException(errPrefix + "; " +
                    "Expected " + getExpectedNumArgs() + ", but got " + (args == null ? "0" : args.length) + ". ");
        }

        int x1 = args[0], y1 = args[1], x2 = args[2], y2 = args[3];

        if (!isWithinCanvas(canvas, x1, y1) || !isWithinCanvas(canvas, x2, y2)) {
            throw new IllegalArgumentException(errPrefix + ": out of range coordination. ");
        }

        if (x1 != x2 && y1 != y2) {
            throw new IllegalArgumentException(errPrefix + ": Only horizontal or vertical lines are supported. ");
        }

        return true;
    }

    private static int getExpectedNumArgs() {
        return 4;
    }
}
