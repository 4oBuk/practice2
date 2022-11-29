package com.chornobuk.parsers;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.chornobuk.entities.Fine;

public class FinesXMLParser {
    public Map.Entry<String, List<Fine>> parseFromFile(File file) {
        try (Scanner scanner = new Scanner(new FileReader(file)).useDelimiter(">")) {
            String line;
            List<Fine> finesFromFile = new ArrayList<>();
            FineXMLParser fineXMLParser = new FineXMLParser();
            while (scanner.hasNext()) {
                line = scanner.next() + ">";
                if (!line.contains("<fines>") && !line.contains("</fines>")) {
                    finesFromFile.add(fineXMLParser.parseFine(line));
                }
            }
            return Map.entry(file.getName(), finesFromFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
