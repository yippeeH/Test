package com.test.apps.drawing.commands;

import com.test.apps.drawing.Canvas;
import org.apache.log4j.Logger;

public class CreateCanvasCommand implements Command {

    private static final Logger logger = Logger.getLogger(CreateCanvasCommand.class);

    public CreateCanvasCommand() {}

    @Override
    public void draw(Canvas canvas, String... args) throws Exception {


    }

    private boolean isValidArgs(String... args) {
        int expectedNumArgs = 2;
        if (args.length != expectedNumArgs) {
            logger.error("Invalid number of arguments for command " + getClass().getSimpleName() + "; " +
                    "Expected " + expectedNumArgs + ", but got " + args.length + ". ");
            return false;
        }
        try {
            int w = Integer.valueOf(args[0]);
            int h = Integer.valueOf(args[1]);
            if (w <= 0 || h <= 0) {
                throw new Exception("Invalid arguments for command " + getClass().getSimpleName());
            }
        } catch (Exception e) {
            logger.error("Invalid arguments for command " + getClass().getSimpleName() + ": [" + args[0] + "," + args[1] + "].");
            return false;
        }
        return true;
    }
}
