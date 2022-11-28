package com.chornobuk.parsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.chornobuk.entities.Fine;

public class FinesXMLParser {
    public Map.Entry<String, List<Fine>> parseFines(String path) {
        File file = new File(path);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            List<Fine> finesFromFile = new ArrayList<>();
            FineXMLParser fineXMLParser = new FineXMLParser();
            while ((line = reader.readLine()) != null) {
                if (!line.contains("<fines>") && !line.contains("</fines>")) {
                    stringBuilder.append(line);
                    if (line.contains("/>")) {
                        String xmlFine = stringBuilder.toString();
                        finesFromFile.add(fineXMLParser.parseFine(xmlFine));
                        stringBuilder.setLength(0);
                    }
                }
            }
            return Map.entry(file.getName(), finesFromFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
