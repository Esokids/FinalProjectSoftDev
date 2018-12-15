import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

public class OrderDao {
    static MongoClientURI uri = new MongoClientURI("mongodb://admin:password1@ds249503.mlab.com:49503/finalproject");
    static MongoClient client = new MongoClient(uri);
    static MongoDatabase db = client.getDatabase(uri.getDatabase());
    static MongoCollection<Document> col = db.getCollection("order");

    public static void addOrder( ArrayList<Cart> list){
        ArrayList<Document> arr = new ArrayList<>();
        for(Cart e : list) {
            Document doc = new Document();
            doc.put("pId",e.getProduct().getId());
            doc.put("name",e.getProduct().getName());
            doc.put("price",e.getProduct().getPrice());
            doc.put("num",e.getNum());
            arr.add(doc);
        }
        col.insertOne(new Document("Order",arr));
    }

    public static void main(String[] args) {
        User user = UserService.getUser("user1");
        ArrayList<Cart> cart = CartService.getAllProduct(user);
        for(Cart e : cart)
            System.out.println(e.getProduct().getId());
        addOrder(cart);
    }
}
