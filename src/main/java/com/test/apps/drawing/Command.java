package com.test.apps.drawing;

/**
 * Created by yinpinghou on 12/8/18.
 */
public interface Command {

    CommandType getCommandType();
    void draw(Canvas canvas);


    enum CommandType{
        CANVAS("C"),
        LINE("L"),
        RECTANGULAR("R"),
        BUCKETFILL("B"),
        QUIT("Q");

        private String type;
        private CommandType(String type) {
            this.type = type;
        }
    }
}
