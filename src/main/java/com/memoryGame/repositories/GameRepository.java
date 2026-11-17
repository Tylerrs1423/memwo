package com.memoryGame.repositories;

import com.memoryGame.models.Board;
import com.memoryGame.models.BoardSize;
import com.memoryGame.models.Game;
import org.springframework.stereotype.Repository;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class GameRepository {
    private final Map<String, Game> games = new ConcurrentHashMap<>();

    public Game createGame(Game game) {
        games.put(game.getGameId(), game);
        return game;
    }

    public Game getGame(String gameId){
        return games.get(gameId);
    }

    public void deleteGame(String gameId) {
        games.remove(gameId);
    }

    public static void main(String[] args) {
        GameRepository repo = new GameRepository();

        Game game = repo.createGame(new Game(new Board(BoardSize.MEDIUM)));
        String gameId = game.getGameId();
        System.out.println(repo.games.get(gameId));
        repo.deleteGame(gameId);
        System.out.println(repo.games.get(gameId));
    }
}
