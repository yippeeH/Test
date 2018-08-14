package com.test.apps.drawing.commands;

import com.test.apps.drawing.Canvas;

/**
 * Created by yinpinghou on 12/8/18.
 */
public interface Command {

    void draw(Canvas canvas, String... args) throws Exception;

}
