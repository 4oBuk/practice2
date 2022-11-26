package com.chornobuk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;

public class PersonXMLParserTest {

    @Test
    public void getPersonNameAndSurname() throws IOException {
        String xml = """
                <person name="Іван" surname="Котляревський" birthDate="09.09.1769" />
                    """;
        String result = "Іван Котляревський";
        assertEquals(result, PersonXMLParser.getPersonNameAndSurname(xml));
    }

    @Test
    public void getPersonNameAndSurnameMultiLinePerson() throws IOException {
        String xml = """
                <person name="Kaneki"
                surname="Ken"
                birthDate="21.01.2022" />
                    """;
        String result = "Kaneki Ken";
        assertEquals(result, PersonXMLParser.getPersonNameAndSurname(xml));
    }

    @Test
    public void getPersonNameAndSurnameNullXml() throws IOException {
        String xml = null;
        assertThrows(IllegalArgumentException.class,() -> PersonXMLParser.getPersonNameAndSurname(xml));
    }

    @Test
    public void getPersonNameAndSurnameEmptyXml() throws IOException {
        String xml = "";
        assertThrows(StreamReadException.class, () -> PersonXMLParser.getPersonNameAndSurname(xml));
    }

    @Test
    public void getPersonNameAndSurnameEmptyValues() throws IOException {
        String xml = """
                <person name=""
                surname=""
                birthDate="21.01.2022" />
                    """;
        String result = "";
        assertEquals(result, PersonXMLParser.getPersonNameAndSurname(xml));
    }

    @Test
    public void getPersonNameAndSurnameEmptySurname() throws IOException {
        String xml = """
                <person name="Bob"
                surname=""
                birthDate="21.01.2022" />
                    """;
        String result = "Bob";
        assertEquals(result, PersonXMLParser.getPersonNameAndSurname(xml));
    }
    @Test
    public void getPersonNameAndSurnameEmptyName() throws IOException {
        String xml = """
                <person name=""
                surname="Johnsoniuk"
                birthDate="21.01.2022" />
                    """;
        String result = "Johnsoniuk";
        assertEquals(result, PersonXMLParser.getPersonNameAndSurname(xml));
    }
}
