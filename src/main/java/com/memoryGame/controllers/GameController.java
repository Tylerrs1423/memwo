package com.memoryGame.controllers;

import com.memoryGame.models.BoardSize;
import com.memoryGame.models.Game;
import com.memoryGame.services.GameService;
import org.springframework.web.bind.annotation.*;

@RestController
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


}
