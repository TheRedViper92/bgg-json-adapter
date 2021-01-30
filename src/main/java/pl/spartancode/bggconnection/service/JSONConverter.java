package pl.spartancode.bggconnection.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.spartancode.bggconnection.model.Items;

public class JSONConverter implements Converter{
    @Override
    public String convertFromItems(Items items) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(items);
    }

    @Override
    public Items convertToItems(String input) throws Exception {
        return null;
    }
}
