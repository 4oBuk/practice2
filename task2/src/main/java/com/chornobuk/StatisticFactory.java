package com.chornobuk;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.chornobuk.entities.Fine;
import com.chornobuk.entities.FineType;
import com.chornobuk.entities.Statistic;

public class StatisticFactory {
    public Statistic build(List<Fine> fines) {
        Map<FineType, BigDecimal> typeTotalAmountMap = new HashMap<>();
        typeTotalAmountMap = fines.stream()
                .collect(
                        Collectors.toMap(Fine::getType, Fine::getFineAmount,
                                (e1, e2) -> e1.add(e2),
                                LinkedHashMap::new));

        Map<FineType, BigDecimal> descendingSortedMap = typeTotalAmountMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                        Collectors.toMap(Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1.add(e2),
                                LinkedHashMap::new));

        int year = fines.get(0).getDateTime().getYear();
        return new Statistic(year, descendingSortedMap);
    }
}
