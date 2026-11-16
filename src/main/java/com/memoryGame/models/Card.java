package com.memoryGame.models;

public class Card {
    private CardStatus status;
    private String value;
    private int id;

    public Card(String value, int id){
        this.value = value;
        this.id = id;
        this.status = CardStatus.UNFLIPPED;
    }

    public void flip(){
        if (this.status == CardStatus.UNFLIPPED){
            this.status = CardStatus.FLIPPED;
        }
    }

    public void hide(){
        if (this.status == CardStatus.FLIPPED){
            this.status = CardStatus.UNFLIPPED;
        }
    }

    public void match(){
        this.status = CardStatus.MATCHED;

    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public CardStatus getStatus() {
        return status;
    }

    public boolean isMatched(){
        return status == CardStatus.MATCHED;
    }

    public boolean isFlipped(){
        return status == CardStatus.FLIPPED;
    }


    @Override
    public String toString() {
        return "Card{" +
                "status=" + status +
                ", value='" + value + '\'' +
                ", id=" + id +
                '}';
    }
}
