package com.test.apps.drawing;

import com.test.apps.drawing.commands.Command;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by yinpinghou on 12/8/18.
 */
public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Canvas canvas = Canvas.NULL_CANVAS;
        CommandManager commandManager = CommandManager.getInstance();
        try {
            commandManager.getCommand("H").execute(canvas, null);
        } catch (Exception e) {
            logger.error("Error printing command usage. ");
        }

        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Type a command: ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                String[] input = scanner.nextLine().split(" ");
                Command command = CommandManager.getInstance().getCommand(input[0].trim());
                try {
                    canvas = command.execute(canvas, Arrays.copyOfRange(args, 1, args.length));
                    System.out.println(canvas);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IllegalStateException | NoSuchElementException e) {
            System.out.println("System.in was closed; exiting");
        } finally {
            scanner.close();
        }

    }




}
