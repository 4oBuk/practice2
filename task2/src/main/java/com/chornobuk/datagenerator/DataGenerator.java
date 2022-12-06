package com.chornobuk.datagenerator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DataGenerator {
    // generate numberOfFiles files with random fines amountPerFile in each one in pathToFolder
    public void generateRandomFines(String path,int numberOfFiles, int amountPerFile)  throws IOException{
        File destinationFile = new File(path);
        Path pathToFolder = Path.of(path);
        if(Files.exists(pathToFolder) && !destinationFile.isDirectory()) {
            throw new IllegalArgumentException("Path have to be a folder");
        }
        if(!Files.exists(pathToFolder)) {
            // if folder doesn't exist create a new one
            Files.createDirectories(pathToFolder);
        }
        FinesXMLSerializer finesXMLSerializer = new FinesXMLSerializer();
        for(int i = 1; i<= numberOfFiles; i++) {
            String pathToFile = destinationFile.getPath() + "/" + "file" + i + ".xml";
            finesXMLSerializer.serializeFines(FinesGenerator.generateFines(amountPerFile), pathToFile);
        }
    }
}
