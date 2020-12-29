package codingChallenge;

public interface ITruck  extends  IItemStorage{
    int getCapacityGramm();
    int getFreeCapacity();
    void loadItem(IItem item);
    int getTotalLoad();
}
