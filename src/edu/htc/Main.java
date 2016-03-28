package edu.htc;

import java.io.IOException;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws IOException {
      	// write code here to read the sample data file into an array list
        // and then write it out to a new output file
        String strFilename = args[0];
        String current = new java.io.File( "." ).getCanonicalPath();
        String strPath = current + strFilename;

        ArrayList<String> filedata = new ArrayList<String>();

        try{
            filedata = FileParser.parseFile(strPath);
        }
        catch (IOException ex){
            System.out.println("I/O Error: Could not parse the file." + ex);
        }

        try{
            ListFileWriter.writeToFile(filedata,current+"\\src\\data\\cmauer69.txt");
        }
        catch (IOException ex){
            System.out.println("I/O Error: Could not parse the file." + ex);
        }

        System.out.println("File creation is complete!");


    }
}
