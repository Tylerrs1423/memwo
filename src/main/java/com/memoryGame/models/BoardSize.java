package com.memoryGame.models;

public enum BoardSize {
    SMALL(4,4),
    MEDIUM(4,6),
    LARGE(6,6);

    private final int rows;
    private final int cols;

    BoardSize(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int getTotalCards(){
        return rows * cols;
    }

    public int getTotalUniqueCards(){
        return getTotalCards() / 2;
    }
}
