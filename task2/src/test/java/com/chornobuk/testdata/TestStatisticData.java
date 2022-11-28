package com.chornobuk.testdata;

import java.math.BigDecimal;
import java.time.Year;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.chornobuk.entities.Fine;
import com.chornobuk.entities.FineType;
import com.chornobuk.entities.Statistic;

public class TestStatisticData {
    public static Statistic getStatistic2020() {
        List<Fine> drunk = TestFinesData.getFinesBy2020().getValue();
        Map<FineType, BigDecimal> typeAmountMap = new LinkedHashMap<>();
        typeAmountMap.put(FineType.DRUNKDRIVING, new BigDecimal("60000"));
        typeAmountMap.put(FineType.PARKING, new BigDecimal("3000"));
        typeAmountMap.put(FineType.SPEEDING, new BigDecimal("840.50"));
        Year year = Year.of(2020);
        return new Statistic(year, typeAmountMap);
    }
}
