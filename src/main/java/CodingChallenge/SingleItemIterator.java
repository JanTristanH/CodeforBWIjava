package CodingChallenge;

import java.util.Arrays;

public class SingleItemIterator implements IIterator {
    private final IItem[] items;
    private int itemCursor = 0;
    private int itemCountCursor = -1;

    public SingleItemIterator(IItem[] items) {
        this.items = items;
    }

    @Override
    public IItem current() {
        return items[itemCursor];
    }

    @Override
    public IItem next() {
        if (items[itemCursor].getTargetQuantity() <= itemCountCursor + 1) {
            itemCountCursor = -1;
            itemCursor++;
        }
        itemCountCursor++;
        return items[itemCursor]; //todo can throw out of bounds
    }

    @Override
    public boolean hasNext() {
        if (items[itemCursor].getTargetQuantity() > itemCountCursor + 1) {
            return true;
        }
        return items.length > itemCursor + 1 && items[itemCursor + 1].getTargetQuantity() > 0;
    }

    @Override
    public int maxCount() {
        return Arrays.stream(items)
                .map(item -> item.getTargetQuantity())
                .reduce(0, (subtotal, element) -> subtotal + element);

    }
}
