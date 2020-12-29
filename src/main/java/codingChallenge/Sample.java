package codingChallenge;

import codingChallenge.impl.Item;
import codingChallenge.impl.Truck;
import codingChallenge.input.IImportJsonToItem;
import codingChallenge.input.impl.importJsonToItem;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Sample {
    public static void main(String[] args) {
        IImportJsonToItem i = new importJsonToItem();
        IItem[] items = i.importJsonToItem("file:data/items.json");
        System.out.println(items.toString());

    }

}
