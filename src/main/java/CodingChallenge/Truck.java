package CodingChallenge;

import java.util.HashMap;
import java.util.Map;

public class Truck extends ItemStorage implements ITruck {
    private int capacityGramm;
    private int weightEquipment;


    Truck(int capacityGramm, int weightEquipment) {
        super();
        this.weightEquipment = weightEquipment;
        this.capacityGramm = capacityGramm;

    }

    public int getCapacityGramm() {
        return capacityGramm;
    }

    public int getFreeCapacity() {
        return capacityGramm - weightEquipment - this.getTotalLoad();
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
