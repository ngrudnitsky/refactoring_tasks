package com.epam.engx.cleancode.naming.task5;

import com.epam.engx.cleancode.naming.task5.thirdpartyjar.InvalidDirectoryException;
import com.epam.engx.cleancode.naming.task5.thirdpartyjar.InvalidFileTypeException;
import com.epam.engx.cleancode.naming.task5.thirdpartyjar.PropertyUtil;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public final class FileManager {

    private static final String[] IMAGE_TYPES = {"jpg", "png"};
    private static final String[] DOCUMENT_TYPES = {"pdf", "doc"};

    private String basePath = PropertyUtil.loadProperty("basePath");

    public File retrieveFile(String fileName) {
        validateFileType(fileName);
        return Paths.get(basePath + File.separator, fileName).toFile();
    }

    public List<String> listAllImages() {
        return listFiles(basePath, IMAGE_TYPES);
    }

    public List<String> listAllDocumentFiles() {
        return listFiles(basePath, DOCUMENT_TYPES);
    }

    private void validateFileType(String fileName) {
        if (isInvalidFileType(fileName)) {
            throw new InvalidFileTypeException("File type not Supported: " + fileName);
        }
    }

    private boolean isInvalidFileType(String fileName) {
        return isInvalidImage(fileName) && isInvalidDocument(fileName);
    }

    private boolean isInvalidImage(String fileName) {
        FileExtensionsPredicate imageExtensionsPredicate = new FileExtensionsPredicate(IMAGE_TYPES);
        return !imageExtensionsPredicate.test(fileName);
    }

    private boolean isInvalidDocument(String fileName) {
        FileExtensionsPredicate documentExtensionsPredicate = new FileExtensionsPredicate(DOCUMENT_TYPES);
        return !documentExtensionsPredicate.test(fileName);
    }

    private List<String> listFiles(String directoryPath, String[] allowedExtensions) {
        final FileExtensionsPredicate predicate = new FileExtensionsPredicate(allowedExtensions);
        return Arrays.asList(getDirectory(directoryPath).list(getFilenameFilterByPredicate(predicate)));
    }

    private FilenameFilter getFilenameFilterByPredicate(final FileExtensionsPredicate predicate) {
        return new FilenameFilter() {
            @Override
            public boolean accept(File directory, String fileName) {
                return predicate.test(fileName);
            }
        };
    }

    private File getDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        validateDirectory(directory);
        return directory;
    }

    private void validateDirectory(File directory) {
        if (isNotDirectory(directory)) {
            throw new InvalidDirectoryException("Invalid directory found: " + directory.getAbsolutePath());
        }
    }

    private boolean isNotDirectory(File directory) {
        return !directory.isDirectory();
    }

}