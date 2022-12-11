package com.chornobuk;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.chornobuk.datagenerator.DataGenerator;

public class MultithreadStatisticManagerTest {

    {
        DataGenerator dataGenerator = new DataGenerator();
        try {
            dataGenerator.generateRandomFines("data", 100, 10000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void compareProgramSpeed() {
        String dataPath = "data";
        String resultPath = "src/test/result.json";
        MultithreadStatisticManager statisticManager = new MultithreadStatisticManager();

        for (int i = 1; i <= 8; i *= 2) {
            long startTime = System.currentTimeMillis();
            statisticManager.generateStatisticByData(dataPath, resultPath, i);
            long endTime = System.currentTimeMillis();
            long durationInSeconds = (endTime - startTime) / 1000;
            System.out.printf("result for %d threads is %d s\n", i, durationInSeconds);
        }
    }
}
