package pl.spartancode.bggconnection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.spartancode.bggconnection.service.BGGService;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BGGServiceTest {

    @Mock
    BGGService bggService;

    @Test
    public void xmlToObjectTest() throws Exception{
//        when(bggService.thingXmlStringToObject(""));
//        when(bggService.getGameById(anyString())).thenReturn("{\"items\":[{\"thumbnail\":\"https://cf.geekdo-images.com/VkUwDn_UgPYFOpyzmkgvcQ__thumb/img/5mz1xHVNGrRU-YG0AOyjgjL5AwI=/fit-in/200x150/filters:strip_icc()/pic479993.jpg\",\"image\":\"https://cf.geekdo-images.com/VkUwDn_UgPYFOpyzmkgvcQ__original/img/KAH_NPC1yjQcZWuLtaPC8aHU9BU=/0x0/filters:format(jpeg)/pic479993.jpg\",\"name\":[{\"type\":\"primary\",\"sortindex\":\"1\",\"value\":\"Berzerk\"}],\"description\":\"From the box:&#10;&#10;Go Berzerk and play the exciting shoot-em-up game that's just as much fun as the arcade game of the same name!  You and your opponent take turns controlling either the Humanoid Warrior or the indestructible Evil Otto and his robot army.  Make the wrong move and your Humanoid will get zapped.  You score points for every enemy robot your Humanoid zaps and a bonus if you get all six.  You opponent gets a chance to be the Humanoid player and zap robots to score points later in the game.  Score more points than your opponent and you'll win the game!&#10;&#10;\",\"yearpublished\":{\"value\":\"1983\"},\"minplayers\":{\"value\":\"2\"},\"maxplayers\":{\"value\":\"2\"},\"poll\":[{\"name\":\"suggested_numplayers\",\"title\":\"User Suggested Number of Players\",\"totalvotes\":\"1\",\"results\":[{\"result\":[{\"value\":\"Best\",\"numvotes\":\"0\"},{\"value\":\"Recommended\",\"numvotes\":\"0\"},{\"value\":\"Not Recommended\",\"numvotes\":\"0\"}],\"numplayers\":\"1\"},{\"result\":[{\"value\":\"Best\",\"numvotes\":\"1\"},{\"value\":\"Recommended\",\"numvotes\":\"0\"},{\"value\":\"Not Recommended\",\"numvotes\":\"0\"}],\"numplayers\":\"2\"},{\"result\":[{\"value\":\"Best\",\"numvotes\":\"0\"},{\"value\":\"Recommended\",\"numvotes\":\"0\"},{\"value\":\"Not Recommended\",\"numvotes\":\"0\"}],\"numplayers\":\"2+\"}]},{\"name\":\"suggested_playerage\",\"title\":\"User Suggested Player Age\",\"totalvotes\":\"0\",\"results\":null},{\"name\":\"language_dependence\",\"title\":\"Language Dependence\",\"totalvotes\":\"0\",\"results\":null}],\"playingtime\":{\"value\":\"30\"},\"minplaytime\":{\"value\":\"30\"},\"maxplaytime\":{\"value\":\"30\"},\"minage\":{\"value\":\"7\"},\"link\":[{\"type\":\"boardgamecategory\",\"id\":\"1009\",\"value\":\"Abstract Strategy\"},{\"type\":\"boardgamecategory\",\"id\":\"1041\",\"value\":\"Children's Game\"},{\"type\":\"boardgamecategory\",\"id\":\"1046\",\"value\":\"Fighting\"},{\"type\":\"boardgamecategory\",\"id\":\"1016\",\"value\":\"Science Fiction\"},{\"type\":\"boardgamecategory\",\"id\":\"1101\",\"value\":\"Video Game Theme\"},{\"type\":\"boardgamefamily\",\"id\":\"62355\",\"value\":\"Theme: Arcade Video Games\"},{\"type\":\"boardgamedesigner\",\"id\":\"8083\",\"value\":\"Jeffrey Breslow\"},{\"type\":\"boardgamedesigner\",\"id\":\"84527\",\"value\":\"Michael Ferris\"},{\"type\":\"boardgamedesigner\",\"id\":\"84528\",\"value\":\"Paul Wise\"},{\"type\":\"boardgamepublisher\",\"id\":\"4539\",\"value\":\"MB Giochi\"},{\"type\":\"boardgamepublisher\",\"id\":\"8931\",\"value\":\"MB Jeux\"},{\"type\":\"boardgamepublisher\",\"id\":\"4554\",\"value\":\"MB Spellen\"},{\"type\":\"boardgamepublisher\",\"id\":\"20\",\"value\":\"Milton Bradley\"}],\"type\":\"boardgame\",\"id\":\"5084\"}]}");

    }

}
