package coding.challenge.impl;

import coding.challenge.IItem;
import coding.challenge.IIterator;

import java.util.ArrayList;
import java.util.Arrays;

public class SingleItemIterator implements IIterator {
    private final IItem[] items;
    private int itemCursor = 0;
    private int itemCountCursor = -1;
    private ArrayList<Integer> productUptoConcurrentIndex = new ArrayList<>();

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
            if (productUptoConcurrentIndex.isEmpty()){
                productUptoConcurrentIndex.add(itemCountCursor + 1);
            }else {
                productUptoConcurrentIndex.add(productUptoConcurrentIndex.get(productUptoConcurrentIndex.size() - 1) + itemCountCursor + 1);
            }
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

    @Override
    public void reset() {
        itemCursor = 0;
        itemCountCursor = -1;
    }

    /**
     * @param index zero based if a product was available 2 times it has the indexes 0 and 1
     * @return
     */
    @Override
    public IItem convertConcurrentIndexToItem(int index) {
        if (!this.hasNext()) { //only works if all items are iterated
            for (int i = 0; i < productUptoConcurrentIndex.size(); i++) {
                if (index < productUptoConcurrentIndex.get(i)) {
                    return items[i];
                }
            }
            return items[productUptoConcurrentIndex.size()]; //as they get added in the .next() last breaker is not in array
        }
        return null; //count up to on og items
    }
}
