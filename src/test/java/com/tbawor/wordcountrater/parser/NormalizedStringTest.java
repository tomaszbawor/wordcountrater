package com.tbawor.wordcountrater.parser;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NormalizedStringTest {

    @Test
    void shouldRemoveCommasFromEndOfTheString() {
        // given
        final String word = "something,";

        // when
        NormalizedString normalizedString = new NormalizedString(word);

        // then
        assertThat(normalizedString.getValue()).isEqualTo("something");
    }

    @Test
    void shouldRemoveDotsFromEndOfTheString() {
        // given
        final String word = "something.";

        // when
        NormalizedString normalizedString = new NormalizedString(word);

        // then
        assertThat(normalizedString.getValue()).isEqualTo("something");
    }

    @Test
    void shouldRemoveExclamationMarkFromEndOfTheString() {
        // given
        final String word = "something!";

        // when
        NormalizedString normalizedString = new NormalizedString(word);

        // then
        assertThat(normalizedString.getValue()).isEqualTo("something");
    }

    @Test
    void shouldRemoveQuestionMarkFromEndOfTheString() {
        // given
        final String word = "something?";

        // when
        NormalizedString normalizedString = new NormalizedString(word);

        // then
        assertThat(normalizedString.getValue()).isEqualTo("something");
    }

    @Test
    void shouldReturnedLowerCaseString() {
        // given
        final String word = "SOMETHING";

        // when
        NormalizedString normalizedString = new NormalizedString(word);

        // then
        assertThat(normalizedString.getValue()).isEqualTo("something");
    }
}