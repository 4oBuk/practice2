package com.chornobuk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

public class PersonsXMLModiferTest {

    @Test
    public void joinNamesAndSurnamesSamePathes() {
        String inputFilePath = "/src/main/test/resources/case1/input.xml";
        String outputFilePath = "/src/main/test/resources/case1/input.xml";
        PersonsXMLModifer xmlModifer = new PersonsXMLModifer();
        assertThrows(IllegalArgumentException.class,
                () -> xmlModifer.joinNamesAndSurnames(inputFilePath, outputFilePath));
    }

    @Test
    public void joinNameAndSurnamesFormatingCase1() throws IOException {
        String inputFilePath = "src/test/resources/case1/input.xml";
        String outputFilePath = "src/test/resources/case1/output.xml";
        File correctFile = new File("src/test/resources/case1/correct.xml");
        // create new file with joined names and surnam
        PersonsXMLModifer xmlModifer = new PersonsXMLModifer();
        xmlModifer.joinNamesAndSurnames(inputFilePath, outputFilePath);
        File resultFile = new File(outputFilePath);
        String a = FileUtils.readFileToString(resultFile, "utf-8");
        String b = FileUtils.readFileToString(correctFile, "utf-8");
        assertEquals(a, b);
        //assertTrue(FileUtils.contentEquals(correctFile, resultFile));
    }
}
