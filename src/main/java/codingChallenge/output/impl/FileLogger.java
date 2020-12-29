package codingChallenge.output.impl;

import java.io.*;

public class FileLogger extends AbstractLogger {
    private String dirName;
    private String fileName;

    public FileLogger(String dirName, String fileName) {
        this.dirName = dirName;
        this.fileName = fileName;
        createDirectory();
        writer = new BufferedWriter(createFileWriter());
    }

    @SuppressWarnings("unused")
    private void createDirectory() {
        File directory = new File(dirName);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

    private Writer createFileWriter() {
        try {
            return new FileWriter(
                    this.dirName + System.getProperty("file.separator") + this.fileName
            );
        } catch (IOException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

}
