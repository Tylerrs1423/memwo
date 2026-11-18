package com.memoryGame.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
    private BoardSize boardSize;
    private List<Card> cards;

    public Board(BoardSize size){
        this.boardSize = size;
        this.cards = createBoard(size);
    }

    private List<Card> createBoard(BoardSize size) {
        List<String> uniqueValues = UniquePicker.getUniqueValues(size);
        List<String> allValues = new ArrayList<>();

        for (String value : uniqueValues){
            allValues.add(value);
            allValues.add(value);
        }

        Collections.shuffle(allValues, ThreadLocalRandom.current());

        List<Card> boardCards = new ArrayList<>();
        for (int i = 0; i < allValues.size(); i++){
            boardCards.add(new Card(allValues.get(i), i));
        }
        return boardCards;
    }

    @JsonIgnore
    public List<Card> getCards() {
        return cards;
    }

    public BoardSize getBoardSize() {
        return boardSize;
    }

    public void flipCard(){

    }

    public Card getCard(int id){
        for (Card card: cards){
            if (card.getId() == id){
                return card;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return "Board{" +
                "boardSize=" + boardSize +
                ", cards=" + cards +
                '}';
    }
}
