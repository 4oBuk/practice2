package com.chornobuk;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import com.chornobuk.entities.Statistic;
import com.chornobuk.testdata.TestStatisticData;

public class StatisticManagerTest {
    
    @Test
    void testGenerateStatisticByData() throws IOException{
        String dataPath = "src/test/resources/years";
        String resultPath = "src/test/result.json";
        String correctStatisticPath = "src/test/correct.json";
        List<Statistic> statistic = List.of(TestStatisticData.getStatistic2020(), TestStatisticData.getStatistic2021());
        StatisticManager statisticManager = new StatisticManager();
        StatisticSerializer serializer = new StatisticSerializer();
        serializer.SerializeToJSON(statistic, correctStatisticPath);
        
        File result = new File(resultPath);
        File correct = new File(correctStatisticPath);

        statisticManager.generateStatisticByData(dataPath, resultPath);
        assertTrue(FileUtils.contentEquals(correct, result));
    }
}
