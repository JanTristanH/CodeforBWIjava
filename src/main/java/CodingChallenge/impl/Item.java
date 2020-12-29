package CodingChallenge.impl;

import CodingChallenge.IItem;

public class Item implements IItem {
    private String name;
    private int targetQuantity;
    private int quantity;
    private int weightInGramm;
    private int utility;

    public Item(String name, int targetQuantity, int quantity, int weightInGramm, int utility) {
        this.name = name;
        this.targetQuantity = targetQuantity;
        this.quantity = quantity;
        this.weightInGramm = weightInGramm;
        this.utility = utility;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getTargetQuantity() {
        return targetQuantity;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int getWeightInGramm() {
        return weightInGramm;
    }

    @Override
    public int getUtility() {
        return utility;
    }
}
