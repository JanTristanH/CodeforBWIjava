package coding.challenge.run;

import coding.challenge.algorithm.IAlgorithm;
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

public abstract class AbstractRun {


    protected AbstractRun(String TRUCKS_PATH, String ITEMS_PATH, String RESULT_PATH, String TARGET_DIR, int PRECISION) {
        this.TRUCKS_PATH = TRUCKS_PATH;
        this.ITEMS_PATH = ITEMS_PATH;
        this.RESULT_PATH = RESULT_PATH;
        this.TARGET_DIR = TARGET_DIR;
        this.PRECISION = PRECISION;
    }

    protected String TRUCKS_PATH;
    protected String ITEMS_PATH;
    protected String RESULT_PATH;
    protected String TARGET_DIR;
    /**
     * multiple of 10 | shifts decimal nu,ber to reduce Storage requirement
     */
    protected int PRECISION;

    protected ITruck[] getTrucks(IImportJson i) {
        ITruck[] trucks = i.importJsonToTruck(TRUCKS_PATH);
        for (ITruck truck : trucks) {
            truck.setCapacityGramm(roundUpToNext(truck.getCapacity()));
            truck.setWeightEquipment(roundUpToNext(truck.getWeightEquipment()));
        }
        return trucks;
    }

    protected IItemStorage getStorage(IImportJson i) {
        IItem[] items = i.importJsonToItem(ITEMS_PATH);
        IItemStorage itemStorage = new ItemStorage();
        for (IItem item : items) {
            item.setQuantity(item.getTargetQuantity());
            item.setWeightInGramm(roundUpToNext(item.getWeightInGramm()));
            itemStorage.putItem(item);
        }
        return itemStorage;
    }

    public int roundUpToNext(int i) {
        return (i + PRECISION - 1) / PRECISION;
    }

    public abstract IAlgorithm getAlgorithm(ITruck[] trucks, IItemStorage itemStorage);

    public void run() {
        IImportJson i = new ImportJson();
        List<ILogger> loggers = new ArrayList<>();
        loggers.add(new FileLogger(TARGET_DIR, RESULT_PATH));


        IItemStorage itemStorage = getStorage(i);

        ITruck[] trucks = getTrucks(i);

        IAlgorithm algorithm = getAlgorithm(trucks, itemStorage);

        new Formatter().generateOutput(loggers, algorithm.calculate());
    }
}
