import java.util.ArrayList;

public class OrderService {
    public static void addOrder(ArrayList<Cart> cart){
        OrderDao.addOrder(cart);
    }

    public static ArrayList<Order> getOrder(User user) {
        return OrderDao.getOrder(user);
    }
}
