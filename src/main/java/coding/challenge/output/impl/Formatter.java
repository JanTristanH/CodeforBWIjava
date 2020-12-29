package coding.challenge.output.impl;

import coding.challenge.datastructures.ITruck;
import coding.challenge.output.IFormatter;
import coding.challenge.output.ILogger;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class Formatter implements IFormatter {
    private final BinaryOperator<Integer> summe =
            (subtotal, element) -> subtotal + element;

    @Override
    public void generateOutput(List<ILogger> loggers, ITruck[] trucks) {
        ObjectMapper mapper = new ObjectMapper();
        StringBuilder builder = new StringBuilder();
        try {
            String json = mapper.writeValueAsString(trucks);
            builder.append("{ \"totalUtility\":");
            builder.append(Arrays.stream(trucks)
                    .map(t -> t.getTotalUtility())
                    .reduce(0, summe));
            builder.append(",\"trucks\":");
            builder.append(json);
            builder.append("}");

            String res = builder.toString();
            loggers.forEach(logger -> {
                logger.writeLine(res);
                logger.close();
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }
}
