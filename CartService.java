import java.util.ArrayList;

public class CartService {
    public static ArrayList<Cart> getAllProduct(User user){
        return CartDao.getAllProductCart(user);
    }

    public static boolean addToCart(User user,Product product,int num){
        return CartDao.addCart(user,product,num);
    }
}
