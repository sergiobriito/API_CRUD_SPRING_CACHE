package com.API_CRUD_USERS.utils;

import com.API_CRUD_USERS.annotations.ListOfStrings;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class ListOfStringsValidator implements ConstraintValidator<ListOfStrings, List<String>> {
    private int elementLength;

    @Override
    public void initialize(ListOfStrings annotation) {
        elementLength = annotation.value();
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    @Override
    public boolean isValid(List<String> list, ConstraintValidatorContext context) {
        if (list == null) {
            return false;
        }

        for (String s : list) {
            if (s == null || s.length() > elementLength || isNumeric(s)) {
                return false;
            }
        }
        return true;
    }
}
