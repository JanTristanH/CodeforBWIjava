package coding.challenge.algorithm.impl;

import coding.challenge.algorithm.IAlgorithm;
import coding.challenge.datastructures.IItem;
import coding.challenge.datastructures.IItemStorage;
import coding.challenge.datastructures.IIterator;
import coding.challenge.datastructures.ITruck;
import coding.challenge.datastructures.impl.SingleItemIterator;

public class IterativeBackpacks implements IAlgorithm {
    private final ITruck[] trucks;
    private final IItemStorage itemStorage;

    public IterativeBackpacks(ITruck[] trucks, IItemStorage itemStorage) {
        this.itemStorage = itemStorage;
        this.trucks = trucks;

    }


    public int[][] calculateMatrix(ITruck truck, IIterator iterator) {
        //generate matrix for truck
        int[][] matrix = new int[iterator.maxCount() + 1][truck.getFreeCapacity() + 1];
        for (int i = 1; i < matrix.length; i++) {
            IItem wi = iterator.next(); //exception cleared via .maxCount()
            for (int j = 1; j < matrix[0].length; j++) {
                if (j - wi.getWeightInGramm() < 0) {
                    //if it doesnt fit best without it
                    matrix[i][j] = matrix[i - 1][j];
                } else {
                    //take with or without better
                    matrix[i][j] = Math.max(matrix[i - 1][j], wi.getUtility() + matrix[i - 1][j - wi.getWeightInGramm()]);
                }
            }
        }
        return matrix;
    }

    /**
     * @apiNote this method has side effects on truck and itemStorage
     */
    public void backtrackMatrixToIndex(int[][] matrix, IIterator iterator, ITruck truck) {
        int currentWeight = matrix[0].length - 1;
        int currentItemIndex = matrix.length - 1;
        while (currentWeight > 0 && currentItemIndex > 0) {
            if (matrix[currentItemIndex][currentWeight] > matrix[currentItemIndex - 1][currentWeight]) {
                IItem itemToLoad = iterator.convertConcurrentIndexToItem(currentItemIndex - 1); //- 1 as part of index shifting
                truck.loadItem(itemToLoad);
                itemStorage.unLoadItem(itemToLoad);
                currentWeight = currentWeight - itemToLoad.getWeightInGramm();
            }
            currentItemIndex--;
        }
    }

    @Override
    public ITruck[] calculate() {
        for (ITruck truck : trucks) {
            IIterator iterator = new SingleItemIterator(itemStorage.getAllItems().toArray(new IItem[0]));
            int[][] matrix = this.calculateMatrix(truck, iterator);
            this.backtrackMatrixToIndex(matrix, iterator, truck);
        }
        return trucks;
    }
}
