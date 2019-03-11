package com.tbawor.wordcountrater.rater;

import com.tbawor.wordcountrater.NormalizedString;
import com.tbawor.wordcountrater.indexer.IndexedFile;
import com.tbawor.wordcountrater.rater.strategy.RatingStrategy;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DirectoryRater {

    private static final int MAX_RESULTS = 10;
    private final List<FileRating> tenBestRatedFiles;

    public DirectoryRater(
            String[] searchedWords,
            Set<IndexedFile> filesToRate,
            RatingStrategy ratingStrategy
    ) {
        NormalizedString[] normalizedStrings = normalizeWords(searchedWords);

        tenBestRatedFiles = filesToRate.stream()
                .map(indexedFile -> ratingStrategy.rateFile(normalizedStrings, indexedFile))
                .sorted(Comparator.comparingDouble(FileRating::getPercentageMatch).reversed())
                .limit(MAX_RESULTS)
                .collect(Collectors.toList());
    }

    public List<FileRating> getTenBestRatedFiles() {
        return tenBestRatedFiles;
    }

    private NormalizedString[] normalizeWords(String[] searchedWords) {
        return Stream.of(searchedWords)
                .map(NormalizedString::new)
                .toArray(NormalizedString[]::new);
    }
}
