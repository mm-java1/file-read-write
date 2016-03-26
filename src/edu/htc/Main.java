package edu.htc;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        FileInputStream fileIn= null;

        // Read File
        System.out.println("Reading file...");
        ArrayList<String> stuff = new ArrayList<String>();
        try {
            URL path = ClassLoader.getSystemResource("data/sampleData.txt");
            if (path != null) {
                fileIn = new FileInputStream(path.getFile());
                stuff = FileParser.parseFile(path.getFile());
            }
        } catch (FileNotFoundException e){
            System.out.println("Could not find file!");
            System.out.println(e.getMessage());
        } catch (IOException ex){
            System.out.println("An error occurred reading the file.");
            System.out.println(ex.getMessage());
        }
        System.out.println("Print array contents");
        System.out.println(stuff);

        //print arraylist
        System.out.println("\nSave to file....");
        String current = new java.io.File( "." ).getCanonicalPath();
        String path = current + "\\src\\data\\myOutputNew.txt";
        try {
            ListFileWriter.writeToFile(stuff, path);
        } catch (IOException e){
            System.out.println("An error occurred writing the file.");
            System.out.println(e.getMessage());
        }

        System.out.println("Review file created/updated myOutputNew.txt");

    }
}
