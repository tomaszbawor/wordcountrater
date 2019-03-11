package com.tbawor.wordcountrater.indexer;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class DirectoryIndexer {

    private final File directory;

    public DirectoryIndexer(File directory) {
        validateDirectory(directory);
        this.directory = directory;
    }

    private void validateDirectory(File directory) {
        if (directory == null) {
            throw new IllegalArgumentException("Directory provided is null");
        } else if (!directory.isDirectory()) {
            throw new IllegalArgumentException("Provided file is no valid directory");
        }
    }

    public Set<IndexedFile> indexTextFiles() {
        return Arrays
                .stream(Objects.requireNonNull(directory.listFiles()))
                .filter(DirectoryIndexer::isTextFile)
                .map(FileIndexer::new)
                .map(FileIndexer::index)
                .collect(Collectors.toSet());
    }

     static boolean isTextFile(File file) {
        final String fileName = file.getName();
        String fileExtension = fileName.substring(fileName.lastIndexOf('.') + 1);
        return fileExtension.toLowerCase().equals("txt");
    }

}
