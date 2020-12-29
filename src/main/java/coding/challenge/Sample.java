package coding.challenge;

import coding.challenge.algorithm.IAlgorithm;
import coding.challenge.algorithm.impl.IterativeBackpacks;
import coding.challenge.datastructures.IItem;
import coding.challenge.datastructures.IItemStorage;
import coding.challenge.datastructures.ITruck;
import coding.challenge.datastructures.impl.ItemStorage;
import coding.challenge.input.IImportJson;
import coding.challenge.input.impl.ImportJson;
import coding.challenge.output.ILogger;
import coding.challenge.output.impl.FileLogger;
import coding.challenge.output.impl.Formatter;

import java.util.ArrayList;
import java.util.List;

public class Sample {
    public static void main(String[] args) {
        IImportJson i = new ImportJson();
        List<ILogger> loggers = new ArrayList<>();
        loggers.add(new FileLogger(".", "result.json"));
        IItemStorage itemStorage = new ItemStorage();

        IItem[] items = i.importJsonToItem("file:sampleData/items.json");
        for (IItem item : items) {
            item.setQuantity(item.getTargetQuantity());
            itemStorage.putItem(item);
        }
        ITruck[] trucks = i.importJsonToTruck("file:sampleData/trucks.json");


        IAlgorithm algorithm = new IterativeBackpacks(trucks, itemStorage);

        new Formatter().generateOutput(loggers, algorithm.calculate());
    }

}
