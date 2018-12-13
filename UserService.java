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

    public static boolean changePhone(String username,String phone){
        if(UserDao.updatePhone(username,phone))
            return true;
        else
            return false;
    }

    public static boolean changeAddress(String username,String address){
        if(UserDao.updatePhone(username,address))
            return true;
        else
            return false;
    }

}
