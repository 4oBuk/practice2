package com.chornobuk;

import java.io.IOException;

import com.chornobuk.datagenerator.DataGenerator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DataGenerator dataGenerator = new DataGenerator();
        try {
            dataGenerator.generateRandomFines("data", 11, 1000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
