package com.thoughtworks.practice;


public class Length {
    private int value;
    private Unit unit;
    public Length(int value, String unit) {
        //To change body of created methods use File | Settings | File Templates.
            this.unit = Unit.valueOf(unit);
            this.value = value;

    }
    public Unit getUnit() {
        return unit;
    }

    public int getValue() {
        return value;
    }
    public Length plus(Length length) {
        if(!isSameUnits(length)){
            transferToSameUnit(length);
        }
        value += length.getValue();
        return this;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Length length = (Length) o;

        return isEqualsToAnotherLength(length);
    }

    private boolean isEqualsToAnotherLength(Length length){
        if(!isSameUnits(length)){
            transferToSameUnit(length);
        }
        return isSameValues(length);
    }

    private boolean isSameUnits(Length length) {
        return unit.compareTo(length.getUnit()) == 0;
    }
    private void transferToSameUnit(Length length){
        if(isSmallerUnit(length)){
            transferBiggerUnitToSmallerUnit(length.getUnit());
        }else{
            length.transferToSameUnit(this);
        }
    }

    private boolean isSmallerUnit(Length length) {
        return unit.compareTo(length.getUnit()) < 0;
    }

    private void transferBiggerUnitToSmallerUnit(Unit anotherUnit) {
           while(unit.compareTo(anotherUnit) < 0){
               value *= unit.getExchangeRate();
               unit = unit.getNextUnit();
        }
    }

    private boolean isSameValues(Length length) {
        return value == length.getValue();
    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
    }

    public String getOneDesc() {
        if (isMeaningFullToValueAndLastUnit()) {
            return getDescAfterTransferUnit();
        }else
            return getLengthDescByValue(value);
    }

    private String getLengthDescByValue(int value) {
        return value + " " + unit.toString().toUpperCase()+ " ";
    }

    private String getDescAfterTransferUnit() {
        Unit unit1 = unit.getLastUnit();
        int multiply = getMultiplyForBiggerUnit(unit1);
        if (multiply != 0)
                return getBiggerUnitDesc(unit1, multiply) + getRemainderDesc(unit1);
        else
                return getLengthDescByValue(value);
    }

    private String getBiggerUnitDesc(Unit unit1, int multiply) {
        return new Length(multiply, unit1.toString()).getOneDesc();
    }

    private String getRemainderDesc(Unit unit) {
        int remainder = getRemainderForBiggerUnit(unit);
        if(remainder != 0) return getLengthDescByValue(remainder);
        else return "";
    }

    private int getRemainderForBiggerUnit(Unit unit1) {
        return value % unit1.getExchangeRate();
    }

    private int getMultiplyForBiggerUnit(Unit unit1) {
        return value / unit1.getExchangeRate();
    }

    private boolean isMeaningFullToValueAndLastUnit() {
        return value != 0 && unit.getLastUnit() != null;
    }

    public String getAnotherDesc() {
        String str = "Length("+value+", "+ unit.toString().toUpperCase() + ") => ";
        transferBiggerUnitToSmallerUnit(Unit.Inch);
        return str + getLengthDescByValue(value);
    }

}