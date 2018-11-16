import java.util.*;
public class MainpageService {
    public static ArrayList<Product> showAllProduct(){
        return ProductDao.getAllProducts();
    }

    public static Product getProduct(String pId) {
        return ProductDao.getProduct(pId);
    }
}
