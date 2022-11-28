package com.chornobuk.parsers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.chornobuk.entities.Fine;
import com.chornobuk.entities.FineType;

public class FinesXMLParserTest {

    @Test
    public void parseFines() {
        final String path = "src/test/resources/fines.xml";
        File file = new File(path);
        Map.Entry<String, List<Fine>> entry = getFinesData();
        FinesXMLParser finesXMLParser = new FinesXMLParser();
        assertEquals(entry, finesXMLParser.parseFromFile(file));
    }


    @Test
    public void parseDrunk() {
        final String path = "src/test/resources/drunk.xml";
        File file = new File(path);
        Map.Entry<String, List<Fine>> entry = getDrunkData();
        FinesXMLParser finesXMLParser = new FinesXMLParser();
        assertEquals(entry, finesXMLParser.parseFromFile(file));
    }

    public static Map.Entry<String, List<Fine>> getDrunkData() {
        List<Fine> fines = new ArrayList<>();
        fines.add(new Fine(
                LocalDateTime.of(2020, 5, 5, 21, 44, 17),
                "Boris",
                "Brown",
                FineType.DRUNKDRIVING,
                new BigDecimal("10000")));

        fines.add(new Fine(
                LocalDateTime.of(2020, 3, 8, 22, 3, 30),
                "Boris",
                "Brown",
                FineType.DRUNKDRIVING,
                new BigDecimal("20000")));

        fines.add(new Fine(
                LocalDateTime.of(2020, 12, 31, 23, 0, 25),
                "Boris",
                "Brown",
                FineType.DRUNKDRIVING,
                new BigDecimal("30000")));

        return Map.entry("drunk.xml", fines);
    }

    public static Map.Entry<String, List<Fine>> getFinesData() {
        List<Fine> fines = new ArrayList<>();
        fines.add(new Fine(
                LocalDateTime.of(2020, 5, 5, 15, 39, 3),
                "Ivan",
                "Ivanov",
                FineType.SPEEDING,
                new BigDecimal("340.0")));

        fines.add(new Fine(
                LocalDateTime.of(2020, 12, 31, 18, 0, 17),
                "Fred",
                "Alfred",
                FineType.PARKING,
                new BigDecimal("500.50")));

        return Map.entry("fines.xml", fines);
    }
}
