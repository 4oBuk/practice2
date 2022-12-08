package com.chornobuk.parsers;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.chornobuk.entities.Fine;

public class MultithreadFinesFolderParser {
    public Map<String, List<Fine>> readFinesFromFolder(String path, int numberOfThtreads) {
        File finesDirectory = new File(path);
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThtreads);
        Map<String, List<Fine>> fileFineMap = new HashMap<>();
        FinesXMLParser finesXMLParser = new FinesXMLParser();
        if (finesDirectory.isDirectory()) {
            File[] files = finesDirectory.listFiles();
            for (File file : files) {
                CompletableFuture.supplyAsync(() -> finesXMLParser.parseFromFile(file), executor)
                        .thenAccept(entry -> fileFineMap.put(entry.getKey(), entry.getValue()));

            }
            try {
                executor.shutdown();
                executor.awaitTermination(5, TimeUnit.MINUTES);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return fileFineMap;
        }
        throw new IllegalArgumentException("path is not a folder");
    }
}
