package com.test.apps.drawing.commands;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yinpinghou on 14/8/18.
 */
public class QuitCommandTest {

    @Test
    public void test() throws Exception {
        QuitCommand quitCommand = new QuitCommand();
        Assert.assertNotNull(quitCommand);
//        quitCommand.execute(null, null);
    }
}
