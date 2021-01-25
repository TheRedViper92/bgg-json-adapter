package pl.spartancode.bggconnection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.spartancode.bggconnection.service.BGGService;

@RestController
@RequestMapping("bgg")
public class BGGController {

    private BGGService bggService;

    @Autowired
    public BGGController(BGGService bggService) {
        this.bggService = bggService;
    }

    @GetMapping(value = "/get/{gameId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String getGameById(@PathVariable String gameId) {
        String response = bggService.getGameById(gameId);
        return response;
    }
}
