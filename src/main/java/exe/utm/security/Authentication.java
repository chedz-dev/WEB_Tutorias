package exe.utm.security;

import exe.utm.dao.DBOperation;
import java.util.ArrayList;
import java.util.List;

public class Authentication {
    private List<String> userData;
    public Authentication () {
        userData = new ArrayList ();
    }
    public String authenticateUser (String user) {
        String result = "";
        
        if (user.equals("admin") || user.equals("staff")){
            result = user;
        } else {
            DBOperation dbop = new DBOperation ();
            userData = dbop.getUser(user);
            if (userData.size() > 0) {
                result = "profesor";
            }
        }
        return result;
    }
    public List<String> getUserData () {
        return userData;
    }
}
