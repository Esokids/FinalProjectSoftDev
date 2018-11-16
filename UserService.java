import java.util.ArrayList;

public class UserService {
    public static User getUser(String username) {
        return UserDao.getUser(username);
    }

    public static boolean addUser(String username, String password){
        if(UserDao.addUser(username,password))
            return true;
        else
            return false;
    }

}
