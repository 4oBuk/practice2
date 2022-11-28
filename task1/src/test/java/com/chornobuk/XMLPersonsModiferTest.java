package com.chornobuk;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

public class XMLPersonsModiferTest {

    @Test
    public void joinNamesAndSurnamesSamePathes() {
        String inputFilePath = "/src/main/test/resources/case1/input.xml";
        String outputFilePath = "/src/main/test/resources/case1/input.xml";
        XMLPersonsModifier xmlModifer = new XMLPersonsModifier();
        assertThrows(IllegalArgumentException.class,
                () -> xmlModifer.joinNamesAndSurnames(inputFilePath, outputFilePath));
    }

    @Test
    public void joinNameAndSurnamesFormatingCase1() throws IOException {
        String inputFilePath = "src/test/resources/case1/input.xml";
        String outputFilePath = "src/test/resources/case1/output.xml";
        String correctFilePath = "src/test/resources/case1/correct.xml";

        // create new file with joined names and surnam
        XMLPersonsModifier xmlModifer = new XMLPersonsModifier();
        xmlModifer.joinNamesAndSurnames(inputFilePath, outputFilePath);
        assertTrue(compareFiles(correctFilePath, outputFilePath));
    }

    @Test
    public void joinNameAndSurnamesFormatingCase2() throws IOException {
        String inputFilePath = "src/test/resources/case2/input.xml";
        String outputFilePath = "src/test/resources/case2/output.xml";
        String correctFilePath = "src/test/resources/case2/correct.xml";
        // create new file with joined names and surnam
        XMLPersonsModifier xmlModifer = new XMLPersonsModifier();
        xmlModifer.joinNamesAndSurnames(inputFilePath, outputFilePath);
        assertTrue(compareFiles(correctFilePath, outputFilePath));
    }

    @Test
    public void joinNameAndSurnamesFormatingCase3() throws IOException {
        String inputFilePath = "src/test/resources/case3/input.xml";
        String outputFilePath = "src/test/resources/case3/output.xml";
        String correctFilePath = "src/test/resources/case3/correct.xml";
        // create new file with joined names and surnam
        XMLPersonsModifier xmlModifer = new XMLPersonsModifier();
        xmlModifer.joinNamesAndSurnames(inputFilePath, outputFilePath);
        assertTrue(compareFiles(correctFilePath, outputFilePath));
    }


    @Test
    public void joinNamesAndSurnamesOneLineInput() throws IOException{
        String inputFilePath = "src/test/resources/case4/input.xml";
        String outputFilePath = "src/test/resources/case4/output.xml";
        String correctFilePath = "src/test/resources/case4/correct.xml";
        // create new file with joined names and surnam
        XMLPersonsModifier xmlModifer = new XMLPersonsModifier();
        xmlModifer.joinNamesAndSurnames(inputFilePath, outputFilePath);
        assertTrue(compareFiles(correctFilePath, outputFilePath));
    }

    private boolean compareFiles(String f1Path, String f2Path) throws IOException{
        File f1 = new File(f1Path);
        File f2 = new File(f2Path);
        return FileUtils.contentEquals(f1, f2);
    }
}
