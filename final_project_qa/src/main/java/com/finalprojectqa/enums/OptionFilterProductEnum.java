package com.finalprojectqa.enums;

import java.util.Arrays;
import java.util.List;

public enum OptionFilterProductEnum {
    LOW_TO_HIGH("Price (low to high)"),
    HIGH_TO_LOW("Price (high to low)"),
    A_TO_Z("Name (A to Z)"),
    Z_TO_A("Name (Z to A)");

    private String option;

    OptionFilterProductEnum(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }

    public static List<String> getFilters() {
        return Arrays.asList(LOW_TO_HIGH.getOption(), HIGH_TO_LOW.getOption(), A_TO_Z.getOption(), Z_TO_A.getOption());
    }
}
