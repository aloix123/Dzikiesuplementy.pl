package project.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Personalfilehandler {
    public  static List<String> getparameters(){
        File file = new File("clientparameters.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String adress= sc.next();
        String  number= sc.next();
        String surname= sc.next();
        String name= sc.next();
        System.out.println(adress+" "+name+" "+number+" "+surname);
        return Arrays.asList(adress, number, surname, name);
    }




}
