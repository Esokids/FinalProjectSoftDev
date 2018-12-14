import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.*;

public class CartDao {
    static MongoClientURI uri = new MongoClientURI("mongodb://admin:password1@ds249503.mlab.com:49503/finalproject");
    static MongoClient client = new MongoClient(uri);
    static MongoDatabase db = client.getDatabase(uri.getDatabase());
    static MongoCollection<Document> col = db.getCollection("cart");
    
    static public boolean addCart(User user,Product product,int num){
        Product thisProduct = getProductCart(user, product);
        if(thisProduct == null){
            col.insertOne(new Document("username",user.getUsername()).append("pId", product.getId()).append("num", num));
            return true;
        }else
            return false;
    }
    
    static public ArrayList<Cart> getAllProductCart(User user){
        ArrayList<Cart> cart = new ArrayList<>();
        Document findUser = new Document("username",user.getUsername());
        MongoCursor<Document> cursor = col.find(findUser).iterator();
        while(cursor.hasNext()){
            Document doc = cursor.next();
            Product thisProduct = ProductDao.getProduct(doc.get("pId").toString());
            cart.add(new Cart(user,thisProduct,(int)doc.get("num")));
        }
        return cart;
    }
    
        static public Product getProductCart(User user,Product product){
        Product thisProduct = null;
        Document findProduct = new Document("username",user.getUsername()).append("pId", product.getId());
        MongoCursor<Document> cursor = col.find(findProduct).iterator();
        if(cursor.hasNext()){
            Document doc = cursor.next();
            thisProduct = ProductDao.getProduct(doc.get("pId").toString());
        }
        return thisProduct;
    }
}