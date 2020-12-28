package CodingChallenge;

import java.util.HashMap;
import java.util.Map;

public class Truck implements ITruck {
    private int capacityGramm;
    private int weightEquipment;
    private Map<String, IItem> loadedProducts;

    Truck(int capacityGramm, int weightEquipment) {
        this.weightEquipment = weightEquipment;
        this.capacityGramm = capacityGramm;
        this.loadedProducts = new HashMap<String, IItem>();
    }

    public int getCapacityGramm() {
        return capacityGramm;
    }

    public int getFreeCapacity() {
        return capacityGramm - weightEquipment - this.getTotalLoad();
    }

    public void loadItem(IItem item) {
        if (!loadedProducts.containsKey(item.getName())) {
            loadedProducts.put(item.getName(), item);//todo maybe use artificial key
        } else {
            IItem p = loadedProducts.get(item.getName());
            p.setQuantity(p.getQuantity() + item.getQuantity());
            loadedProducts.put(p.getName(), p);
        }
    }

    public int getTotalLoad() {
        return loadedProducts.values().stream()
                .map(item -> item.getQuantity() * item.getWeightInGramm())
                .reduce(0, (subtotal, element) -> subtotal + element);
    }


    public int getWeightEquipment() {
        return weightEquipment;
    }

    public void setWeightEquipment(int weightEquipment) {
        this.weightEquipment = weightEquipment;
    }

    public void setCapacityGramm(int capacityGramm) {
        this.capacityGramm = capacityGramm;
    }
}
