package com.chornobuk.parsers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.chornobuk.entities.Fine;
import com.chornobuk.testdata.TestFinesData;

public class FinesFolderParserTest {
    @Test
    public void testReadFinesFromFolder() {
        Map<String, List<Fine>> fileFinesMap = new HashMap<>();
        Map.Entry<String, List<Fine>> fines = TestFinesData.getSpedingFines();
        Map.Entry<String, List<Fine>> drunk = TestFinesData.getDrunkFines();
        fileFinesMap.put(fines.getKey(), fines.getValue());
        fileFinesMap.put(drunk.getKey(), drunk.getValue());
        final String path = "src/test/resources";
        FinesFolderParser finesFolderParser = new FinesFolderParser();
        assertEquals(fileFinesMap, finesFolderParser.readFinesFromFolder(path));
    }
   
}
