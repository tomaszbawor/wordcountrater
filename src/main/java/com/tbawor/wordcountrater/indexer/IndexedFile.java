package com.tbawor.wordcountrater.indexer;

import java.util.Map;

public class IndexedFile {

    private static final long DEFAULT_WORD_COUNT = 0L;

    private final String fileName;
    private final Map<String, Long> wordCounts;

    IndexedFile(String fileName, Map<String, Long> wordCounts) {
        this.fileName = fileName;
        this.wordCounts = wordCounts;
    }

    public Long getWordCount(String word) {
        final String normalizedWord = word.toLowerCase();
        return wordCounts.getOrDefault(normalizedWord, DEFAULT_WORD_COUNT);
    }

    public String getFileName() {
        return this.fileName;
    }

}
