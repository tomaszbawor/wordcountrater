package com.tbawor.wordcountrater.indexer;

import org.junit.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DirectoryIndexerTest {

    @Test
    public void shouldThrowExceptionWhenNullFileProvided() {
        try {
            // given when
            new DirectoryIndexer(null);
            fail("Should throw exception");
        } catch (Exception ex) {
            // then
            assertThat(ex).isInstanceOf(IllegalArgumentException.class);
            assertThat(ex.getMessage()).isEqualTo("Directory provided is null");
        }
    }

    @Test
    public void shouldThrowExceptionWhenProvidedFileIsNotDirectory() {
        // given
        File file = mock(File.class);
        when(file.isDirectory()).thenReturn(Boolean.FALSE);

        try {
            // when
            new DirectoryIndexer(file);
            fail("Should throw exception");
        } catch (Exception ex) {
            // then
            assertThat(ex).isInstanceOf(IllegalArgumentException.class);
            assertThat(ex.getMessage()).isEqualTo("Provided file is no valid directory");
        }
    }

    @Test
    public void shouldRecognizeFileWithTxtExtension() {
        // given
        File file = mock(File.class);
        when(file.getName()).thenReturn("some.txt");

        // when then
        assertThat(DirectoryIndexer.isTextFile(file)).isTrue();
    }

    @Test
    public void shouldFilterFileWithNotTxtExtension() {
        // given
        File file = mock(File.class);
        when(file.getName()).thenReturn("some.exe");

        // when then
        assertThat(DirectoryIndexer.isTextFile(file)).isFalse();
    }

    @Test
    public void shouldFilterFileWithoutExtension() {
        // given
        File file = mock(File.class);
        when(file.getName()).thenReturn("some");

        // when then
        assertThat(DirectoryIndexer.isTextFile(file)).isFalse();
    }

}