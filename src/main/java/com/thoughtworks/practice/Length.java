package com.thoughtworks.practice;

import java.util.Arrays;
import java.util.List;

public class Length {
    private String unit;
    private int value;
    private final int []chargeArray = new int[]{1, 1760, 3, 12};
    private final List<String> list = Arrays.asList("Mile", "Yard", "Feet", "Inch");

    public Length() {
    }

    public Length(int value, String unit){
            this.value = value;
            this.unit = unit;
    }
    public int getValue() {
        return value;
    }
    public Length plus(Length length) {
        if(!is_same_units(length)){
            transfer_to_same_unit(length);
        }
        value += length.getValue();
        return this;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Length length = (Length) o;

        return is_equals_to_another_length(length);
    }

    private boolean is_equals_to_another_length(Length length){
        if(!is_same_units(length)){
            transfer_to_same_unit(length);
        }
        return is_same_values(length);
    }

    private boolean is_same_units(Length length) {
        return unit.equals(length.getUnit());
    }
    private void transfer_to_same_unit(Length length){
        if(is_smaller_unit(length)){
            transfer_bigger_unit_to_smaller_unit(length);
        }else{
            length.transfer_to_same_unit(this);
        }
    }

    private boolean is_smaller_unit(Length length) {
        return get_list_index_of_unit() < length.get_list_index_of_unit();
    }

    private void transfer_bigger_unit_to_smaller_unit(Length length) {
        for (int i = get_list_index_of_unit(); i < length.get_list_index_of_unit(); i++) {
            value *= chargeArray[i + 1];
        }
        unit = length.getUnit();
    }
    public int get_list_index_of_unit() {
        return list.indexOf(unit);
    }

    private boolean is_same_values(Length length) {
        return value == length.getValue();
    }

    public String getUnit() {
        return unit;
    }

    public void validateUnit(String unit) throws WrongUnitException {
       if(!list.contains(unit)){
           throw new WrongUnitException("this unit is not in the lib");
       }
    }
}