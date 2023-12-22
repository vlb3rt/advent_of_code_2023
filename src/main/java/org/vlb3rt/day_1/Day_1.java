package org.vlb3rt.day_1;

import org.vlb3rt.InputFileReader;

import java.util.List;
import java.util.Map;

public class Day_1 {

    public static int getNumber(String line) {
        String first = "", last = "";
        for(int i=0; i<line.length(); i++) {
            char startChar = line.charAt(i), endChar = line.charAt(line.length() - 1 - i);

            if(Character.isDigit(startChar) && first.isEmpty()) first = String.valueOf(startChar);

            if(Character.isDigit(endChar) && last.isEmpty()) last = String.valueOf(endChar);
        }
        return Integer.parseInt(first.concat(last));
    }

    private static final Map<String, String> replacements = Map.of(
            "one", "1",
            "two", "2",
            "three", "3",
            "four", "4",
            "five", "5",
            "six", "6",
            "seven", "7",
            "eight", "8",
            "nine", "9"
    );

    public static String replaceWordsWithNumbers(String line) {
        String newLine = "", lineToCheck = "";
        for(int i=0; i<line.length(); i++) {
            char sign = line.charAt(i);
            if(!Character.isDigit(sign)) {
                lineToCheck = lineToCheck.concat(String.valueOf(sign));
                for (String key : replacements.keySet()) {
                    if (lineToCheck.contains(key)) {
                        newLine = newLine.concat(replacements.get(key));
                        lineToCheck = String.valueOf(sign);
                        break;
                    }
                }
            } else {
                newLine = newLine.concat(String.valueOf(sign));
            }
        }
        return newLine;
    }

    public static void main(String[] args) {
        List<String> lines = InputFileReader.readInput(Day_1.class);
        int sum_1 = 0, sum_2 = 0;

        for (String line : lines) {
            sum_1 += getNumber(line);
            sum_2 += getNumber(replaceWordsWithNumbers(line));
        }
        System.out.println("Result for day: 1, part: 1 is: " + sum_1);
        System.out.println("Result for day: 1, part: 2 is: " + sum_2);
    }
}