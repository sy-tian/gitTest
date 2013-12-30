package com.thoughtworks.practice;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 13-12-22
 * Time: 下午5:07
 * To change this template use File | Settings | File Templates.
 */
public class LengthTest {

    @Test
    public void testEqualInYards() throws Exception {
        Length yard = new Length(2, "Yard");
        Length anotherYard = new Length(2,"Yard");
        assertThat(yard.equals(anotherYard), is(true));
    }
    @Test
    public void testDifferentInYards() throws Exception {
        Length yard = new Length(2, "Yard");
        Length anotherYard = new Length(3, "Yard");
        assertThat(yard.equals(anotherYard), is(false));

    }

    @Test
    public void testEqualInMiles() throws Exception {
        Length mile = new Length(1, "Mile");
        Length anotherMile = new Length(1,"Mile");

        assertThat(mile.equals(anotherMile), is(true));
    }


    @Test
    public void testDifferentInMiles() throws Exception {
        Length mile = new Length(2,"Mile");
        Length anotherMile = new Length(3,"Mile");
        assertThat(mile.equals(anotherMile), is(false));
    }

    @Test
    public void testEqualMileWithYards() throws Exception {
        Length mile = new Length(1, "Mile");
        Length yard = new Length(1760, "Yard");
        assertThat(mile.equals(yard), is(true));


    }

    @Test
    public void testEqualMileWithFeets() throws Exception {
        Length mile = new Length(1, "Mile");
        Length feet = new Length(5280, "Feet");
        assertThat(mile.equals(feet), is(true));

    }

    @Test
    public void testEqualYardWithFeets() throws Exception {
        Length yard = new Length(1, "Yard");
        Length feet = new Length(3, "Feet");
        assertThat(yard.equals(feet), is(true));

    }

    @Test
    public void testEqualFeetWithInchs() throws Exception {
        Length feet = new Length(1, "Feet");
        Length inch = new Length(12, "Inch");
        assertThat(feet.equals(inch), is(true));

    }



    @Test
    public void testGetRightResultAboutFeetAndFeet() throws Exception {
        Length feet = new Length(1, "Feet");
        Length inch = new Length(2, "Inch");
        assertEquals(feet.plus(inch), new Length(14, "Inch"));

    }

    @Test
    public void testGetRightResultAboutInchAndYard() throws Exception {
        Length inch = new Length(1, "Inch");
        Length yard = new Length(1, "Yard");
        assertEquals(inch.plus(yard), new Length(37, "Inch"));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowException() throws IllegalArgumentException {
        Unit.valueOf("KM");
    }

    @Test
    public void testGetRightDescAboutInch() throws Exception {
        Length length = new Length(37, "Inch");
        String actual = length.getOneDesc();
        assertThat(actual, is(equalTo("1 YARD 1 INCH ")));
        System.out.println("37 Inch:" + actual);
    }

    @Test
    public void testGetRightDescAboutFeet() throws Exception {
        Length length = new Length(5297, "Feet");
        String actual = length.getOneDesc();
        assertThat(actual, is(equalTo("1 MILE 5 YARD 2 FEET ")));
        System.out.println("5297 Inch:" + actual);
    }

    @Test
    public void testAnotherDescAboutFeet() throws Exception {
        Length length = new Length(2, "Feet");
        String excepted = "Length(2, FEET) => 24 INCH ";
        String actual = length.getAnotherDesc();
        assertThat(actual, is(equalTo(excepted)));

    }

    @Test
    public void testAnotherDescAboutYard() throws Exception {
        Length length = new Length(2, "Yard");
        String excepted = "Length(2, YARD) => 72 INCH ";
        String actual = length.getAnotherDesc();
        assertThat(actual, is(equalTo(excepted)));

    }

    @Test
    public void testChooseOneDescAboutLength() throws Exception {
        Length length = new Length(6, "Feet");
        String excepted1 = "2 YARD ";
        String excepted2 = "Length(6, FEET) => 72 INCH";
        assertThat(length.getOneDesc(), anyOf(equalTo(excepted1), equalTo(excepted2)));
    }
    @Test
    public void testChooseAnotherDescAboutLength() throws Exception {
        Length length = new Length(36, "Inch");
        String excepted1 = "1 YARD ";
        String excepted2 = "Length(36, INCH) => 36 INCH ";
        assertThat(length.getAnotherDesc(), anyOf(equalTo(excepted1), equalTo(excepted2)));
    }
}
