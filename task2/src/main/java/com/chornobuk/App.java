package com.chornobuk;

import java.io.IOException;

import com.chornobuk.datagenerator.DataGenerator;

public class App 
{
    public static void main( String[] args )
    {
        
    }

    public static void generateData(String path, int numberOfFiles, int amountPerFile) {
        DataGenerator dataGenerator = new DataGenerator();
        try {
            dataGenerator.generateRandomFines(path, numberOfFiles, amountPerFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
