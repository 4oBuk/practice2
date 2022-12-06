package com.chornobuk.entities;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Fines {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "fine")
    private List<Fine> fines;

    public List<Fine> getFines() {
        return fines;
    }

    public void setFines(List<Fine> fines) {
        this.fines = fines;
    }

    public Fines(List<Fine> fines) {
        this.fines = fines;
    }
    
}
