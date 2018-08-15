package com.drawing;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yinpinghou on 15/8/18.
 */
public class CommandManagerTest {

    private CommandManager commandManager;

    @Test
    public void test() {
        commandManager = CommandManager.getInstance();
        Assert.assertNotNull(commandManager);
    }

}
