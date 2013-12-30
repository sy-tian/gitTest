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
    private int exchangeRate;

    Unit(int exchangeRate) {
        //To change body of created methods use File | Settings | File Templates.
        this.exchangeRate = exchangeRate;
    }

    public Unit getNextUnit() {
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

    public int getExchangeRate() {
        return exchangeRate;
    }

    public Unit getLastUnit() {
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
}
