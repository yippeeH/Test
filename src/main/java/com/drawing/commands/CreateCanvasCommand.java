package com.drawing.commands;

import com.drawing.Canvas;
import com.drawing.utils.ValidateUtils;

public class CreateCanvasCommand implements Command {

    private final Canvas canvas;
    private final int width;
    private final int height;

    public CreateCanvasCommand(Canvas canvas, String[] args) {
        int[] intArgs = ValidateUtils.convertStringArrToIntArr(args, 0, args.length - 1);
        validateArgs(canvas, intArgs);
        this.canvas = canvas;
        this.width = intArgs[0];
        this.height = intArgs[1];
    }

    @Override
    public void execute() {
        canvas.init(width, height);
    }

    private boolean validateArgs(Canvas canvas, int[] args) {
        if (canvas == null) {
            throw new IllegalArgumentException("Canvas is null. Please pass around a place holder of canvas. ");
        }
        if (args == null || args.length != getExpectedNumArgs()) {
            throw new IllegalArgumentException("Invalid number of arguments for command " + getClass().getSimpleName() + "; " +
                    "Expected " + getExpectedNumArgs() + ", but got " + (args == null ? "0" : args.length) + ". ");
        }
        if (args[0] <= 0 || args[1] <= 0) {
            throw new IllegalArgumentException("Invalid arguments for command " + getClass().getSimpleName());
        }
        return true;
    }

    private static int getExpectedNumArgs() {
        return 2;
    }
}
