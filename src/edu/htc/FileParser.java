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
    public static FileInputStream fileIn = null;

    public static ArrayList<String> parseFile(String fileName) throws IOException {

        ArrayList<String> fileArray = new ArrayList<>();
                int i;

                        BufferedReader fReader = new BufferedReader(new FileReader(fileName));

                        while (true) {
                        String line = fReader.readLine();
                        if (line == null) {
                                break;
                            }
                        line.trim();
                                if (!line.equals("")) {
                                fileArray.add(line);
                            }
                    }
                        fReader.close();

                return fileArray;

    }

    public static void main(String[] args){

        // Read File
        ArrayList<String> stuff = null;
        try {
            URL path = ClassLoader.getSystemResource("data/sampleData.txt");
            if (path != null) {
                fileIn = new FileInputStream(path.getFile());
                stuff = FileParser.parseFile(path.getFile());
            }
            stuff = FileParser.parseFile(path.getFile());
        } catch (FileNotFoundException e){
            System.out.println("Could not find file!");
            System.out.println(e.getMessage());
        } catch (IOException e){
            System.out.println("An error occurred reading the file.");
            System.out.println(e.getMessage());
        }

        System.out.println(stuff);

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
