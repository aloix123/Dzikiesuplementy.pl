package project.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserFileHandler {
    public static String getUserName(){
        File file = new File("userparameters.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return sc.next();
    }
}
