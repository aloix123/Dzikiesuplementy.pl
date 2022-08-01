package project.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainPageHandler {
    public  static  boolean checkIfFileClear(){
        File file = new File("userparameters.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        if(sc.hasNext()){
            return true;
        }
        else{
            return false;
        }

    }


}
