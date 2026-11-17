package com.memoryGame.services;

import com.memoryGame.models.Board;
import com.memoryGame.models.BoardSize;
import com.memoryGame.models.Game;
import com.memoryGame.repositories.GameRepository;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game setupGame(BoardSize boardSize){
        Board board = new Board(boardSize);
        Game newGame = new Game(board);
        gameRepository.createGame(newGame);
        return newGame;
    }
}
