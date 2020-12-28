package CodingChallenge;

public class DynBackpack implements IAlgorithm{
    private ITruck[] trucks;
    private IIterator iterator;

    public DynBackpack(ITruck[] trucks, IIterator iterator) {
        this.trucks = trucks;
        this.iterator = iterator;
    }

    @Override
    public ITruck[] calculate() {
        //Todo iteraten
        return trucks;
    }
}
