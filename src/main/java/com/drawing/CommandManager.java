package com.drawing;

import com.drawing.commands.*;

import java.util.Arrays;

/**
 * Created by yinpinghou on 13/8/18.
 */
public class CommandManager {

    private static CommandManager commandManager;
    private static Object monitor = new Object();

    public static CommandManager getInstance() {
        if (commandManager == null) {
            synchronized (monitor) {
                if (commandManager == null) {
                    commandManager = new CommandManager();
                }
            }
        }
        return commandManager;
    }

    public Command createCommand(Canvas canvas, String[] args) {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("Invalid arguments for creating command: " + Arrays.toString(args));
        }
        String commandType = args[0];
        String[] commandArgs = args.length == 1 ? new String[0] : Arrays.copyOfRange(args, 1, args.length);
        switch (commandType) {
            case "C":
                return new CreateCanvasCommand(canvas, commandArgs);
            case "L":
                return new DrawLineCommand(canvas, commandArgs);
            case "R":
                return new DrawRectangleCommand(canvas, commandArgs);
            case "B":
                return new BucketFillCommand(canvas, commandArgs);
            case "H":
                return new HelpCommand();
            case "Q":
                return new QuitCommand();
            default:
                throw new IllegalArgumentException("Invalid command. Please use 'H' command to see the usage. ");
        }
    }

    private CommandManager() {
    }

}
