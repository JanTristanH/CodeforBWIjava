package coding.challenge.datastructures;

import coding.challenge.datastructures.IItem;

public interface IIterator {
    IItem current();

    IItem next();

    boolean hasNext();

    int maxCount();

    void reset();

    IItem convertConcurrentIndexToItem(int index);
}
