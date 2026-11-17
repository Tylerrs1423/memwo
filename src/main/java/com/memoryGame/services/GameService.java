package com.memoryGame.services;

import com.memoryGame.models.*;
import com.memoryGame.repositories.GameRepository;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    private final GameRepository gameRepository;
    public record FlipResponse(Game game, TurnResult result, String revealedCardValue){}

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game setupGame(BoardSize boardSize){
        Board board = new Board(boardSize);
        Game newGame = new Game(board);
        gameRepository.createGame(newGame);
        return newGame;
    }

    public FlipResponse flipCard(String gameId, int cardId){
        Game currentGame = gameRepository.getGame(gameId);
        TurnResult result = currentGame.selectCard(cardId);
        return new FlipResponse(currentGame, result, currentGame.getBoard().getCard(cardId).getValue());
    }
}
