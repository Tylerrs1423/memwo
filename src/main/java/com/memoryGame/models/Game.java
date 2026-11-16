package com.memoryGame.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private final Board board;
    private Card firstFlippedCard;
    private int moves;
    private int matches;
    private int playerTurn;
    private final List<Integer> leaderboard;

    public Game(Board board) {
        this.board = board;
        this.leaderboard = new ArrayList<>(List.of(0,0));
    }

    public static void main(String[] args){
        Board board = new Board(BoardSize.MEDIUM);
        Game game = new Game(board);

        Scanner scanner = new Scanner(System.in);
        System.out.println(board);
        while (true){
            if (game.isGameOver()){
                break;
            }
            System.out.println("Enter a number Player " + game.getPlayerTurn());
            if (scanner.hasNextInt()){
                int number = scanner.nextInt();
                System.out.println(game.selectCard(number));
            }
            else{
                System.out.println("Please enter valid number");
                scanner.next();
            }
        }
        System.out.println(game.getLeaderboard());
    }

    public TurnResult selectCard(int id){
        if (id < 0 || id >= board.getBoardSize().getTotalCards()){
            return TurnResult.INVALID_MOVE;
        }
        Card selected = board.getCard(id);

        if (selected.isMatched() || selected.isFlipped() || isGameOver()){
            return TurnResult.INVALID_MOVE;
        }

        moves++;

        selected.flip();
        if (firstFlippedCard == null){
            firstFlippedCard = selected;
            return TurnResult.FIRST_CARD_FLIPPED;
        }


        if (isMatch(firstFlippedCard, selected)){
            firstFlippedCard.match();
            selected.match();
            firstFlippedCard = null;
            leaderboard.set(playerTurn, leaderboard.get(playerTurn) + 1);
            matches++;
            if (isGameOver()){
                return getGameResult();
            }
            return TurnResult.MATCH_FOUND;
        }

        firstFlippedCard.hide();
        playerTurn = (playerTurn == 0) ? 1 : 0;
        return TurnResult.NO_MATCH;
    }

    private boolean isMatch(Card firstCard, Card secondCard){
        return firstCard.getValue().equals(secondCard.getValue());
    }

    public boolean isGameOver(){
        return matches == board.getBoardSize().getTotalUniqueCards();
    }

    public TurnResult getGameResult(){
        int playerOneScore = leaderboard.get(0);
        int playerTwoScore = leaderboard.get(1);
        if (playerOneScore == playerTwoScore){
            return TurnResult.DRAW;
        }
        else if (playerOneScore > playerTwoScore){
            return TurnResult.PLAYER_ONE_WINS;
        }
        else{
            return TurnResult.PLAYER_TWO_WINS;
        }
    }


    public Board getBoard() {
        return board;
    }

    public Card getFirstFlippedCard() {
        return firstFlippedCard;
    }

    public int getMoves() {
        return moves;
    }

    public int getPlayerTurn() {
        return playerTurn;
    }

    public List<Integer> getLeaderboard(){
        return leaderboard;
    }
}
