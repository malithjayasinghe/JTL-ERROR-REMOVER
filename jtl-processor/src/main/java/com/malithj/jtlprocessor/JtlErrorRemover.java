package com.malithj.jtlprocessor;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by temp on 10/2/17.
 */
public class JtlErrorRemover {
    public static void main( String[] args )
    {
        File fileToProcess = new File(args[0]);
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileToProcess))) {
            try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileToProcess+"_"+"processed"))) {
                String line;
                while((line = fileReader.readLine()) != null) {
                    if(line.contains("OK")) {
                        fileWriter.write(line);
                        fileWriter.newLine();
                    }
                }
            }
            System.out.println("done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
