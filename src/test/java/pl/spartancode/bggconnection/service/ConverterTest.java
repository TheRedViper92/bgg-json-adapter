package pl.spartancode.bggconnection.service;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.FileCopyUtils;
import pl.spartancode.bggconnection.model.Item;
import pl.spartancode.bggconnection.model.Items;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ConverterTest {

    private static XmlConverter xmlConverter;

    @BeforeAll
    public static void init() {
        xmlConverter = new XmlConverter();
    }

    @Test
    public void convertEmptyResponse() throws Exception {
        //when
        String noItemsResponse = readXml("bgg_empty_response.xml");
        Items actualItems = xmlConverter.convertToItems(noItemsResponse);

        //then
        Items expectedItems = new Items();
        assertThat(actualItems).isEqualTo(expectedItems);
    }

    @Test
    public void testConvertXmlToObject() throws Exception {
        //when
        var oneItemResponse = readXml("bgg_one_item_response");
        var actualItems = xmlConverter.convertToItems(oneItemResponse);
        //then
        assertThat(actualItems).isNotNull();
        var items = actualItems.getItems();
        assertThat(items).isNotNull()
                .hasSize(1);
        var item = actualItems.getItems().get(0);
        assertThat(item.getType()).isEqualTo("boardgame");
        assertThat(item.getId()).isEqualTo("1");
        assertThat(item.getThumbnail()).isEqualTo("test thumbnail");
        assertThat(item.getImage()).isEqualTo("test image");

        var names = item.getName();
        assertThat(names).isNotNull()
                .hasSize(2);
        var name_0 = names[0];
        assertThat(name_0.getType()).isEqualTo("primary");
        assertThat(name_0.getSortindex()).isEqualTo("5");
        assertThat(name_0.getValue()).isEqualTo("Primary name");
        var name_1 = names[1];
        assertThat(name_1.getType()).isEqualTo("alternate");
        assertThat(name_1.getSortindex()).isEqualTo("1");
        assertThat(name_1.getValue()).isEqualTo("Alternate name");

        assertThat(item.getDescription()).isEqualTo("Description");
        assertThat(item.getYearpublished()).isNotNull();
        assertThat(item.getYearpublished().getValue()).isEqualTo("1986");
        assertThat(item.getMinplayers()).isNotNull();
        assertThat(item.getMinplayers().getValue()).isEqualTo("3");
        assertThat(item.getMaxplayers()).isNotNull();
        assertThat(item.getMaxplayers().getValue()).isEqualTo("5");

        var polls = item.getPoll();
        assertThat(polls).isNotNull()
                .hasSize(2);

        var poll_suggestedNumplayers = polls[0];
        assertThat(poll_suggestedNumplayers.getName()).isEqualTo("suggested_numplayers");
        assertThat(poll_suggestedNumplayers.getTitle()).isEqualTo("User Suggested Number of Players");
        assertThat(poll_suggestedNumplayers.getTotalvotes()).isEqualTo("128");

        assertThat(item.getPlayingtime())
                .isNotNull()
                .hasFieldOrPropertyWithValue("value", "240");
        assertThat(item.getMinplayers()).isNotNull().hasFieldOrPropertyWithValue("value", "3");
        assertThat(item.getMaxplayers()).isNotNull().hasFieldOrPropertyWithValue("value", "5");
        assertThat(item.getMinage()).isNotNull().hasFieldOrPropertyWithValue("value", "14");

        var links = item.getLink();
        assertThat(links).isNotNull()
                .hasSize(3);
    }

    private String readXml(String fileName) {
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
        Reader reader = new InputStreamReader(resourceAsStream, StandardCharsets.UTF_8);
        try {
            return FileCopyUtils.copyToString(reader);
        } catch (IOException e) {
            return null;
        }
    }
}
