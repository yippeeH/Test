package com.drawing;

import com.drawing.utils.Constants;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Canvas class for drawing.
 * array is the underlying 2-dimensional Color array
 * height on the canvas, equals array.length - 2;
 * width on the canvas, equals array[0].length - 2.
 * <p>
 * Created by yinpinghou on 12/8/18.
 */
public class Canvas {
    private boolean isInit;
    private Color[][] array;
    private int width;
    private int height;

    public Canvas() {
    }

    public Canvas(int width, int height) {
        init(width, height);
    }

    /**
     * Initialize the canvas. If the canvas has been initialized, clear up the canvas.
     *
     * @param width     display width of the canvas
     * @param height    display height of the canvas
     */
    public void init(int width, int height) {
        this.array = new Color[height + 2][width + 2];
        this.width = width;
        this.height = height;
        paintBorders();
        paintBlank();
        isInit = true;
    }


    private void paintBorders() {
        IntStream.range(0, array[0].length).forEach(i -> {
            array[0][i] = Constants.HORIZONTAL_BORDER_COLOR;
            array[array.length - 1][i] = Constants.HORIZONTAL_BORDER_COLOR;
        });

        IntStream.range(1, array.length - 1).forEach(j -> {
            array[j][0] = Constants.VERTICAL_BORDER_COLOR;
            array[j][array[0].length - 1] = Constants.VERTICAL_BORDER_COLOR;
        });
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

    Color[][] getArray() {
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

    public boolean isInit() {
        return isInit;
    }

    public void setInit(boolean isInit) {
        this.isInit = isInit;
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
        if (!isInit) {
            return "Uninitialized Canvas. ";
        }

        StringBuilder sb = new StringBuilder("Canvas[");
        sb.append("\n");
        for (Color[] anArray : array) {
            for (Color anAnArray : anArray) {
                sb.append(anAnArray == null ? ' ' : anAnArray.getColor());
            }
            sb.append("\n");
        }
        sb.append("]");
        return sb.toString();
    }
}
