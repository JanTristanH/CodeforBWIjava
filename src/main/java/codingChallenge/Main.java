package codingChallenge;

import codingChallenge.impl.DynBackpack;
import codingChallenge.impl.Item;
import codingChallenge.impl.ItemStorage;
import codingChallenge.impl.Truck;
import codingChallenge.output.IFormatter;
import codingChallenge.output.ILogger;
import codingChallenge.output.impl.FileLogger;
import codingChallenge.output.impl.Formatter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ILogger> loggers = new ArrayList<>();
        loggers.add(new FileLogger(".","result.json"));
        IItemStorage itemStorage = new ItemStorage();

        IItem item = new Item("ItemA", 10, 9, 8, 7);
        ITruck truck =  new Truck(110,87);
        truck.loadItem(item);

        ITruck[] trucks = new ITruck[1];
        trucks[0] = truck;

        IAlgorithm algorithm = new DynBackpack(trucks,itemStorage);

        new Formatter().generateOutput(loggers, algorithm.calculate());
    }
}
