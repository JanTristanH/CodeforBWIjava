package codingChallenge;

public interface IItem {
    String getName();
    int getTargetQuantity();
    int getQuantity();
    void setQuantity(int quantity);
    int getWeightInGramm();
    int getUtility();
}
