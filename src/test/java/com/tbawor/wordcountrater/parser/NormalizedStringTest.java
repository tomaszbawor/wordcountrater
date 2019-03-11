package com.tbawor.wordcountrater.parser;

import com.tbawor.wordcountrater.NormalizedString;
import org.junit.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class NormalizedStringTest {

    @Test
    public void shouldRemoveCommasFromEndOfTheString() {
        // given
        final String word = "something,";

        // when
        NormalizedString normalizedString = new NormalizedString(word);

        // then
        assertThat(normalizedString.getValue()).isEqualTo("something");
    }

    @Test
    public void shouldRemoveDotsFromEndOfTheString() {
        // given
        final String word = "something.";

        // when
        NormalizedString normalizedString = new NormalizedString(word);

        // then
        assertThat(normalizedString.getValue()).isEqualTo("something");
    }

    @Test
    public void shouldRemoveExclamationMarkFromEndOfTheString() {
        // given
        final String word = "something!";

        // when
        NormalizedString normalizedString = new NormalizedString(word);

        // then
        assertThat(normalizedString.getValue()).isEqualTo("something");
    }

    @Test
    public void shouldRemoveQuestionMarkFromEndOfTheString() {
        // given
        final String word = "something?";

        // when
        NormalizedString normalizedString = new NormalizedString(word);

        // then
        assertThat(normalizedString.getValue()).isEqualTo("something");
    }

    @Test
    public void shouldReturnedLowerCaseString() {
        // given
        final String word = "SOMETHING";

        // when
        NormalizedString normalizedString = new NormalizedString(word);

        // then
        assertThat(normalizedString.getValue()).isEqualTo("something");
    }

    @Test
    public void shouldNormalizeSpecialCharsToEmptyString() {
        // given
        final String word = "#$%^&*(";

        // when
        NormalizedString normalizedString = new NormalizedString(word);

        // then
        assertThat(normalizedString.getValue()).isEqualTo("");
    }
}