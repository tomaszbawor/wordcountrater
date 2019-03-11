package com.tbawor.wordcountrater.rater;

import com.tbawor.wordcountrater.indexer.IndexedFile;

public class FileRating {

    private final IndexedFile indexedFile;
    private final float percentageMatch;

    public FileRating(IndexedFile indexedFile, float percentageMatch) {
        this.indexedFile = indexedFile;
        this.percentageMatch = percentageMatch;
    }

    public float getPercentageMatch() {
        return percentageMatch;
    }

    @Override
    public String toString() {
        return String.format("File with name: %s has rating: %.2f%%", indexedFile.getFileName(), percentageMatch);
    }
}
