package com.chornobuk;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.chornobuk.entities.Fine;
import com.chornobuk.testdata.TestFinesData;
import com.chornobuk.testdata.TestStatisticData;

public class StatisticFactoryTest {

    @Test
    public void buildOneType() {
        List<Fine> drunk = TestFinesData.getFinesBy2020().getValue();
        StatisticFactory statisticFactory = new StatisticFactory();
        assertEquals(TestStatisticData.getStatistic2020(), statisticFactory.build(drunk));
    }
}
