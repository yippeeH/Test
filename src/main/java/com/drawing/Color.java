package com.drawing;

/**
 * Color for filling certain pixels on canvas
 * <p>
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

    public char getColor() {
        return c;
    }

    @Override
    public int hashCode() {
        return Character.hashCode(c);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Color) {
            return c == ((Color) o).getColor();
        }
        return false;
    }

    public String toString() {
        return "Color[color=" + c + "]";
    }
}
