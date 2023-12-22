package org.vlb3rt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputFileReader {

    public static List<String> readInput(Class c) {
        List<String> input = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/" + c.getSimpleName().toLowerCase() + "/input.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                input.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return input;
    }
}