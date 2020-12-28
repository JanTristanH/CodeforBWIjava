package CodingChallenge;

import java.util.Iterator;

public interface IIterator {
    IItem current();
    IItem next();
    boolean hasNext();
    int maxCount();
    void reset();
    IItem convertConcurrentIndexToItem(int index);
}
