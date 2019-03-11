package com.tbawor.wordcountrater.parser;

class NormalizedString {

    private  static final String SPECIAL_CHARS_REGEXP = "\\W";
    private static final String EMPTY_STRING = "";

    private final String value;

    NormalizedString(String stringToNormalize) {
        this.value = stringToNormalize.toLowerCase()
                .replaceAll(SPECIAL_CHARS_REGEXP, EMPTY_STRING);
    }

    String getValue() {
        return value;
    }
}
