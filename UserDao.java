import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.*;

public class UserDao {
    static MongoClientURI uri = new MongoClientURI("mongodb://admin:password1@ds249503.mlab.com:49503/finalproject");
    static MongoClient client = new MongoClient(uri);
    static MongoDatabase db = client.getDatabase(uri.getDatabase());
    static MongoCollection<Document> col = db.getCollection("user");

    static public User getUser(String username) {
        Document findUser = new Document("_id",username);
        MongoCursor<Document> cursor = col.find(findUser).iterator();
        User thisUser = null;
        if(cursor.hasNext()){
            Document user = cursor.next();
            thisUser = new User(user.get("_id").toString(),user.get("password").toString(),user.get("type").toString());
        }
        return thisUser;
    }

    static public boolean addUser(String username, String password) {
        if(getUser(username) == null) {
            Document user = new Document("_id", username).append("password", password).append("type", "user");
            col.insertOne(user);
            return true;
        }else {
            return false;
        }
    }


    /*
    static public ArrayList<Product> getCart(String username){
        Document findUser = new Document("_id",username);

    }
    */
}
