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
        //File fileToProcess = new File(args[0]);

        String successRegex = "(.*?),200,OK,(.*?)";


        Pattern   compiledPattern = Pattern.compile(successRegex);


        File fileToProcess = new File("/Users/temp/jtl-error-remover/jtl-processor/C_500_T_600_P_100K_buyStocks.xml.jtl");

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileToProcess))) {
            try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileToProcess+"_"+"processed"))) {
                String line;
                while((line = fileReader.readLine()) != null) {
                    Matcher m1 = compiledPattern.matcher(line);
                    if (m1.find()) {
                        System.out.print(line + "\n");
                        fileWriter.write(line);
                        fileWriter.newLine();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
