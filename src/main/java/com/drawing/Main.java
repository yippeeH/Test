package com.drawing;

import com.drawing.commands.Command;
import org.apache.log4j.Logger;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by yinpinghou on 12/8/18.
 */
public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        CommandManager commandManager = CommandManager.getInstance();
        try {
            commandManager.createCommand(null, new String[]{"H"}).execute();
        } catch (Exception e) {
            logger.error("Error printing command usage. ");
        }

        Canvas canvas = new Canvas();
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Type a command: ");
                String[] input;
                while (true) {
                    input = scanner.nextLine().split(" ");
                    if (input.length >= 1 && !input[0].isEmpty()) break;
                }

                Command command;
                try {
                    command = CommandManager.getInstance().createCommand(canvas, input);
                } catch (IllegalArgumentException e) {
                    logger.error("Invalid command.", e);
                    continue;
                }

                command.execute();
                System.out.println(canvas);
            }
        } catch (IllegalStateException | NoSuchElementException e) {
            System.out.println("System.in was closed; exiting");
        } finally {
            scanner.close();
        }

    }
}
