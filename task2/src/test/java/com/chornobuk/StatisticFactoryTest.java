package com.chornobuk;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.Year;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.chornobuk.entities.Fine;
import com.chornobuk.entities.FineType;
import com.chornobuk.entities.Statistic;

public class StatisticFactoryTest {

    @Test
    public void buildOneType() {
        List<Fine> drunk = TestFinesData.getFinesBy2020().getValue();
        Map<FineType, BigDecimal> typeAmountMap = new LinkedHashMap<>();
        typeAmountMap.put(FineType.DRUNKDRIVING, new BigDecimal("60000"));
        typeAmountMap.put(FineType.PARKING, new BigDecimal("3000"));
        typeAmountMap.put(FineType.SPEEDING, new BigDecimal("840.50"));
        Year year = Year.of(2020);
        StatisticFactory statisticFactory = new StatisticFactory();
        Statistic statistic = new Statistic(year, typeAmountMap);
        assertEquals(statistic, statisticFactory.build(drunk));
    }
}
