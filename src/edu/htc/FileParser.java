package edu.htc;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

/**
 * This class will read sentences from a file and store them in an ArrayList.
 * The file must have one sentence per line.
 *
 * Punctuation at the end of the sentence will not be removed.
 */
public abstract class FileParser {

    public static ArrayList<String> parseFile(String fileName) throws IOException {

        // Complete this method so that the test below in the main method is correct.
        ArrayList<String> strReturn = new ArrayList<>();
        boolean blnExit = false;

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        try {
            while (!blnExit) {
                String line = reader.readLine();
                if (line.trim().length() != 0) {
                    strReturn.add(line);
                    System.out.println(line);
                    blnExit = false;
                }
                else {
                    if (line == null){
                        blnExit = true;
                    }
                }
            }
        } finally {
            reader.close();
            return strReturn;
        }
    }

    public static void main(String[] args){

        // Read File
        ArrayList<String> stuff = null;
        try {
            URL path = ClassLoader.getSystemResource("data/sampleData.txt");
            stuff = FileParser.parseFile(path.getFile());
        } catch (FileNotFoundException e){
            System.out.println("Could not find file!");
            System.out.println(e.getMessage());
        } catch (IOException e){
            System.out.println("An error occurred reading the file.");
            System.out.println(e.getMessage());
        }

        //System.out.println(stuff);

        // Verify array list
        if (stuff.size() == 6){
            System.out.println("The array list correctly contains 6 items.");
        } else {
            System.out.println("The array list should contain 6 items but contains " + stuff.size());
            System.out.println("Make sure you are not adding any empty sentences.");
        }

        // Verify sentences have been trimmed
        boolean allTrimmed = true;
        for (String str : stuff) {
            if (!str.equals(str.trim())) {
                allTrimmed = false;
            }
        }

        if (allTrimmed) {
            System.out.println("The sentences have been correctly trimmed before adding to the array list.");
        } else {
            System.out.println("The sentences should be trimmed before adding to the array list.");
        }
    }

}
