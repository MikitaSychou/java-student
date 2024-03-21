package com.innowise.utils.fileSystem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import static com.innowise.utils.constants.Constants.DATA_DIRECTORY;
import static com.innowise.utils.constants.Constants.TARGET_DIRECTORY;

public class FileSystemUtils {

    private FileSystemUtils() {

    }

    public static String[] printFileNamesOfDepartments() {
        File dir = new File(TARGET_DIRECTORY);

        FilenameFilter filenameFilter = (d, s) -> s.toLowerCase().startsWith("db_");

        return dir.list(filenameFilter);
    }

        public static void flushTheFile(String fileName) throws IOException {
            final String filePath = DATA_DIRECTORY + fileName;
            new FileOutputStream(filePath).close();
    }
}

