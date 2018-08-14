package com.test.apps.drawing.utils;

import com.test.apps.drawing.Canvas;

/**
 * Created by yinpinghou on 14/8/18.
 */
public class ValidateUtils {

    public static int[] convertStringArrToIntArr(String[] strArr, int startIdx, int endIdx) {
        if (strArr == null || strArr.length <= endIdx || startIdx > endIdx) return null;
        int[] intArr = new int[endIdx - startIdx + 1];
        for (int i = startIdx; i <= endIdx; ++i) {
            intArr[i - startIdx] = Integer.parseInt(strArr[i].trim());
        }
        return intArr;
    }

    public static boolean isWithinCanvas(Canvas canvas, int x, int y) {
        return x > 0 && x <= canvas.getWidth() && y > 0 && y <= canvas.getHeight();
    }
}
