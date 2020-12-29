package coding.challenge.datastructures;

public interface IItem {
    String getName();

    int getTargetQuantity();

    int getQuantity();

    void setQuantity(int quantity);

    int getWeightInGramm();

    void setWeightInGramm(int weightInGramm);

    int getUtility();

    IItem clone();
}
