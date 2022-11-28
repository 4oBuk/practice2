package com.chornobuk;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.chornobuk.entities.Statistic;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StatisticSerializer {
    public void SerializeToJSON(List<Statistic> statistic, String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), statistic);
    }
}
