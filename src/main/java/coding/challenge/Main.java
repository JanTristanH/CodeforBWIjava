package coding.challenge;

import coding.challenge.impl.DynBackpack;
import coding.challenge.impl.ItemStorage;
import coding.challenge.input.IImportJson;
import coding.challenge.input.impl.importJson;
import coding.challenge.output.ILogger;
import coding.challenge.output.impl.FileLogger;
import coding.challenge.output.impl.Formatter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        IImportJson i = new importJson();
        List<ILogger> loggers = new ArrayList<>();
        loggers.add(new FileLogger(".", "result.json"));
        IItemStorage itemStorage = new ItemStorage();

        IItem[] items = i.importJsonToItem("file:data/items.json");
        for (IItem item : items) {
            item.setQuantity(item.getTargetQuantity());
            itemStorage.putItem(item);
        }
        ITruck[] trucks = i.importJsonToTruck("file:data/trucks.json");


        IAlgorithm algorithm = new DynBackpack(trucks, itemStorage);

        new Formatter().generateOutput(loggers, algorithm.calculate());
    }
}
