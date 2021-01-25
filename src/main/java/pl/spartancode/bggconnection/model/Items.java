package pl.spartancode.bggconnection.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@NoArgsConstructor
@XmlRootElement(name = "items")
@XmlAccessorType(XmlAccessType.FIELD)
public class Items {

    @XmlElement(name = "item")
    private List<Item> items;
}
