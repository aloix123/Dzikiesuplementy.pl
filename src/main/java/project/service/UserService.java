package project.service;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
                return true;

        }
        return  false;
    }
}
