package com.chornobuk.parsers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.chornobuk.entities.Fine;

public class FinesFolderParserTest {
    @Test
    public void testReadFinesFromFolder() {
        Map<String, List<Fine>> fileFinesMap = new HashMap<>();
        Map.Entry<String, List<Fine>> fines = FinesXMLParserTest.getFinesData();
        Map.Entry<String, List<Fine>> drunk = FinesXMLParserTest.getDrunkData();
        fileFinesMap.put(fines.getKey(), fines.getValue());
        fileFinesMap.put(drunk.getKey(), drunk.getValue());
        final String path = "src/test/resources";
        FinesFolderParser finesFolderParser = new FinesFolderParser();
        assertEquals(fileFinesMap, finesFolderParser.readFinesFromFolder(path));
    }
   
}
