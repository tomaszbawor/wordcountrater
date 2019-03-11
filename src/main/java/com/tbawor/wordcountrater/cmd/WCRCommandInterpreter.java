package com.tbawor.wordcountrater.cmd;

import com.tbawor.wordcountrater.indexer.DirectoryIndexer;
import com.tbawor.wordcountrater.indexer.IndexedFile;
import com.tbawor.wordcountrater.rater.DirectoryRater;
import com.tbawor.wordcountrater.rater.strategy.WordExistRatingStrategy;

import java.io.File;
import java.util.Set;

public class WCRCommandInterpreter {

    private final String directoryPath;
    private boolean shouldRun;
    private Set<IndexedFile> indexedFiles;

    public WCRCommandInterpreter(String[] comandLineArgs) {
        validateInputArguments(comandLineArgs);
        this.directoryPath = comandLineArgs[0];
        this.shouldRun = true;
        this.indexedFiles = indexDirectory();
    }


    public void printPrompt() {
        System.out.print("search> ");
    }

    public void executeCommand(String line) {
        if(line.equals(":quit"))  {
            shouldRun = false;
        } else {
            rateDirectory(line);
        }
    }

    private void rateDirectory(String line) {
        String[] linesToSearchFor = line.split(" ");
        DirectoryRater directoryRater = new DirectoryRater(linesToSearchFor, indexedFiles, new WordExistRatingStrategy());
        directoryRater.getTenBestRatedFiles().forEach(System.out::println);
    }

    public boolean shouldRun() {
        return shouldRun;
    }

    private void validateInputArguments(String[] comandLineArgs) {
        if (comandLineArgs.length == 0) {
            throw new IllegalArgumentException("No directory given to index.");
        }
    }

    public Set<IndexedFile> indexDirectory() {
        System.out.println("Indexing directory: " + directoryPath);
        final File directoryToIndex = new File(this.directoryPath);
        DirectoryIndexer directoryIndexer = new DirectoryIndexer(directoryToIndex);
        return directoryIndexer.indexTextFiles();
    }
}
