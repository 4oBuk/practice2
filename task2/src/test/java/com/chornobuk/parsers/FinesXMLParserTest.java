package com.chornobuk.parsers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.chornobuk.entities.Fine;
import com.chornobuk.testdata.TestFinesData;

public class FinesXMLParserTest {

    @Test
    public void parseFines() {
        final String path = "src/test/resources/type/fines.xml";
        File file = new File(path);
        Map.Entry<String, List<Fine>> entry = TestFinesData.getSpedingFines();
        FinesXMLParser finesXMLParser = new FinesXMLParser();
        assertEquals(entry, finesXMLParser.parseFromFile(file));
    }


    @Test
    public void parseDrunk() {
        final String path = "src/test/resources/type/drunk.xml";
        File file = new File(path);
        Map.Entry<String, List<Fine>> entry = TestFinesData.getDrunkFines();
        FinesXMLParser finesXMLParser = new FinesXMLParser();
        assertEquals(entry, finesXMLParser.parseFromFile(file));
    }
}
