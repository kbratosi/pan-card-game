package com.company;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class PanCard {
    enum Color {
        Heart, Spade, Diamond, Club ;

        private static final Color[] colors = Color.values();

        public static Color getColor(int i) {
            return Color.colors[i];
        }
    }

    enum Value {
        Nine, Ten, Jack, Queen, King, Ace;

        private static final Value[] values = Value.values();

        public static Value getValue(int i) {
            return Value.values[i];
        }
    }

    private final Color color;
    private final Value value;
    private final int colorInt;
    private final int valueInt;

    public PanCard(final Color color, final Value value) {
        this.color = color;
        this.value = value;
        this.colorInt = getColorInt();
        this.valueInt = getValueInt();
    }

    public Color getColor() {
        return this.color;
    }

    public int getColorInt() {
        int colorNum;
        String colorName = this.color.toString();
        switch (colorName) {
            case "Spade":
                colorNum = 0;
                break;
            case "Club":
                colorNum = 1;
                break;
            case "Heart":
                colorNum = 2;
                break;
            case "Diamond":
                colorNum = 3;
                break;
            default:
                colorNum = -1;
        }
        return colorNum;
    }

    public Value getValue() {
        return this.value;
    }

    public int getValueInt() {
        int valueNum;
        String valueName = this.value.toString();
        switch (valueName) {
            case "Nine":
                valueNum = 0;
                break;
            case "Ten":
                valueNum = 1;
                break;
            case "Jack":
                valueNum = 2;
                break;
            case "Queen":
                valueNum = 3;
                break;
            case "King":
                valueNum = 4;
                break;
            case "Ace":
                valueNum = 5;
                break;
            default:
                valueNum = -1;
        }
        return valueNum;
    }

    public String toString() {
        return color + "_" + value;
    }

    public static void sortTable (ArrayList<ArrayList<Integer>> cardTable) {
        Collections.sort(cardTable, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> firstCard, ArrayList<Integer> secondCard) {
                Integer colorCompare = firstCard.get(0).compareTo(secondCard.get(0));
                Integer cardCompare = firstCard.get(1).compareTo(secondCard.get(1));

                if (colorCompare == 0) {
                    return ((cardCompare == 0) ? colorCompare : cardCompare);
                } else {
                    return colorCompare;
                }
            }
        });
    }
}
