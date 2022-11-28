package com.chornobuk;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class XMLPersonsModifier {
    public void joinNamesAndSurnames(String inputFilePath, String outputFilePath) throws IOException {
        if (inputFilePath.equals(outputFilePath)) {
            throw new IllegalArgumentException("input and output pathes cannot be the same");
        }
        try (Scanner scanner = new Scanner(new FileReader(inputFilePath)).useDelimiter(">");
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            while (scanner.hasNext()) {
                String next = scanner.next() + ">";
                if (!next.contains("<persons>") && !next.contains("</persons>")) {
                    next = XMLPersonModifier.joinNameAndSurname(next);
                }
                writer.write(next);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
