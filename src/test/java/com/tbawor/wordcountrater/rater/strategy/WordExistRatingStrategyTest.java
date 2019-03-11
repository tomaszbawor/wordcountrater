package com.tbawor.wordcountrater.rater.strategy;

import com.tbawor.wordcountrater.NormalizedString;
import com.tbawor.wordcountrater.indexer.IndexedFile;
import com.tbawor.wordcountrater.rater.FileRating;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WordExistRatingStrategyTest {

    @Mock
    private IndexedFile indexedFile;
    private WordExistRatingStrategy ratingStrategy = new WordExistRatingStrategy();

    @Test
    public void shouldReturnFullRatingWhenSingleWordMatches() {
        // given
        NormalizedString[] strings = {new NormalizedString("aloha")};
        when(indexedFile.getWordCount(eq("aloha"))).thenReturn(1L);

        // when
        FileRating fileRating = ratingStrategy.rateFile(strings, indexedFile);

        // then
        assertThat(fileRating.getPercentageMatch()).isEqualTo(100);
    }

    @Test
    public void shouldReturnZeroRatingWhenNoWoldMatches() {
        // given
        NormalizedString[] strings = {new NormalizedString("aloha")};
        when(indexedFile.getWordCount(eq("aloha"))).thenReturn(0L);

        // when
        FileRating fileRating = ratingStrategy.rateFile(strings, indexedFile);

        // then
        assertThat(fileRating.getPercentageMatch()).isEqualTo(0);
    }

    @Test
    public void shouldReturnNotFullAndNonEmptyRatingWhenSomeOfWordMatches() {
        // given
        NormalizedString[] strings = {
                new NormalizedString("aloha"),
                new NormalizedString("friends")
        };
        when(indexedFile.getWordCount(eq("aloha"))).thenReturn(1L);
        when(indexedFile.getWordCount(eq("friends"))).thenReturn(0L);

        // when
        FileRating fileRating = ratingStrategy.rateFile(strings, indexedFile);

        // then
        assertThat(fileRating.getPercentageMatch()).isBetween(0.0f, 100.0f);
    }

}