package codingChallenge;

import codingChallenge.impl.Item;
import codingChallenge.impl.Truck;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Sample {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            IItem item = new Item("ItemA", 10, 9, 8, 7);
            ITruck truck =  new Truck(110,87);
            truck.loadItem(item);
            ITruck[] atrucks = new ITruck[1];
            atrucks[0] = truck;
            String json = mapper.writeValueAsString(atrucks);
            System.out.println("ResultingJSONstring = " + json);
            //System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
