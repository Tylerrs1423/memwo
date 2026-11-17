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
        List<Card> tempCards = new ArrayList<>();
        int id = 0;
        for (String value: uniqueValues){
            tempCards.add(new Card(value, id++));
            tempCards.add(new Card(value, id++));
        }
        Collections.shuffle(tempCards, ThreadLocalRandom.current());

        List<Card> boardCards = new ArrayList<>();
        for (int i = 0; i < tempCards.size(); i++){
            boardCards.add(new Card(tempCards.get(i).getValue(), i));
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
