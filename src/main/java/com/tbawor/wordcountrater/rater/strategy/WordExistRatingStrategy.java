package com.tbawor.wordcountrater.rater.strategy;

import com.tbawor.wordcountrater.NormalizedString;
import com.tbawor.wordcountrater.indexer.IndexedFile;
import com.tbawor.wordcountrater.rater.FileRating;

public class WordExistRatingStrategy implements RatingStrategy {

    @Override
    public FileRating rateFile(NormalizedString[] searchedStrings, IndexedFile file) {
        int matchedWords = 0;
        for (NormalizedString normalizedWord : searchedStrings) {
            if (file.getWordCount(normalizedWord.getValue()) > 0) {
                matchedWords++;
            }
        }

        float matchedPercentage = (matchedWords * 100f) / searchedStrings.length;
        return new FileRating(file, matchedPercentage);
    }
}
