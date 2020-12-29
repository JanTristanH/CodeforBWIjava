package coding.challenge.output;

import coding.challenge.datastructures.ITruck;

import java.util.List;

public interface IFormatter {
    void generateOutput(List<ILogger> loggers, ITruck[] trucks);
}
