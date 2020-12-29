package coding.challenge.datastructures.impl;

import coding.challenge.datastructures.ITruck;

public class Truck extends ItemStorage implements ITruck {
    private int capacityGramm;
    private int weightEquipment;

    public Truck() {

    }

    public Truck(int capacityGramm, int weightEquipment) {
        super();
        this.weightEquipment = weightEquipment;
        this.capacityGramm = capacityGramm;
    }

    public int getCapacityGramm() {
        return capacityGramm;
    }

    public void setCapacityGramm(int capacityGramm) {
        this.capacityGramm = capacityGramm;
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
}
