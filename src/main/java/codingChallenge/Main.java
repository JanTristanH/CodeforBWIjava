package codingChallenge;

import codingChallenge.impl.DynBackpack;
import codingChallenge.impl.ItemStorage;
import codingChallenge.input.IImportJson;
import codingChallenge.input.impl.importJson;
import codingChallenge.output.ILogger;
import codingChallenge.output.impl.FileLogger;
import codingChallenge.output.impl.Formatter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        IImportJson i = new importJson();
        List<ILogger> loggers = new ArrayList<>();
        loggers.add(new FileLogger(".", "result.json"));
        IItemStorage itemStorage = new ItemStorage();

        IItem[] items = i.importJsonToItem("file:data/items.json");
        for (int j = 0; j < items.length; j++) {
            items[j].setQuantity(items[j].getTargetQuantity());
            itemStorage.putItem(items[j]);
        }
        ITruck[] trucks = i.importJsonToTruck("file:data/trucks.json");


        IAlgorithm algorithm = new DynBackpack(trucks, itemStorage);

        new Formatter().generateOutput(loggers, algorithm.calculate());
    }
}
