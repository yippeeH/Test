package com.drawing.commands;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * Created by yinpinghou on 14/8/18.
 */
public class HelpCommand implements Command {

    private static final Logger logger = Logger.getLogger(HelpCommand.class);

    @Override
    public void execute() {
        int padSize = 16;

        StringBuilder sb = new StringBuilder("\n");
        sb.append(StringUtils.rightPad("Command", padSize));
        sb.append("Description\n");
        sb.append(StringUtils.rightPad("C w h", padSize));
        sb.append("Create a new canvas of width w and height h.\n\n");
        sb.append(StringUtils.rightPad("L x1 y1 x2 y2", padSize));
        sb.append("Create a new line from (x1,y1) to (x2,y2). Currently only horizontal or vertical lines are supported. \n" +
                StringUtils.leftPad("", padSize) + "Horizontal and vertical lines will be drawn using the 'x' character.\n\n");
        sb.append(StringUtils.rightPad("R x1 y1 x2 y2", padSize));
        sb.append("Create a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2). \n" +
                StringUtils.leftPad("", padSize) + "Horizontal and vertical lines will be drawn using the 'x' character.\n\n");
        sb.append(StringUtils.rightPad("B x y c", padSize));
        sb.append("Fill the entire area connected to (x,y) with \"colour\" c. The behaviour of this is the same\n" +
                StringUtils.leftPad("", padSize) + "as that of the \"bucket fill\" tool in paint programs.\n\n");
        sb.append(StringUtils.rightPad("Q", padSize));
        sb.append("Quit the program.\n\n");
        sb.append(StringUtils.rightPad("H", padSize));
        sb.append("Show command usage of the program.\n");
        logger.info(sb.toString());
    }
}
