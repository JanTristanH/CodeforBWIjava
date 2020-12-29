package coding.challenge.output.impl;

import java.io.*;

public class FileLogger extends AbstractLogger {
    private final String dirName;
    private final String fileName;

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
