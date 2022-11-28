package com.chornobuk;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.chornobuk.entities.Fine;
import com.chornobuk.entities.Statistic;
import com.chornobuk.parsers.FinesFolderParser;

public class StatisticManager {
    public void generateStatisticByData(String pathToData, String resultFilePath) {
        FinesFolderParser finesFolderParser = new FinesFolderParser();
        StatisticFactory statisticFactory = new StatisticFactory();
        StatisticSerializer serializer = new StatisticSerializer();
        Map<String, List<Fine>> fileDataMap = finesFolderParser.readFinesFromFolder(pathToData);
        List<Statistic> statisticList = new LinkedList<>();
        
        for (Map.Entry<String, List<Fine>> f : fileDataMap.entrySet()) {
            statisticList.add(statisticFactory.build(f.getValue()));
        }
        try {
            serializer.SerializeToJSON(statisticList, resultFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
