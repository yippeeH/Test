package com.drawing.utils;

import com.drawing.Canvas;
import org.junit.Assert;
import org.junit.Test;

import static com.drawing.utils.ValidateUtils.convertStringArrToIntArr;
import static com.drawing.utils.ValidateUtils.isWithinCanvas;

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

    @Test(expected = IllegalArgumentException.class)
    public void testConvertStringArrToIntArrOutOfRange1() {
        String[] strArr = new String[]{"a", "b", "c", "d", "e"};
        Assert.assertNull(convertStringArrToIntArr(strArr, 4, 5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertStringArrToIntArrOutOfRange2() {
        String[] strArr = new String[]{"a", "b", "c", "d", "e"};
        Assert.assertNull(convertStringArrToIntArr(strArr, -1, 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertStringArrToIntArrOutOfRange3() {
        String[] strArr = new String[]{"a", "b", "c", "d", "e"};
        Assert.assertNull(convertStringArrToIntArr(strArr, 2, 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertStringArrToIntArrNullSourceStringArray() {
        Assert.assertNull(convertStringArrToIntArr(null, 1, 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertStringArrToIntArrParsingException() {
        String[] strArr = new String[]{"a", "b", "c", "d", "e"};
        Assert.assertNull(convertStringArrToIntArr(strArr, 0, 4));
    }

    @Test
    public void testConvertStringArrToIntArr() {
        Assert.assertArrayEquals(new int[]{1, 2}, convertStringArrToIntArr(new String[]{"1", "2", "c", "d"}, 0, 1));
    }

}