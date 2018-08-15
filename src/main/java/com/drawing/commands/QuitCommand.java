package com.drawing.commands;

import org.apache.log4j.Logger;

/**
 * Created by yinpinghou on 14/8/18.
 */
public class QuitCommand implements Command {

    private static final Logger logger = Logger.getLogger(QuitCommand.class);

    @Override
    public void execute() {
        logger.info("Exit the program. ");
        System.exit(0);
    }
}
