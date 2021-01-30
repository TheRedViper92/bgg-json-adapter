package pl.spartancode.bggconnection.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import pl.spartancode.bggconnection.model.Items;

import javax.xml.bind.JAXBException;
import java.util.Collections;

@Service
public class BGGService {

    @Autowired
    private XmlConverter xmlConverter;
    private JSONConverter jsonConverter;

    @Value("${bgg.api.url}")
    private String bggApiUrl;

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

        Items items = null;
        try {
            items = xmlConverter.convertToItems(response);
        } catch (JAXBException e) {
            e.printStackTrace();
            return "";
        }

        String json = null;
        try {
            json = jsonConverter.convertFromItems(items);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }

        return json;
    }
}
