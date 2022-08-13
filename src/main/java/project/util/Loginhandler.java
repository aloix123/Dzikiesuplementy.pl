package project.util;

import project.model.User;

import java.io.*;

public class Loginhandler {

    public static void addUserToText(User user){
        String username= user.getUsername();
        String password= user.getPassword();


        ////////////////////////////////will be finished soon////////////////////////////////
        String fileName="userparameters.txt";
        File file=new File(fileName);
        FileWriter fileWriter= null;
        try {
            fileWriter = new FileWriter(file,false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        PrintWriter printWriter=new PrintWriter(fileWriter);
        printWriter.println(username);
        printWriter.println(password);

        printWriter.close();


    }
    public static void clearfile(){
        File file = new File("userparameters.txt");
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        writer.print("");
        writer.close();

    }
}
