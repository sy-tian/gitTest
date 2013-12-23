package com.thoughtworks.practice;

public class Length {
    int value;
    private String unit;


    public Length(int value, String unit) {
        //To change body of created methods use File | Settings | File Templates.
        this.unit = unit;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Length length = (Length) o;

        if (value != length.value) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value;
    }
}