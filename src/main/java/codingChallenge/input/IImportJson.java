package codingChallenge.input;

import codingChallenge.IItem;
import codingChallenge.ITruck;

public interface IImportJson {
    IItem[] importJsonToItem (String fileURL);
    ITruck[] importJsonToTruck (String fileURL);
}
