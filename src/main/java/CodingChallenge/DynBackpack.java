package CodingChallenge;

public class DynBackpack implements IAlgorithm {
    private ITruck[] trucks;
    private IIterator iterator;

    public DynBackpack(ITruck[] trucks, IIterator iterator) {
        this.trucks = trucks;
        this.iterator = iterator;
    }


    public int[][] calculateMatrix(ITruck truck) {
        //generate matrix for truck
        int[][] matrix = new int[iterator.maxCount() +1][truck.getFreeCapacity() + 1];
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

    @Override
    public ITruck[] calculate() {
        //Todo iteraten
        for (int i = 0; i < trucks.length; i++) {
            //todo iterator clearen
            int[][] matrix = this.calculateMatrix(trucks[i]);
            //todo backtrack
            //todo prepare for next truck
        }
        return new ITruck[0];
    }
}
