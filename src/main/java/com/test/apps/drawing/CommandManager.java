package com.test.apps.drawing;

import com.test.apps.drawing.commands.Command;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yinpinghou on 13/8/18.
 */
public class CommandManager {

    private static CommandManager commandManager;
    private static Map<String, Command> map;
    public static CommandManager getInstance() {
        if (commandManager == null) {
            synchronized (commandManager) {
                if (commandManager == null) {
                    commandManager = new CommandManager();
                    init();
                }
            }
        }
        return commandManager;
    }

    private static void init() {
        map = new HashMap<>();

    }

    private CommandManager() {}



}
