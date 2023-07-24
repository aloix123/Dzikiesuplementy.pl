package project.service;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.model.Client;
import project.model.User;
import project.repository.UserREpository;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    SessionFactory factory;
    @Autowired
    private UserREpository userREpository;
    public void saveuser(User user){
        userREpository.save(user);
    }
    public User getById(long id){
        return userREpository.getById(id);
    }
    public boolean isFieldsNullInUser(User user){
        if( user.getUsername().isEmpty() & user.getPassword().isEmpty() ){
            return false;

        }
        return true;
    }
    public boolean isTHeSameParametersInData( User user){

        Session session = factory.openSession();
        Transaction transaction=session.beginTransaction();
        String sql = "SELECT * FROM USER ";
        transaction.commit();
        List<User> clientlist=session.createQuery("SELECT a FROM  User a", User.class).getResultList();
        session.close();
        System.out.println(clientlist);
        for( User cl:clientlist){
            if (user.getUsername().equals(cl.getUsername() ) ){
                return false;
            }
        }
        return true;
    }

    public boolean checkIfUserInData(User user){
        Session session=factory.openSession();


        String sql = "SELECT username,password FROM User";
        SQLQuery query = session.createSQLQuery(sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List results = query.list();
        List logginglist= List.of(new String[]{user.getUsername(), user.getPassword()});
        int passwordindex=1;
        int usernameindex=0;
        for(Object object : results) {
            Map row = (Map)object;
            if (row.get("PASSWORD").equals(logginglist.get(passwordindex))& row.get("USERNAME").equals(logginglist.get(usernameindex)))
                return  true;

        }
        return  false;
    }
}

