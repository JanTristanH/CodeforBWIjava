package coding.challenge.datastructures;

public interface ITruck extends IItemStorage {
    int getCapacityGramm();

    void setCapacityGramm(int weightInGramm);

    int getFreeCapacity();

    int getCapacity();

    void loadItem(IItem item);

    int getTotalLoad();

    int getWeightEquipment();

    void setWeightEquipment(int weightEquipment);

}
