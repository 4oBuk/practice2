package com.chornobuk.testdata;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.chornobuk.entities.Fine;
import com.chornobuk.entities.FineType;

public class TestFinesData {

    public static List<Fine> parkingFinesList() {
        List<Fine> fines = new ArrayList<>();
        fines.add(new Fine(
                LocalDateTime.of(2020, 10, 10, 10, 10, 10),
                "Monica",
                "Grey",
                FineType.PARKING,
                new BigDecimal("1000")));

        fines.add(new Fine(
                LocalDateTime.of(2020, 11, 11, 11, 11, 11),
                "Lex",
                "Skott",
                FineType.PARKING,
                new BigDecimal("1000")));

        fines.add(new Fine(
                LocalDateTime.of(2020, 1, 1, 1, 1, 1),
                "Wallter",
                "While",
                FineType.PARKING,
                new BigDecimal("1000")));
        return fines;
    }

    public static List<Fine> speedingFinesList() {
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

    public static List<Fine> drunkDrivingFinesList() {
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
        return Map.entry("drunk.xml", drunkDrivingFinesList());
    }

    public static Map.Entry<String, List<Fine>> getSpedingFines() {
        return Map.entry("fines.xml", speedingFinesList());
    }

    public static Map.Entry<String, List<Fine>> getParkingFines() {
        return Map.entry("parking.xml", parkingFinesList());
    }

    public static Map.Entry<String, List<Fine>> getFinesBy2020() {
        List<Fine> allFines = new ArrayList<>();
        allFines.addAll(speedingFinesList());
        allFines.addAll(parkingFinesList());
        allFines.addAll(drunkDrivingFinesList());
        return Map.entry("2020.xml", allFines);

    }
}
