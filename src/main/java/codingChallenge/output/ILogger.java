package codingChallenge.output;

public interface ILogger {
    void close();

    void writeLine(String line);
}

