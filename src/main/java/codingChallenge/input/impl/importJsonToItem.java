package codingChallenge.input.impl;

import codingChallenge.IItem;
import codingChallenge.impl.Item;
import codingChallenge.input.IImportJsonToItem;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URL;

public class importJsonToItem implements IImportJsonToItem {
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
}
