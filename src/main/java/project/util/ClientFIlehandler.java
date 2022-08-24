package project.util;

import project.model.User;

import java.io.*;

public class ClientFIlehandler  implements Filehandler{

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

    @Override
    public void clearfile() {
        File file = new File("clientparameters.txt");
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

