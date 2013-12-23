package com.thoughtworks.practice;

import java.util.Arrays;
import java.util.List;

public class Length {
    int value;
    private String unit;
    private List list = Arrays.asList("Mile", "Yard", "Feet", "Inch");
    private int []chargeArray = new int[]{1, 1760, 3, 12};

    public Length(int value, String unit) {
        //To change body of created methods use File | Settings | File Templates.
        if(is_belong_to_this_unit_lib(unit)){
            this.unit = unit;
            this.value = value;
        }

    }
    private boolean is_belong_to_this_unit_lib(String unit) {
        try{
            if(!list.contains(unit)){
                throw new WrongUnitException("this unit is not in unit lib");
            }
        } catch (WrongUnitException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return true;
    }
    public String getUnit() {
        return unit;
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
        return get_index_of_unit() < length.get_index_of_unit();
    }
    private void transfer_bigger_unit_to_smaller_unit(Length length) {
        for(int i = get_index_of_unit();i < length.get_index_of_unit();i++){
            value *= chargeArray[i+1];
        }
        unit = length.getUnit();
    }

    private int get_index_of_unit() {
        return list.indexOf(unit);
    }

    private boolean is_same_values(Length length) {
        return value == length.getValue();
    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + unit.hashCode();
        result = 31 * result + list.hashCode();
        return result;
    }
}