package coding.challenge.datastructures;

import coding.challenge.datastructures.IItem;
import coding.challenge.datastructures.IItemStorage;

public interface ITruck extends IItemStorage {
    int getCapacityGramm();

    int getFreeCapacity();

    void loadItem(IItem item);

    int getTotalLoad();
}
