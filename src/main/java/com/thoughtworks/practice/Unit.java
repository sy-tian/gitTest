package com.thoughtworks.practice;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 13-12-29
 * Time: 下午2:54
 * To change this template use File | Settings | File Templates.
 */
public enum Unit {
    Mile(1760), Yard(3), Feet(12), Inch(1);
    private int rate;

    Unit(int rate) {
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }

    public Unit getNext() {
        switch (this) {
            case Mile:
                return Yard;
            case Yard:
                return Feet;
            case Feet:
                return Inch;
            default:
                return null;
        }
    }
    public Unit getLast() {
        switch (this) {
            case Inch:
                return Feet;
            case Feet:
                return Yard;
            case Yard:
                return Mile;
            default:
                return null;
        }
    }
    public int getMultiplier(int value){
        return value / rate;
    }
    public int getRemainder(int value){
        return value % rate;
    }
}
