import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.bson.*;
import org.bson.types.ObjectId;
import sun.awt.image.ImageCache;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

public class ProductDao {
    static MongoClientURI uri = new MongoClientURI("mongodb://admin:password1@ds249503.mlab.com:49503/finalproject");
    static MongoClient client = new MongoClient(uri);
    static MongoDatabase db = client.getDatabase(uri.getDatabase());
    static MongoCollection<Document> col = db.getCollection("product");

    static public ArrayList<Product> getAllProducts() {
        MongoCursor<Document> cursor = col.find().iterator();
        ArrayList<Product> products = new ArrayList<>();
        while (cursor.hasNext()) {
            Document product = cursor.next();
            products.add(new Product(product.get("_id").toString(),product.get("name").toString(),(int)product.get("price")
                    ,product.get("size").toString(),product.get("color").toString(),product.get("brand").toString()));
        }
        return products;
    }

    static public Product getProduct(String pId) {
        Document findProduct = new Document("_id",pId);
        MongoCursor<Document> cursor = col.find(findProduct).iterator();
        Product thisProduct = null;
        if(cursor.hasNext()){
            Document product = cursor.next();
            thisProduct = new Product(product.get("_id").toString(),product.get("name").toString(),(int)product.get("price")
                    ,product.get("size").toString(),product.get("color").toString(),product.get("brand").toString());
        }
        return thisProduct;
    }
    /*
    static public byte[] getPicture(String pId) throws IOException {
        GridFSBucket gridFSBucket = GridFSBuckets.create(db);
        gridFSBucket.find(new Document("_id",pId)).iterator();
    }
    */
}
