package com.example.demo.bathroom;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class BathroomExclStrat implements ExclusionStrategy {
    @Override
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return fieldAttributes.getName().equals("bathroom");
    }

    @Override
    public boolean shouldSkipClass(Class<?> aClass) {
        return false;
    }
}
