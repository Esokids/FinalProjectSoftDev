public class RegisterService {
   
    public static boolean addUser(User user){
        if(UserDao.addUser(user))
            return true;
        else
            return false;
    }
    public static boolean checkLengthUser(String username){
           if(username.length()>4){
               return true;
           }else{
               return false;
           }
    }
    
    public static boolean checkLengthPass(String password){
            if(password.length()>5){
                return true;
            }else{
                return false;
            }
    }
    
    public static boolean checkPasswordComfirm(String password,String passcomfirm){
            if(password.equals(passcomfirm)){
                return true;
            }else{
                return false;
            }
    }
}