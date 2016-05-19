package edu.htc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
      	// write code here to read the sample data file into an array list
        // and then write it out to a new output file

        try {
            ArrayList<String> stuff = null;
            URL path = ClassLoader.getSystemResource("data/sampleData.txt");
            stuff = FileParser.parseFile(path.getFile()); //reads data from sampleData and stores into ArrayList
            System.out.println("Done with Import");

            String current = new java.io.File( "." ).getCanonicalPath(); //retrieves current working directory
            String outpath = current + "/myFinalOutput.txt"; //creates new file path to write out the ArrayList

            ListFileWriter.writeToFile(stuff, outpath); //writes data from stuff to new file

        }catch(FileNotFoundException e) {
            System.out.println("Could not find file");
        }catch(IOException e) {
            System.out.println("Error ocurred reading the file");
        }
    }
}