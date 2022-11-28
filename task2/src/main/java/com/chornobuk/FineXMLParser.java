package com.chornobuk;

import java.io.IOException;

import com.chornobuk.entities.Fine;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class FineXMLParser {
    public Fine parseFine (String inputXML) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        Fine fine = xmlMapper.readValue(inputXML, Fine.class);
        return fine;
    }
}
