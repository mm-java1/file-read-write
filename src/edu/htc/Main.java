package edu.htc;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
      	FileInputStream fileIn= null;

        System.out.println("Currently reading the file...");
        ArrayList<String> nFile = new ArrayList<String>();
        try {
            URL uPath = ClassLoader.getSystemResource("data/sampleData.txt");
            if (uPath != null) {
                fileIn = new FileInputStream(uPath.getFile());
                nFile = FileParser.parseFile(uPath.getFile());
            }
        }catch (FileNotFoundException e){
            System.out.println("Error, file could not be found");
            System.out.println(e.getMessage());
        } catch (IOException ex){
            System.out.println("Error, not able to read the file");
            System.out.println(ex.getMessage());
        }
        System.out.println("Printing out the file");
        System.out.println(nFile);

        System.out.println("\nSave to file......");
        String curPth = new java.io.File(".").getCanonicalPath();
        String Pth =curPth + "\\src\\data\\myOutputNew.txt";
        try{
            ListFileWriter.writeToFile(nFile, Pth);
        } catch (IOException e){
            System.out.println("Error, unable to write the file.");
            System.out.println(e.getMessage());
        }

        System.out.println("View new file myOutputNew.txt");
    }
}
