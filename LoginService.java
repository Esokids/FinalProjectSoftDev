public class LoginService {

    public static boolean checkUsername(User user){
        User thisUser = null;
        thisUser = UserService.getUser(user.getUsername());
        if(thisUser == null)
            return false;
        else
            return  true;
    }

    public static boolean checkPassword(User user){
        User thisUser = null;
        thisUser = UserService.getUser(user.getUsername());
        if(thisUser.getPassword().equals(user.getPassword()))
            return true;
        else
            return false;
    }

}
