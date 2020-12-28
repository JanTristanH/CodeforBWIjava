package CodingChallenge;

public interface IItemStorage {
    /**
     * @param item adds only 1 of the item; item key is name
     */
    void loadItem(IItem item);
    /**
     * @param item removes only 1 of the item; item key is name
     */
    void unLoadItem(IItem item);
    int getTotalLoad();
}
