package com.thoughtworks.practice;

import org.junit.Test;

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
}
