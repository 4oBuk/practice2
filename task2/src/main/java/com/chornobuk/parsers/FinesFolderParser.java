package com.chornobuk.parsers;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chornobuk.entities.Fine;

public class FinesFolderParser {
    public Map<String, List<Fine>> readFinesFromFolder(String path) {
        File finesDirectory = new File(path);
        Map<String, List<Fine>> fileFineMap = new HashMap<>();
        FinesXMLParser finesXMLParser = new FinesXMLParser();
        if(finesDirectory.isDirectory()) {
            File[] files = finesDirectory.listFiles();
            for(File file : files) {
                Map.Entry<String, List<Fine>> entry = finesXMLParser.parseFromFile(file);
                fileFineMap.put(entry.getKey(), entry.getValue());
            }
            return fileFineMap;
        }
        throw new IllegalArgumentException("path is not a folder");
    }
}
