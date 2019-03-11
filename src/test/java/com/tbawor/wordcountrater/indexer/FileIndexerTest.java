package com.tbawor.wordcountrater.indexer;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

public class FileIndexerTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test
    public void shouldReturnProperNameOfIndexedFile() throws IOException {
        // given
        final String fileName = "example.txt";
        File file = tempFolder.newFile(fileName);

        // when
        IndexedFile indexedFile = new FileIndexer(file).index();

        // then
        assertThat(indexedFile.getFileName()).isEqualTo(fileName);
    }

    @Test
    public void shouldIndexWordsInSimpleFile() throws IOException {
        // given
        final String fileName = "oneWordFile.txt";
        File file = tempFolder.newFile(fileName);
        try (PrintStream out = new PrintStream(new FileOutputStream(file))) {
            out.print("one two three");
        }

        // when
        IndexedFile indexedFile = new FileIndexer(file).index();

        // then
        assertThat(indexedFile.getWordCount("one")).isEqualTo(1L);
        assertThat(indexedFile.getWordCount("two")).isEqualTo(1L);
        assertThat(indexedFile.getWordCount("three")).isEqualTo(1L);

    }


}