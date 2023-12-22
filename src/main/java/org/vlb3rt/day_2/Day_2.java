package org.vlb3rt.day_2;

import org.vlb3rt.InputFileReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Day_2 {

    private static int getValue(String element) {
        return Integer.parseInt(element.trim().substring(0, element.trim().indexOf(" ")).trim());
    }

    private static String getKey(String element) {
        return element.trim().substring(element.trim().indexOf(" ")).trim();
    }

    static Map<String, Integer> maxValues = Map.of("red", 12, "green", 13, "blue", 14);

    public static int isLineValid(String line) {
        List<String> values = List.of(line.split("[:,;]"));
        return !values.stream().skip(1).filter(Day_2::isSingleResultValid).toList().isEmpty() ? 0 : Integer.parseInt(getKey(values.get(0)));
    }

    private static boolean isSingleResultValid(String value) {
        return getValue(value) > maxValues.get(getKey(value));
    }

    private static int getPower(String line) {
        Map<String, Integer> maxPowers = new HashMap<>(Map.of("red", 0, "green", 0, "blue", 0));

        Stream.of(line.split("[:,;]")).skip(1).forEach(value -> {
            if(maxPowers.get(getKey(value)) < getValue(value)) maxPowers.put(getKey(value), getValue(value));
        });

        return maxPowers.get("red") * maxPowers.get("green") * maxPowers.get("blue");
    }

    public static void main(String[] args) {
        List<String> lines = InputFileReader.readInput(Day_2.class);

        System.out.println("Result for day: 2, part: 1 is: " + lines.stream().map(Day_2::isLineValid).reduce(0, Integer::sum));
        System.out.println("Result for day: 2, part: 2 is: " + lines.stream().map(Day_2::getPower).reduce(0, Integer::sum));
    }
}
