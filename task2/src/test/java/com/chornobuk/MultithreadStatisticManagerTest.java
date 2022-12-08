package com.chornobuk;

import org.junit.jupiter.api.Test;

public class MultithreadStatisticManagerTest {

    {
        App.generateData("data", 100, 10000);
    }

    @Test
    public void compareProgramSpeed() {
        String dataPath = "data";
        String resultPath = "src/test/result.json";
        MultithreadStatisticManager statisticManager = new MultithreadStatisticManager();

        for (int i = 2; i <= 8; i *= 2) {
            long startTime = System.currentTimeMillis();
            statisticManager.generateStatisticByData(dataPath, resultPath, i);
            long endTime = System.currentTimeMillis();
            long durationInSeconds = (endTime - startTime) / 1000;
            System.out.printf("result for %d threads is %d s\n", i, durationInSeconds);
        }
    }
}
