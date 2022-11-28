package com.chornobuk;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.chornobuk.entities.Fine;
import com.chornobuk.entities.FineType;

public class TestFinesData {

    private static List<Fine> getParkingFines() {
        return null;
    }

    private static List<Fine> getSpeedingFines() {
        List<Fine> fines = new ArrayList<>();
        fines.add(new Fine(
                LocalDateTime.of(2020, 5, 5, 15, 39, 3),
                "Ivan",
                "Ivanov",
                FineType.SPEEDING,
                new BigDecimal("340.0")));

        fines.add(new Fine(
                LocalDateTime.of(2020, 12, 31, 18, 0, 17),
                "Fred",
                "Alfred",
                FineType.SPEEDING,
                new BigDecimal("500.50")));
        return fines;
    }

    private static List<Fine> getDrunkDrivingFines() {
        List<Fine> fines = new ArrayList<>();
        fines.add(new Fine(
                LocalDateTime.of(2020, 5, 5, 21, 44, 17),
                "Boris",
                "Brown",
                FineType.DRUNKDRIVING,
                new BigDecimal("10000")));

        fines.add(new Fine(
                LocalDateTime.of(2020, 3, 8, 22, 3, 30),
                "Boris",
                "Brown",
                FineType.DRUNKDRIVING,
                new BigDecimal("20000")));

        fines.add(new Fine(
                LocalDateTime.of(2020, 12, 31, 23, 0, 25),
                "Boris",
                "Brown",
                FineType.DRUNKDRIVING,
                new BigDecimal("30000")));
        return fines;
    }

    public static Map.Entry<String, List<Fine>> getDrunkFines() {
        return Map.entry("drunk.xml", getDrunkDrivingFines());
    }

    public static Map.Entry<String, List<Fine>> getSpedingFines() {
        return Map.entry("fines.xml", getSpeedingFines());
    }
}
