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
import com.chornobuk.testdata.TestFinesData;

public class FinesXMLParserTest {

    @Test
    public void parseFines() {
        final String path = "src/test/resources/fines.xml";
        File file = new File(path);
        Map.Entry<String, List<Fine>> entry = TestFinesData.getSpedingFines();
        FinesXMLParser finesXMLParser = new FinesXMLParser();
        assertEquals(entry, finesXMLParser.parseFromFile(file));
    }


    @Test
    public void parseDrunk() {
        final String path = "src/test/resources/drunk.xml";
        File file = new File(path);
        Map.Entry<String, List<Fine>> entry = TestFinesData.getDrunkFines();
        FinesXMLParser finesXMLParser = new FinesXMLParser();
        assertEquals(entry, finesXMLParser.parseFromFile(file));
    }
}
