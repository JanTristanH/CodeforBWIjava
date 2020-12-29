package coding.challenge.input;

import coding.challenge.datastructures.IItem;
import coding.challenge.datastructures.ITruck;

public interface IImportJson {
    IItem[] importJsonToItem(String fileURL);

    ITruck[] importJsonToTruck(String fileURL);
}
