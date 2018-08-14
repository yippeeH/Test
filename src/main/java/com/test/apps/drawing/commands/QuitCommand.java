package com.test.apps.drawing.commands;

import com.test.apps.drawing.Canvas;
import org.apache.log4j.Logger;

/**
 * Created by yinpinghou on 14/8/18.
 */
public class QuitCommand implements Command {

    private static final Logger logger = Logger.getLogger(QuitCommand.class);
    @Override
    public Canvas execute(Canvas canvas, String[] args) throws Exception {
        logger.info("Exit the program. ");
        System.exit(0);
        return null;
    }
}
