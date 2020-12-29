package codingChallenge.impl;

import codingChallenge.IItem;
import codingChallenge.IItemStorage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class ItemStorage implements IItemStorage {
    private Map<String, IItem> loadedProducts;

    public ItemStorage() {
        this.loadedProducts = new HashMap<String, IItem>();
    }

    @Override
    public int getTotalLoad() {
        return loadedProducts.values().stream()
                .map(item -> item.getQuantity() * item.getWeightInGramm())
                .reduce(0, (subtotal, element) -> subtotal + element);
    }

    @Override
    public int getTotalUtility() {
        return loadedProducts.values().stream()
                .map(item -> item.getQuantity() * item.getUtility())
                .reduce(0, (subtotal, element) -> subtotal + element);
    }

    @Override
    public List<IItem> getAllItems() {
        return loadedProducts.values().stream().collect(toList());
    }

    @Override
    public void loadItem(IItem item) {
        if (!loadedProducts.containsKey(item.getName())) {
            item.setQuantity(1);
            loadedProducts.put(item.getName(), item);//todo maybe use artificial key
        } else {
            IItem p = loadedProducts.get(item.getName());
            p.setQuantity(p.getQuantity() + 1);
            loadedProducts.put(p.getName(), p);
        }
    }

    @Override
    public void unLoadItem(IItem item) {
        if (!loadedProducts.containsKey(item.getName())) {
            loadedProducts.put(item.getName(), item);//todo maybe use artificial key
        } else {
            IItem p = loadedProducts.get(item.getName());
            if(item.getQuantity() > 1){
                p.setQuantity(item.getQuantity() - 1);
                loadedProducts.put(p.getName(), p);
            } else {
                loadedProducts.remove(p.getName());
            }
        }
    }
}
