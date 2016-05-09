package edu.htc;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write code here to read the sample data file into an array list
        // and then write it out to a new output file
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Sam\\Documents\\GitHub\\file-read-write\\src\\data\\sampleData.txt"));
            ArrayList<String> output = new ArrayList<String>();
            String str;

            try {
                while ((str = br.readLine()) != null) {
                    output.add(str);
                }
            } catch (IOException iox) {
                System.out.println("IOException");
            }

            String path = "C:\\Users\\Sam\\Documents\\GitHub\\file-read-write\\output.txt";
            try {
                ListFileWriter.writeToFile(output, path);
            }catch (IOException ioex){
                System.out.println("LFW IOEX");
            }
        } catch (FileNotFoundException fnfex) {
            System.out.println("File not found.");
        }


    }
}

