package com.chornobuk.datagenerator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.chornobuk.entities.Fine;
import com.chornobuk.entities.FineType;

public class FinesGenerator {
    private static List<String> firstnames = new ArrayList<>();
    private static List<String> lastnames = new ArrayList<>();
    private final static BigDecimal MIN_FINE = BigDecimal.valueOf(250L);
    private final static BigDecimal MAX_FINE = BigDecimal.valueOf(100000L);
    private final static long MIN_DATE_TIME = LocalDateTime.of(2010, 1, 1, 0, 0, 0).toEpochSecond(ZoneOffset.UTC);
    private final static long MAX_DATE_TIME = LocalDateTime.of(2021, 12, 31, 23, 59, 59).toEpochSecond(ZoneOffset.UTC);
    static {
        firstnames.add("Bohdan");
        firstnames.add("Olexiy");
        firstnames.add("Anna");
        firstnames.add("Bohdana");
        firstnames.add("Iryna");
        firstnames.add("Stepan");
        firstnames.add("Mykola");
        firstnames.add("Dmytro");
        firstnames.add("Klavia");
        firstnames.add("Victoria");

        lastnames.add("Shevchuk");
        lastnames.add("Bondarchuk");
        lastnames.add("Stefanchuk");
        lastnames.add("Taranenko");
        lastnames.add("Jons");
        lastnames.add("Veselko");
        lastnames.add("Franko");
        lastnames.add("Semko");
        lastnames.add("Pashchuk");
        lastnames.add("Kurashchuk");
    }
    public static List<Fine> generateFines(int amount) {
        List<Fine> fines = new ArrayList<>(amount);
        for(int i = 0; i < amount; i++) {
            fines.add(generateFine());
        }
        return fines;
    }

    public static Fine generateFine() {
        // generate random values
        Random random = new Random();
        int randomFirstnameIndex = random.nextInt(firstnames.size());
        int randomLastnameIndex = random.nextInt(lastnames.size());
        BigDecimal randomFineAmount = MIN_FINE.add(new BigDecimal(Math.random()).multiply(MAX_FINE.subtract(MIN_FINE)));
        randomFineAmount = randomFineAmount.setScale(2, RoundingMode.HALF_EVEN);
        FineType randomFineType = FineType.values()[random.nextInt(FineType.values().length)];
        
        // create a new fine with random values
        Fine fine = new Fine();
        fine.setFirstName(firstnames.get(randomFirstnameIndex));
        fine.setLastName(lastnames.get(randomLastnameIndex));
        fine.setFineAmount(randomFineAmount);
        fine.setType(randomFineType);
        fine.setDateTime(generateRandomDateTime());//add random value
        return fine;
    }

    private static LocalDateTime generateRandomDateTime() {
        long randomDateTime = ThreadLocalRandom.current().nextLong(MIN_DATE_TIME, MAX_DATE_TIME);
        return LocalDateTime.ofEpochSecond(randomDateTime, 0, ZoneOffset.UTC);
    }
}
