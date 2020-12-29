package codingChallenge.output.impl;

import codingChallenge.output.ILogger;

import java.io.BufferedWriter;
import java.io.IOException;

public class AbstractLogger implements ILogger {
    protected BufferedWriter writer;

    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    public void writeLine(String line) {
        try {
            this.writer.write(line);
            this.writer.newLine();
            this.writer.flush();
        } catch (IOException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

}
