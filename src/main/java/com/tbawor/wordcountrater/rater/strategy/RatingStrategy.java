package com.tbawor.wordcountrater.rater.strategy;

import com.tbawor.wordcountrater.NormalizedString;
import com.tbawor.wordcountrater.indexer.IndexedFile;
import com.tbawor.wordcountrater.rater.FileRating;

public interface RatingStrategy {
    FileRating rateFile(NormalizedString[] searchedStrings, IndexedFile file);
}
