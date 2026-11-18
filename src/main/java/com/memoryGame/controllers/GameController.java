package com.memoryGame.controllers;

import com.memoryGame.models.BoardSize;
import com.memoryGame.models.Game;
import com.memoryGame.models.TurnResult;
import com.memoryGame.services.GameService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/game")
public class GameController {
    private GameService gameService;

    public GameController(GameService gameService){
        this.gameService = gameService;
    }

    @PostMapping("/start")
    public Game startGame(@RequestParam BoardSize boardSize){
        return gameService.setupGame(boardSize);
    }

    @PutMapping("/{gameId}/flip")
    public GameService.FlipResponse flipCard(@PathVariable String gameId, @RequestParam int cardId){
        return gameService.flipCard(gameId, cardId);
    }

    @GetMapping("/{gameId}/result")
    public boolean getGameResult(@PathVariable String gameId){
        return gameService.getGameResult(gameId);
    }

}
