package CodingChallenge;

public interface ITruck {
    int getCapacityGramm();
    int getFreeCapacity();
    void loadItem(IItem item);
    int getTotalLoad();
}
