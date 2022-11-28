package com.chornobuk;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class XMLPersonModifierTest {

    @Test
    public void joinNameAndSurname() throws IOException{
        String xml = """
                <person name="Іван" surname="Котляревський" birthDate="09.09.1769" />
                    """;
        String result = """
            <person name="Іван Котляревський"  birthDate="09.09.1769" />
                """;
        assertEquals(result, XMLPersonModifier.joinNameAndSurname(xml));
    }

    @Test
    public void joinNameAndSurnameDifferentFormatting1() throws IOException{
        String xml = """
                <person
                name="Іван"
                surname="Котляревський"
                birthDate="09.09.1769" />
                    """;
        String result = """
            <person
            name="Іван Котляревський"
            
            birthDate="09.09.1769" />
                """;
        assertEquals(result, XMLPersonModifier.joinNameAndSurname(xml));
    }

    @Test
    public void joinNameAndSurnameDifferentFormatting2() throws IOException{
        String xml = """
                <person
                
                
                name="Іван"
                
                
                
                surname="Котляревський"
                
                
                birthDate="09.09.1769" />
                    """;
        String result = """
            <person


            name="Іван Котляревський"
            




            
            birthDate="09.09.1769" />
                """;
        assertEquals(result, XMLPersonModifier.joinNameAndSurname(xml));
    }
    @Test
    public void joinNameAndSurnameDifferentFormatting3() throws IOException{
        String xml = """
                <person 
                                name="Іван"
                surname="Котляревський" birthDate="09.09.1769" 
                
                />
                    """;
        String result = """
                <person 
                                name="Іван Котляревський"
                 birthDate="09.09.1769" 
                 
                />
                """;
        assertEquals(result, XMLPersonModifier.joinNameAndSurname(xml));
    }


    @Test
    public void joinNameAndSurnameDifferentFormatting4() throws IOException{
        String xml = """
                <person
                name= "Іван"
                surname = "Котляревський"
                birthDate="09.09.1769" />
                    """;
        String result = """
            <person
            name= "Іван Котляревський"
            
            birthDate="09.09.1769" />
                """;
        assertEquals(result, XMLPersonModifier.joinNameAndSurname(xml));
    }

    @Test
    public void joinNameAndSurnameDifferentFormatting5() throws IOException{
        String xml = """
                <person
                name     = "Іван"
                surname = "Котляревський"
                birthDate="09.09.1769" />
                    """;
        String result = """
            <person
            name     = "Іван Котляревський"
            
            birthDate="09.09.1769" />
                """;
        assertEquals(result, XMLPersonModifier.joinNameAndSurname(xml));
    }

    @Test
    public void joinNameAndSurnameDifferentFormatting6() throws IOException{
        String xml = """
                <person name="Іван" surname="Котляревський" birthDate="09.09.1769"/>
                    """;
        String result = """
            <person name="Іван Котляревський"  birthDate="09.09.1769"/>
                """;
        assertEquals(result, XMLPersonModifier.joinNameAndSurname(xml));
    }
}
