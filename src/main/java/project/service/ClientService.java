package project.service;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.model.Client;
import project.model.User;
import project.repository.ClientRepository;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


@Service
public class ClientService {
    @Autowired
    SessionFactory factory;
    @Autowired
    private ClientRepository repository;
    public int  getclientid() throws FileNotFoundException {
        File file = new File("clientparameters.txt");
        Scanner sc = null;
        sc = new Scanner(file);
        Session session = factory.openSession();
        sc.next();
        sc.next();
        String surnamename=sc.next();
        String name=sc.next();
        String sqlQuery="SELECT ID FROM CLIENT  WHERE  NAME='"+name+"' and Surname='"+surnamename+"'";
        SQLQuery query = session.createSQLQuery(sqlQuery);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List results = query.list();
        for(Object object : results) {
            Map row = (Map) object;
            return Integer.parseInt(String.valueOf(row.get("ID")));
        }
        return  0;

    }
    public void saveClient(Client client) {
        repository.save(client);
    }

    public Client getById(long id) {
        return repository.getById(id);
    }

    public void deleteClient(long id) {
        repository.deleteById(id);

    }
    public boolean isClientFieldNull(Client client, User user){
        System.out.println(client.toString());
        return (client.getNumber() == "")  ||(client.getSurname() == "")  ||(client.getName() == "")  ||(client.getAdress() == "")  ||(user.getPassword() == "")  ||(user.getUsername() == "");
    }

    public void setuserparameters() throws FileNotFoundException, IOException {
        File file = new File("userparameters.txt");
        Scanner sc = null;
        sc = new Scanner(file);
        Session session = factory.openSession();
        String sql = "SELECT adress,name,number,surname FROM CLIENT where userid=(SELECT ID FROM USER WHERE username='"+sc.next()+"')";
        SQLQuery query = session.createSQLQuery(sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List results = query.list();
        System.out.println(results);
        File clientfile = new File("clientparameters.txt");
        FileWriter fileWriter= null;
        fileWriter = new FileWriter(clientfile,false);
        PrintWriter printWriter=new PrintWriter(fileWriter);
        for(Object object : results) {
            Map row = (Map)object;
            System.out.println(row);
            printWriter.println(row.get("ADRESS"));
            printWriter.println(row.get("NUMBER"));
            printWriter.println(row.get("SURNAME"));
            printWriter.println(row.get("NAME"));
        }

        printWriter.close();
    }








}

