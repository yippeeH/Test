package com.test.apps.drawing;

/**
 * Created by yinpinghou on 13/8/18.
 */
public class Color {
    private char c;

    public Color(char c) {
        this.c = c;
    }

    public Color(Color o) {
        this.c = o.getColor();
    }

    public char getColor() { return c; }

    public String toString() {
        return "Color[color=" + c + "]";
    }

    public static final Color HORIZONTAL_BORDER_COLOR = new Color('-');
    public static final Color VERTICAL_BORDER_COLOR = new Color('|');

}
