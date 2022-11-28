package com.chornobuk;

import java.io.IOException;

import com.chornobuk.entities.Person;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class PersonXMLParser {
    // todo write as a non static method
    public static String getPersonNameAndSurname(String XMLPerson) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        Person person = xmlMapper.readValue(XMLPerson, Person.class);
        return String.join(" ", new String[] { person.getName(), person.getSurname() }).trim();
    }
}
