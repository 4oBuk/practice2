package com.chornobuk;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.Year;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.chornobuk.entities.Fine;
import com.chornobuk.entities.FineType;
import com.chornobuk.entities.Statistic;
import com.chornobuk.parsers.FinesXMLParserTest;

public class StatisticFactoryTest {

    @Test
    public void buildOneType() {
        List<Fine> drunk = TestFinesData.getDrunkFines().getValue();
        Map<FineType, BigDecimal> typeAmountMap = new HashMap<>();
        typeAmountMap.put(FineType.DRUNKDRIVING, new BigDecimal("60000"));
        Year year = Year.of(2020);
        StatisticFactory statisticFactory = new StatisticFactory();
        Statistic statistic = new Statistic(year, typeAmountMap);
        assertEquals(statistic, statisticFactory.build(drunk));
    }

    @Test
    public void buildSomeTypes() {
        // todo create one storage for all Fines
    }
}
