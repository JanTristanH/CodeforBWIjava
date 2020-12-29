package coding.challenge.input.impl;

import coding.challenge.datastructures.IItem;
import coding.challenge.datastructures.ITruck;
import coding.challenge.datastructures.impl.Item;
import coding.challenge.datastructures.impl.Truck;
import coding.challenge.input.IImportJson;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URL;

public class importJson implements IImportJson {
    @Override
    public IItem[] importJsonToItem(String fileURL) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            URL url = new URL(fileURL);
            IItem[] items = objectMapper.readValue(url, Item[].class);
            return items;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new IItem[0];

    }

    @Override
    public ITruck[] importJsonToTruck(String fileURL) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            URL url = new URL(fileURL);
            ITruck[] trucks = objectMapper.readValue(url, Truck[].class);
            return trucks;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ITruck[0];
    }
}
