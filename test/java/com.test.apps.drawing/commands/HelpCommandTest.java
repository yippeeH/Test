package com.test.apps.drawing.commands;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yinpinghou on 14/8/18.
 */
public class HelpCommandTest {

    @Test
    public void testHelpMessage() throws Exception {
        HelpCommand helpCommand = new HelpCommand();
        Assert.assertNotNull(helpCommand);
        helpCommand.execute(null, null);
    }
}
