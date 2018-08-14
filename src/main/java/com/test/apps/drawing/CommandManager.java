package com.test.apps.drawing;

import com.test.apps.drawing.commands.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yinpinghou on 13/8/18.
 */
public class CommandManager {

    private static CommandManager commandManager;
    private static Map<String, Command> map;
    private static Object monitor = new Object();

    public static CommandManager getInstance() {
        if (commandManager == null) {
            synchronized (monitor) {
                if (commandManager == null) {
                    commandManager = new CommandManager();
                    init();
                }
            }
        }
        return commandManager;
    }

    public Command getCommand(String c) {
        return map.get(c);
    }

    private static void init() {
        map = new HashMap<>();
        map.put("C", new CreateCanvasCommand());
        map.put("L", new DrawLineCommand());

        map.put("H", new HelpCommand());
        map.put("Q", new QuitCommand());
    }

    private CommandManager() {
    }


}
