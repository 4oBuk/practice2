package com.chornobuk.datagenerator;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.chornobuk.entities.Fine;
import com.chornobuk.entities.Fines;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class FinesXMLSerializer {

    public void serializeFines(List<Fine> fines, String path)
            throws StreamWriteException, DatabindException, IOException {
        XmlMapper xmlMapper = new XmlMapper();
        // @JacksonXmlElementWrapper(localname='myProperty')
        
        Fines f = new Fines(fines);
        xmlMapper.writer()
        .withRootName("fines")
        .writeValue(new File(path), f);
    }
}
