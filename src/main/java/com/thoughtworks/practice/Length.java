package com.thoughtworks.practice;

public class Length {
    private int value;
    private Unit unit;

    public Length(int value, String unit) {
            this.unit = Unit.valueOf(unit);
            this.value = value;

    }
    public static Length yard(int value){
        return new Length(value, "Yard");
    }
    public static Length mile(int value){
        return new Length(value, "Mile");
    }
    public static Length feet(int value){
        return new Length(value, "Feet");
    }
    public static Length inch(int value){
        return new Length(value, "Inch");
    }

    public Unit getUnit() {
        return unit;
    }
    public String getUnitStr(){
        return unit.toString();
    }

    public int getValue() {
        return value;
    }
    public Length plus(Length addend) {
        if(!isSameUnits(addend.getUnit())){
            transferToSameUnit(addend);
        }
       return new Length(value + addend.getValue(), addend.getUnitStr());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Length length = (Length) o;
        return isEqualsBetweenLength(length);
    }

    private boolean isEqualsBetweenLength(Length length){
        if(!isSameUnits(length.getUnit())){
            transferToSameUnit(length);
        }
        return value == length.getValue();
    }


    private void transferToSameUnit(Length length){
        if(isSmallerUnit(length.getUnit())){
            transferSmallerUnit(length.getUnit());
        }else{
            length.transferSmallerUnit(unit);
        }
    }

    private boolean isSameUnits(Unit anotherUnit) {
        return unit.compareTo(anotherUnit) == 0;
    }

    private boolean isSmallerUnit(Unit anotherUnit) {
        return unit.compareTo(anotherUnit) < 0;
    }

    private void transferSmallerUnit(Unit anotherUnit) {
           while(isSmallerUnit(anotherUnit)){
               value *= unit.getRate();
               unit = unit.getNext();
        }
    }

    public String getOneDesc() {
        if (isMeaningFullToValueAndLastUnit()) {
            return getDescAfterTransferUnit();
        }else
            return getDescBy(value);
    }

    private String getDescBy(int value) {
        return value + " " + getUnitStr().toUpperCase()+ " ";
    }

    private String getDescAfterTransferUnit() {
        Unit lastUnit = unit.getLast();
        int multiplier = lastUnit.getMultiplier(value);
        if (multiplier != 0)
                return getLastUnitDesc(lastUnit, multiplier) + getRemainderDesc(lastUnit);
        else
                return getDescBy(value);
    }

    private String getLastUnitDesc(Unit unit, int multiply) {
        return new Length(multiply, unit.toString()).getOneDesc();
    }

    private String getRemainderDesc(Unit unit) {
        int remainder = unit.getRemainder(value);
        if(remainder != 0) return getDescBy(remainder);
        else return "";
    }


    private boolean isMeaningFullToValueAndLastUnit() {
        return value != 0 && unit.getLast() != null;
    }

    public String getAnotherDesc() {
        String str = "Length("+value+", "+ getUnitStr().toUpperCase() + ") => ";
        transferSmallerUnit(Unit.Inch);
        return str + getDescBy(value);
    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
    }

}