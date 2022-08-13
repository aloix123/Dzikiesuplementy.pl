package project.util;

import project.model.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ClientFIlehandler {

    public static void addClientToText(User user){
        String username= user.getUsername();
        ////////////////////////////////will be finished soon////////////////////////////////
        String fileName="clientparameters.txt";
        File file=new File(fileName);
        FileWriter fileWriter= null;
        try {
            fileWriter = new FileWriter(file,false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        PrintWriter printWriter=new PrintWriter(fileWriter);
        printWriter.println(username);

        printWriter.close();


    }
}
