package edu.htc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        //Reading the file

        ArrayList<String> newArray = new ArrayList<>();

        try {
            URL path = ClassLoader.getSystemResource("data/sampleData.txt");
            newArray = FileParser.parseFile(path.getFile());
        } catch (FileNotFoundException e){
            System.out.println("Could not find the file!");
            System.out.println(e.getMessage());
        } catch (IOException e){
            System.out.println("An error occurred reading the file.");
            System.out.println(e.getMessage());
        }

        //Checking the Array
        System.out.println(newArray);

        //Writing the file

        String current = new java.io.File( "." ).getCanonicalPath();
        String path = current + "/myOutput.txt";
        try {
            ListFileWriter.writeToFile(newArray, path);
        } catch (IOException e){
            System.out.println("An error occurred writing the file.");
            System.out.println(e.getMessage());
        }
    }
}
