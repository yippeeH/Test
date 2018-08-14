package com.test.apps.drawing.utils;

import com.test.apps.drawing.Canvas;
import org.junit.Assert;
import org.junit.Test;

import static com.test.apps.drawing.utils.ValidateUtils.*;

/**
 * Created by yinpinghou on 15/8/18.
 */
public class ValidateUtilsTest {
    @Test
    public void testIsWithinCanvas() {
        Canvas canvas = new Canvas(8, 6);
        Assert.assertTrue(isWithinCanvas(canvas, 5, 4));
        Assert.assertFalse(isWithinCanvas(canvas, 9, 1));
        Assert.assertFalse(isWithinCanvas(canvas, 0, 1));
    }

    @Test
    public void testConvertStringArrToIntArrNullOrEmpty() {
        Assert.assertNull(convertStringArrToIntArr(null, 1, 1));
        Assert.assertNull(convertStringArrToIntArr(new String[]{}, 1, 1));
    }

    @Test
    public void testConvertStringArrToIntArrOutOfRange() {
        String[] strArr = new String[]{"a", "b", "c", "d", "e"};
        Assert.assertNull(convertStringArrToIntArr(strArr, 4, 5));
        Assert.assertNull(convertStringArrToIntArr(strArr, 2, 1));
    }

    @Test
    public void testConvertStringArrToIntArr() {
        String[] input = new String[]{"a", "b", "c", "d"};
        Assert.assertNull(convertStringArrToIntArr(null, 1, 1));
        Assert.assertNull(convertStringArrToIntArr(new String[]{}, 1, 1));
    }

}