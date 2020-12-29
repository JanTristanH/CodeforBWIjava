package codingChallenge.output;

import codingChallenge.ITruck;

import java.util.List;

public interface IFormatter {
    void generateOutput(List<ILogger> loggers, ITruck[] trucks);
}
