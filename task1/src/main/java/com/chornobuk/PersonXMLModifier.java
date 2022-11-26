package com.chornobuk;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonXMLModifier {
    private static final String NAME_REGEX = "\\bname\\s*=\\s*\"[^\"]*\"";
    private static final String SURNAME_REGEX = "surname\\s*=\\s*\"[^\"]*\"";

    public static String joinNameAndSurname(String person) throws IOException {
        String nameAndSurname = PersonXMLParser.getPersonNameAndSurname(person);
        Matcher matcher = Pattern.compile(NAME_REGEX).matcher(person);

        String newName;
        if (matcher.find()) {
            newName = matcher.group();
        } else {
            throw new IllegalArgumentException();
        }
        
        newName = newName.replaceAll("\"[^\"]*\"", "\"" + nameAndSurname + "\"");
        return person.replaceAll(SURNAME_REGEX, "")
                .replaceAll(NAME_REGEX, newName);
    }
}
