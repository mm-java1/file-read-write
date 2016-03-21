package edu.htc;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by marymosman on 3/21/16.
 */
public class FileCompareUtil {

    public static boolean compare(String path1, String path2) throws IOException {

        boolean same = true;
        try (FileInputStream f1 = new FileInputStream(path1);
                 FileInputStream f2 = new FileInputStream(path2)) {

            int first, second;
            do {
                first = f1.read();
                second = f2.read();
                if (first != second) {
                    same = false;
                    break;
                }
            } while (first != -1 && second != -1);

            if (first != second){
                same = false;
            }
        }
        return same;

    }
}
