package edu.htc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static ArrayList<String> dataFromFile = new ArrayList<String>();
    public static void main(String[] args) {
      	// write code here to read the sample data file into an array list
        // and then write it out to a new output file


        try {
            URL path = ClassLoader.getSystemResource("data/sampleData.txt");
            dataFromFile = FileParser.parseFile(path.getFile());
        } catch (FileNotFoundException e){
            System.out.println("Could not find file!");
            System.out.println(e.getMessage());
        } catch (IOException e){
            System.out.println("An error occurred reading the file.");
            System.out.println(e.getMessage());
        }



        URL path = ClassLoader.getSystemResource("data/Joes_Output.txt");
        try {
            ListFileWriter.writeToFile(dataFromFile, path.getFile());
        } catch (IOException e){
            System.out.println("An error occurred writing the file.");
            System.out.println(e.getMessage());
        }

    }

}
