package coding.challenge.input;

import coding.challenge.IItem;
import coding.challenge.ITruck;

public interface IImportJson {
    IItem[] importJsonToItem(String fileURL);

    ITruck[] importJsonToTruck(String fileURL);
}
