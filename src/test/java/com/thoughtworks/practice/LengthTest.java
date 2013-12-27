package com.thoughtworks.practice;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 13-12-22
 * Time: 下午5:07
 * To change this template use File | Settings | File Templates.
 */
public class LengthTest {
    private Length length = new Length();

    @Test
    public void should_be_equal_with_same_Yards() throws Exception {
        Length yard = new Length(2, "Yard");
        Length anotherYard = new Length(2,"Yard");
        assertThat(yard.equals(anotherYard), is(true));
    }
    @Test
    public void should_be_not_equal_with_different_Yards() throws Exception {
        Length yard = new Length(2, "Yard");
        Length yard1 = new Length(3, "Yard");
        assertThat(yard.equals(yard1), is(false));

    }

    @Test
    public void should_be_equal_with_same_miles() throws Exception {
        Length mile = new Length(1, "Mile");
        Length anotherMile = new Length(1,"Mile");

        assertThat(mile.equals(anotherMile), is(true));
    }


    @Test
    public void should_be_not_equal_with_different_miles() throws Exception {
        Length mile = new Length(2,"Mile");
        Length anotherMile = new Length(3,"Mile");
        assertThat(mile.equals(anotherMile), is(false));
    }

    @Test
    public void should_be_equal_with_mile_and_yards() throws Exception {
        Length mile = new Length(1, "Mile");
        Length yard = new Length(1760, "Yard");
        assertThat(mile.equals(yard), is(true));


    }

    @Test
    public void should_be_equal_with_mile_and_feets() throws Exception {
        Length mile = new Length(1, "Mile");
        Length feet = new Length(5280, "Feet");
        assertThat(mile.equals(feet), is(true));

    }

    @Test
    public void should_be_equal_with_yard_and_Feets() throws Exception {
        Length yard = new Length(1, "Yard");
        Length feet = new Length(3, "Feet");
        assertThat(yard.equals(feet), is(true));

    }

    @Test
    public void should_be_equal_with_feet_and_Inchs() throws Exception {
        Length feet = new Length(1, "Feet");
        Length inch = new Length(12, "Inch");
        assertThat(feet.equals(inch), is(true));

    }

    @Test(expected = WrongUnitException.class)
    public void should_throw_expected_exception() throws WrongUnitException {
         length.validateUnit("KM");
    }

    @Test
    public void should_get_right_plus_result() throws Exception {
        Length feet = new Length(1, "Feet");
        Length inch = new Length(2, "Inch");
        assertEquals(feet.plus(inch), new Length(14, "Inch"));

    }

    @Test
    public void should_get_right_feet() throws Exception {
        Length inch = new Length(1, "Inch");
        Length yard = new Length(1, "Yard");
        assertEquals(inch.plus(yard), new Length(37, "Inch"));

    }

}
