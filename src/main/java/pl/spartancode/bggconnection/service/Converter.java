package pl.spartancode.bggconnection.service;

import org.springframework.stereotype.Service;
import pl.spartancode.bggconnection.model.Items;

@Service
public interface Converter {
    String convertFromItems(Items items) throws Exception;

    Items convertToItems(String input) throws Exception;
}
