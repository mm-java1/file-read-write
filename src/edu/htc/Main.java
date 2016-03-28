package edu.htc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.net.URL;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
      	// write code here to read the sample data file into an array list
        // and then write it out to a new output file

        //Reading the file
        ArrayList<String> data = null;
        try{
            URL fpath = ClassLoader.getSystemResource("data/sampleData.txt");
            data = FileParser.parseFile(fpath.getFile());
            System.out.println("Reading the content from sampleData.txt file.");
            System.out.println(data);
        }catch (FileNotFoundException exc){
            System.out.println(exc.getMessage());
        }catch (IOException exc){
            System.out.println("Error reading file.");
            System.out.println(exc.getMessage());
        }


        //Writing the file
        String current = new java.io.File(".").getCanonicalPath();
        String newOutputData = current + "/myNewOutput.txt";
        try{
            ListFileWriter.writeToFile(data,newOutputData);
            System.out.println();
            System.out.println("The data from simpleData.txt is successfully copied to new file: myNewOutput.txt");
        }catch(IOException exc){
            System.out.println("Error writing file.");
            System.out.println(exc.getMessage());
        }
    }
}
