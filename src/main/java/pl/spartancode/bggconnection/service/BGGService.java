package pl.spartancode.bggconnection.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import pl.spartancode.bggconnection.model.Item;
import pl.spartancode.bggconnection.model.Items;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class BGGService {

    @Value("${bgg.api.url}")
    private String bggApiUrl;

    @SneakyThrows
    public String getGameById(String gameId) {
        WebClient webClient = WebClient.builder()
                .baseUrl(bggApiUrl)
                .build();

        WebClient.RequestBodySpec uri = webClient
                .method(HttpMethod.GET)
                .uri("/thing?id={id}", Collections.singletonMap("id", gameId));


        String response = uri
                .accept(MediaType.APPLICATION_XML)
                .retrieve()
                .bodyToMono(String.class)
                .block();

//        XmlMapper xmlMapper = new XmlMapper();
//        Items items = xmlMapper.readValue(response, Items.class);

        JAXBContext j2bContext = JAXBContext.newInstance(Items.class);
        Unmarshaller unmarshaller = j2bContext.createUnmarshaller();
        StringReader sr = new StringReader(response);
        Items items = (Items) unmarshaller.unmarshal(sr);


//        Item singleItem = new Item();
//        singleItem.setName(Arrays.asList(new Item.Name("foo", "bar", "baz"),
//                new Item.Name("foo1", "bar1", "baz1"),
//                new Item.Name("foo2", "bar2", "baz2")));
//        Items aaa = new Items(Collections.singletonList(singleItem));
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(items);
        return json;
    }
}
