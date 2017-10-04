package com.malithj.jtlprocessor;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;

/**
 * Created by temp on 10/2/17.
 */
public class JtlErrorRemover {
    public static void main( String[] args )
    {
        File fileToProcess = new File(args[1]);
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileToProcess))) {
            try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileToProcess+"_"+"processed"))) {
                String line = fileReader.readLine();
                while(line != null) {
                    fileWriter.write(line);
                    fileWriter.newLine();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
