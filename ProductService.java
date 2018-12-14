import java.util.*;

public abstract class ProductService {

    public static ArrayList<Product> showAllProduct() {
        return ProductDao.getAllProducts();
    }

    public static Product getProduct(String pId) {
        return ProductDao.getProduct(pId);
    }
    
    public static boolean addProduct(Product product){
        return ProductDao.addProduct(product);
    }
}