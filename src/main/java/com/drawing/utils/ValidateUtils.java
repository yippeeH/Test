package com.drawing.utils;

import com.drawing.Canvas;

/**
 * Created by yinpinghou on 14/8/18.
 */
public class ValidateUtils {

    /**
     * Converts the specified String array to integer array. The starting index of the range (<tt>from</tt>) must lie between zero
     * * and <tt>original.length</tt>, inclusive
     *
     * @param original the source String array
     * @param from     starting index from which index the conversion is applied on.
     * @param to       ending index (Inclusive) to which index the conversion is applied on.
     * @return converted integer array
     */
    public static int[] convertStringArrToIntArr(String[] original, int from, int to) throws IllegalArgumentException {
        if (original == null || to >= original.length || from < 0 || from > to) {
            throw new IllegalArgumentException("convertStringArrToIntArr(" + original + ", " + from + ", " + to + ")");
        }
        int[] converted = new int[to - from + 1];
        for (int i = from; i <= to; ++i) {
            converted[i - from] = Integer.parseInt(original[i].trim());
        }
        return converted;
    }

    public static boolean isWithinCanvas(Canvas canvas, int x, int y) {
        return x > 0 && x <= canvas.getWidth() && y > 0 && y <= canvas.getHeight();
    }
}
