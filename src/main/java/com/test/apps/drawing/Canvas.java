package com.test.apps.drawing;

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
    }

    private void paintBorders() {
        for (int i = 0; i < array[0].length; ++i) {
            array[0][i] = Color.HORIZONTAL_BORDER_COLOR;
            array[array.length - 1][i] = Color.HORIZONTAL_BORDER_COLOR;
        }

        for (int i = 1; i < array.length - 1; ++i) {
            array[i][0] = Color.VERTICAL_BORDER_COLOR;
            array[i][array[0].length - 1] = Color.VERTICAL_BORDER_COLOR;
        }
    }

    public boolean paintPixel(int x, int y, Color c) {
        if (x >= 0 && x < width && y >= 0 && y < height && array[x + 1][y + 1] == null) {
            array[x + 1][y + 1] = c;
            return true;
        }
        return false;
    }

    public Color getPixel(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            return array[x + 1][y + 1];
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

    public static final Canvas INVALID_CANVAS = new Canvas(0, 0);
}
