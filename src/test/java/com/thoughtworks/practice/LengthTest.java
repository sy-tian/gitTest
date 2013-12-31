package com.thoughtworks.practice;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 13-12-22
 * Time: 下午5:07
 * To change this template use File | Settings | File Templates.
 */
public class LengthTest {

    @Test
    public void testEquality() throws Exception {
        assertTrue(Length.yard(2).equals(Length.yard(2)));
        assertFalse(Length.yard(2).equals(Length.yard(3)));
        assertFalse(Length.yard(3).equals(Length.mile(3)));
        assertTrue(Length.feet(1).equals(Length.inch(12)));
        assertFalse(Length.feet(1).equals(Length.inch(4)));
    }

    @Test
    public void testSimpleAddition() throws Exception {
        Length one = Length.feet(1);
        Length two = Length.feet(2);
        assertEquals(Length.feet(3), one.plus(two));
    }

    @Test
    public void testMixedAddition() throws Exception {
        Length feet = Length.feet(1);
        Length inch = Length.inch(2);
        Length yard = Length.yard(1);
        assertEquals(Length.inch(14), feet.plus(inch) );
        assertEquals(Length.feet(4), feet.plus(yard) );

    }

    @Test(expected = IllegalArgumentException.class)
    public void testException() throws IllegalArgumentException {
        Unit.valueOf("KM");
    }

    @Test
    public void testDescription() throws Exception {
        Length length = Length.feet(5297);
        String actual = length.getOneDesc();
        assertEquals(actual, "1 MILE 5 YARD 2 FEET ");
        System.out.println("5297 Feet:" + actual);
        actual = length.getAnotherDesc();
        String excepted = "Length(5297, FEET) => 63564 INCH ";
        assertEquals(excepted, actual);
        System.out.println("5297 Feet:" + actual);
    }

    @Test
    public void testAnyDescription() throws Exception {
        Length length = Length.feet(6);
        String excepted1 = "2 YARD ";
        String excepted2 = "Length(6, FEET) => 72 INCH ";
        assertThat(length.getOneDesc(), anyOf(equalTo(excepted1), equalTo(excepted2)));
        assertThat(length.getAnotherDesc(), anyOf(equalTo(excepted1), equalTo(excepted2)));
    }
}
