package com.tbawor.wordcountrater;

import java.util.regex.Pattern;

public class NormalizedString {

    private static Pattern SPECIAL_CHARS_PATTERN = Pattern.compile("\\W");
    private static final String EMPTY_STRING = "";

    private final String value;

    public NormalizedString(String stringToNormalize) {
        this.value = SPECIAL_CHARS_PATTERN
                .matcher(stringToNormalize.toLowerCase())
                .replaceAll(EMPTY_STRING);
    }

    public String getValue() {
        return value;
    }
}