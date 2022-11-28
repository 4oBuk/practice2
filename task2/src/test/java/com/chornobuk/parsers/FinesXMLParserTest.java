package com.chornobuk.parsers;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        List<Fine> fines = new ArrayList<>();
        final String path = "src/test/resources/fines.xml";
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
        
        Map.Entry<String, List<Fine>> entry = Map.entry("fines.xml",fines);
        FinesXMLParser finesXMLParser = new FinesXMLParser();
        assertEquals(entry, finesXMLParser.parseFines(path));
    }
}
