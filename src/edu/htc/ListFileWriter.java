package edu.htc;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

/**
 * This class will read Strings from an ArrayList and write them
 * one per line to a file.
 */
public abstract class ListFileWriter {

    public static void writeToFile(ArrayList<String> list, String fileName) throws IOException {

        // Complete this method so that the test below in the main method is correct.
        /*BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        for(int i = 0; i < list.size(); i++){
            bw.write(list.get(i) + "\n");
        }
        bw.close();*/

        FileWriter fw = new FileWriter(fileName);
        for(int i = 0; i < list.size(); i++){
            fw.write(list.get(i) + "\r\n");
        }
        fw.close();


    }

    public static void main(String[] args) throws IOException{

        // Write File
        ArrayList<String> stuff = new ArrayList<String>();
        stuff.add("Hello.");
        stuff.add("");
        stuff.add("This is a test string.");

        String current = new java.io.File( "." ).getCanonicalPath();
        String path = current + "/myOutput.txt";
        try {
            ListFileWriter.writeToFile(stuff, path);
        } catch (IOException e){
            System.out.println("An error occurred writing the file.");
            System.out.println(e.getMessage());
        }

        //System.out.println(stuff);

        // Verify new file exists
        File newFile = new File(path);

        if (newFile.exists()) {
            System.out.println("The new file exists at " + path);
        } else {
            System.out.println("The new file does not exist.  It should be found at " + path);
        }

        if (newFile.length() == 0) {
            System.out.println("The file is empty.");
        }

        boolean matchesExpected = true;
        URL sample = ClassLoader.getSystemResource("data/sampleOutput.txt");
        try {
            if (FileCompareUtil.compare(sample.getFile(), path)){
                System.out.println("New file matches expected.");
            } else {
                System.out.println("File does not match expected.");
                System.out.println("Check file at " + path + " and compare to expected sampleOutput.");
            }

        } catch (IOException e) {
            System.out.println("An error occurred comparing the files.");
            System.out.println(e.getMessage());
        }
    }

}
