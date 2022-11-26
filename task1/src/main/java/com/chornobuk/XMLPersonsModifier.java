package com.chornobuk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class XMLPersonsModifier {
    public void joinNamesAndSurnames(String inputFilePath, String outputFilePath) throws IOException {
        if (inputFilePath.equals(outputFilePath)) {
            throw new IllegalArgumentException("input and output pathes cannot be the same");
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                if (line.contains("<persons>")) {
                    writer.write(line);
                    writer.write(System.getProperty("line.separator"));
                } else if(line.contains("</persons>")) {
                    writer.write(line);
                } else if (line.contains("/>")) {
                    stringBuilder.append(line);
                    stringBuilder.append(System.getProperty("line.separator"));
                    
                    String xmlPerson = stringBuilder.toString();
                    String result = XMLPersonModifier.joinNameAndSurname(xmlPerson);
                    stringBuilder.setLength(0);// clear string builder after writing
                    
                    writer.write(result);
                    writer.flush();
                } else {
                    stringBuilder.append(line);
                    stringBuilder.append(System.getProperty("line.separator"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
