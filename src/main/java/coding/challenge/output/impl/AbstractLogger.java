package coding.challenge.output.impl;

import coding.challenge.output.ILogger;

import java.io.BufferedWriter;
import java.io.IOException;

public abstract class AbstractLogger implements ILogger {
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
