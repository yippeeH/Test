package com.test.apps.drawing;

import com.test.apps.drawing.commands.Command;
import com.test.apps.drawing.utils.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Canvas class for drawing.
 * array is the underlying 2-dimensional Color array
 * height on the canvas, equals array.length - 2;
 * width on the canvas, equals array[0].length - 2.
 * <p>
 * Created by yinpinghou on 12/8/18.
 */
public class Canvas {

    private Color[][] array;
    private int width;
    private int height;

    public Canvas(int width, int height) {
        this.array = new Color[height + 2][width + 2];
        this.width = width;
        this.height = height;
        paintBorders();
        paintBlank();
    }

    private void paintBorders() {
        for (int i = 0; i < array[0].length; ++i) {
            array[0][i] = Constants.HORIZONTAL_BORDER_COLOR;
            array[array.length - 1][i] = Constants.HORIZONTAL_BORDER_COLOR;
        }

        for (int j = 1; j < array.length - 1; ++j) {
            array[j][0] = Constants.VERTICAL_BORDER_COLOR;
            array[j][array[0].length - 1] = Constants.VERTICAL_BORDER_COLOR;
        }
    }

    private void paintBlank() {
        for (int i = 1; i < array[0].length - 1; ++i) {
            for (int j = 1; j < array.length - 1; ++j) {
                array[j][i] = Constants.BLANK_COLOR;
            }
        }
    }

    public boolean paintPixel(int x, int y, Color c) {
        if (x > 0 && x <= width && y > 0 && y <= height) {
            array[y][x] = c;
            return true;
        }
        return false;
    }

    public Color getPixel(int x, int y) {
        if (x > 0 && x <= width && y > 0 && y <= height) {
            return array[y][x];
        }
        return null;
    }

    protected Color[][] getArray() {
        return array;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Canvas) {
            Canvas other = (Canvas) o;
            return other.height == this.height
                    && other.width == this.width
                    && Arrays.deepEquals(this.array, other.array);
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Canvas[");
        sb.append("\n");
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[i].length; ++j) {
                sb.append(array[i][j] == null ? ' ' : array[i][j].getColor());
            }
            sb.append("\n");
        }
        sb.append("]");
        return sb.toString();
    }

    public static final Canvas NULL_CANVAS = new Canvas(0, 0) {
        @Override
        public String toString() {
            return "NullCanvas";
        }
    };
}
