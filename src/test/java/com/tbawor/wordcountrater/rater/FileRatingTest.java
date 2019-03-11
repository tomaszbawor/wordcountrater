package com.tbawor.wordcountrater.rater;

import com.tbawor.wordcountrater.indexer.IndexedFile;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FileRatingTest {

    @Test
    public void shouldProperlyStringifyFilesWithPerfect() {
        // given
        IndexedFile indexedFile = mockIndexedFileWithName("NAME");
        FileRating rating = new FileRating(indexedFile, 100.0f);

        // when
        String stringRepresentation = rating.toString();
        assertThat(stringRepresentation)
                .isEqualTo("File with name: NAME has rating: 100,00%");
    }

    @Test
    public void shouldProperlyStringifyFilesWithZeroScore() {
        // given
        IndexedFile indexedFile = mockIndexedFileWithName("some.txt");
        FileRating rating = new FileRating(indexedFile, 0.0f);

        // when
        String stringRepresentation = rating.toString();
        assertThat(stringRepresentation)
                .isEqualTo("File with name: some.txt has rating: 0,00%");
    }

    @Test
    public void shouldProperlyStringifyFilesMediumScore() {
        // given
        IndexedFile indexedFile = mockIndexedFileWithName("some.txt");
        FileRating rating = new FileRating(indexedFile, 40.0f);

        // when
        String stringRepresentation = rating.toString();
        assertThat(stringRepresentation)
                .isEqualTo("File with name: some.txt has rating: 40,00%");
    }

    private IndexedFile mockIndexedFileWithName(String name) {
        IndexedFile indexedFile = mock(IndexedFile.class);
        when(indexedFile.getFileName()).thenReturn(name);
        return indexedFile;
    }
}
