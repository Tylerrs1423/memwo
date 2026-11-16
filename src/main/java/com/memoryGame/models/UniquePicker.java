package com.memoryGame.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class UniquePicker {
    private static final List<String> VALUES = new ArrayList<>(List.of("Apple", "Banana", "Cherry", "Date", "Fig", "Grape", "Kiwi", "Lemon", "Mango", "Orange", "Pear", "Raspberry", "Strawberry", "Watermelon"));

    public static void main(String[] args){
        UniquePicker picker = new UniquePicker();
        BoardSize size = BoardSize.SMALL;
        System.out.println(picker.getUniqueValues(size));
    }

    public static List<String> getUniqueValues(BoardSize size){
        int totalUnique = size.getTotalUniqueCards();
        List<String> copy = new ArrayList<>(VALUES);
        Collections.shuffle(copy, ThreadLocalRandom.current());
        return new ArrayList<>(copy.subList(0,totalUnique));

    }

}
