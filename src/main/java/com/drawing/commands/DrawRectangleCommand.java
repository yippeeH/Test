package com.drawing.commands;

import com.drawing.Canvas;
import com.drawing.utils.ValidateUtils;

import java.util.Arrays;

/**
 * Created by yinpinghou on 15/8/18.
 */
public class DrawRectangleCommand implements Command {

    private final Canvas canvas;
    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;

    public DrawRectangleCommand(Canvas canvas, String[] args) {
        int[] intArgs = ValidateUtils.convertStringArrToIntArr(args, 0, args.length - 1);
        validateArgs(canvas, intArgs);
        this.canvas = canvas;
        this.x1 = intArgs[0];
        this.y1 = intArgs[1];
        this.x2 = intArgs[2];
        this.y2 = intArgs[3];
    }

    @Override
    public void execute() {
        drawLine(x1, y1, x2, y1);
        drawLine(x2, y1, x2, y2);
        drawLine(x2, y2, x1, y2);
        drawLine(x1, y2, x1, y1);
    }

    private boolean validateArgs(Canvas canvas, int[] args) {
        if (canvas == null || !canvas.isInit()) {
            throw new IllegalArgumentException("Canvas is not initialized. Please create a canvas first. ");
        }
        String errPrefix = "Invalid arguments for command " + getClass().getSimpleName() + ": " + Arrays.toString(args);
        if (args == null || args.length != getExpectedNumArgs()) {
            throw new IllegalArgumentException(errPrefix + "; " +
                    "Expected " + getExpectedNumArgs() + ", but got " + (args == null ? "0" : args.length) + ". ");
        }
        int x1 = args[0], y1 = args[1], x2 = args[2], y2 = args[3];
        if (!ValidateUtils.isWithinCanvas(canvas, x1, y1) || !ValidateUtils.isWithinCanvas(canvas, x2, y2)) {
            throw new IllegalArgumentException(errPrefix + ": out of range coordination. ");
        }
        if (x1 == x2 || y1 == y2) {
            throw new IllegalArgumentException(errPrefix + ": coordinations can not be in the same row/column. ");
        }

        return true;
    }

    private void drawLine(int x1, int y1, int x2, int y2) {
        new DrawLineCommand(canvas, Arrays.toString(new int[]{x1, y1, x2, y2}).split("[\\[\\]]")[1].split(", ")).execute();
    }

    private static int getExpectedNumArgs() {
        return 4;
    }
}
