package com.tbawor.wordcountrater.indexer;

import com.tbawor.wordcountrater.NormalizedString;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class FileIndexer {

    private final File fileToIndex;

    FileIndexer(File textFileToIndex) {
        this.fileToIndex = textFileToIndex;
    }

    IndexedFile index() {
        try {
            String fileName = fileToIndex.getName();
            Map<String, Long> wordsCount = Files
                    .lines(fileToIndex.toPath())
                    .flatMap(line -> Arrays.stream(line.trim().split(" ")))
                    .map(NormalizedString::new)
                    .map(NormalizedString::getValue)
                    .filter(word -> !word.isEmpty())
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            return new IndexedFile(fileName, wordsCount);
        } catch (IOException exception) {
            throw new RuntimeException("Unable to parse file", exception);
        }
    }
}
