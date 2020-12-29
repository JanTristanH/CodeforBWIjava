package coding.challenge.run;

import coding.challenge.algorithm.IAlgorithm;
import coding.challenge.algorithm.impl.IterativeBackpacks;
import coding.challenge.datastructures.IItemStorage;
import coding.challenge.datastructures.ITruck;

public class IterativeRun extends AbstractRun {


    public IterativeRun(String TRUCKS_PATH, String ITEMS_PATH, String RESULT_PATH, String TARGET_DIR, int PRECISION) {
        super(TRUCKS_PATH, ITEMS_PATH, RESULT_PATH, TARGET_DIR, PRECISION);
    }

    @Override
    public IAlgorithm getAlgorithm(ITruck[] trucks, IItemStorage itemStorage) {
        this.RESULT_PATH = "result10iterative.json";
        return new IterativeBackpacks(trucks, itemStorage);
    }
}
