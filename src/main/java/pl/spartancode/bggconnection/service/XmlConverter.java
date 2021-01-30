package pl.spartancode.bggconnection.service;

import org.springframework.stereotype.Service;
import pl.spartancode.bggconnection.model.Items;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@Service
public class XmlConverter implements Converter{
    @Override
    public String convertFromItems(Items items) {
        return null;
    }

    public Items convertToItems(String xml) throws JAXBException {
        JAXBContext j2bContext = JAXBContext.newInstance(Items.class);
        Unmarshaller unmarshaller = j2bContext.createUnmarshaller();
        StringReader sr = new StringReader(xml);
        Items items = (Items) unmarshaller.unmarshal(sr);
        return items;
    }
}
