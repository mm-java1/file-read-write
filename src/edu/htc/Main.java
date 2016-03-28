package edu.htc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException{
      	// write code here to read the sample data file into an array list
        // and then write it out to a new output file

        ArrayList<String> arrayList = new ArrayList<>();

        try{
            URL path = ClassLoader.getSystemResource("data/sampleData.txt");
            arrayList = FileParser.parseFile(path.getFile());
        }

        catch(FileNotFoundException f)
        {
            System.out.println("File not found");
        }

        catch(IOException e)
        {
            System.out.println("Error occurred.");
        }

        String current = new java.io.File(".").getCanonicalPath();
        String path = current + "/myOutput.txt";
        //String path = current + "\\src\\data\\myOutputNew.txt";

        try{
            ListFileWriter.writeToFile(arrayList, path);
        }

        catch(IOException e)
        {
            System.out.println("Writing Error");
        }

    }
}
