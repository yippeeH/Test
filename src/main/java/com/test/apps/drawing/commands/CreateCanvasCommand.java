package com.test.apps.drawing.commands;

import com.test.apps.drawing.Canvas;
import com.test.apps.drawing.utils.ValidateUtils;
import org.apache.log4j.Logger;

import java.util.Arrays;

public class CreateCanvasCommand implements Command {

    private static final Logger logger = Logger.getLogger(CreateCanvasCommand.class);

    @Override
    public Canvas execute(Canvas canvas, String[] args) throws Exception {
        int[] intArgs = ValidateUtils.convertStringArrToIntArr(args, 0, args.length - 1);
        if (isValidArgs(intArgs)) {
            return new Canvas(intArgs[0], intArgs[1]);
        }
        throw new Exception("Invalid Arguments. ");
    }

    private boolean isValidArgs(int[] args) {
        int expectedNumArgs = 2;
        if (args == null || args.length != expectedNumArgs) {
            logger.error("Invalid number of arguments for command " + getClass().getSimpleName() + "; " +
                    "Expected " + expectedNumArgs + ", but got " + (args == null ? "0" : args.length) + ". ");
            return false;
        }
        try {
            if (args[0] <= 0 || args[1] <= 0) {
                throw new Exception("Invalid arguments for command " + getClass().getSimpleName());
            }
        } catch (Exception e) {
            logger.error("Invalid arguments for command " + getClass().getSimpleName() + ": " + Arrays.toString(args));
            return false;
        }
        return true;
    }
}
