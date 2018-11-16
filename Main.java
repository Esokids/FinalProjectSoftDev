import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.*;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.mongodb.client.gridfs.model.GridFSUploadOptions;
import com.mongodb.gridfs.GridFSDBFile;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.io.*;

public class Main {
    static MongoClientURI uri = new MongoClientURI("mongodb://admin:password1@ds249503.mlab.com:49503/finalproject");
    static MongoClient client = new MongoClient(uri);
    static MongoDatabase db = client.getDatabase(uri.getDatabase());
    static MongoCollection<Document> col = db.getCollection("product");

    public static void main(String[] args) throws IOException {

//        ArrayList<Product> product = MainpageService.showAllProduct();
//        for(Product e : product)
//            System.out.println(e);

//        Product product = MainpageService.getProduct("S03");
//        System.out.println(product);


//        User user = UserService.getUser("admin"); //Exists username
//        User user = UserService.getUser("admin555"); //Not Exists username
//        if(user != null) {
//            System.out.println("Username : " + user.getUsername() + ", Password : " + user.getPassword() + ", Type : " + user.getType());
//        }else{
//            System.out.println("This username not exists");
//        }

//        Add User to Database
//        if(UserService.addUser("user1","123456"))
//            System.out.println("Success !!");
//        else
//            System.out.println("Fail");

/*      ************* IMAGE NOT DONE *************

        GridFSBucket gridFSBucket = GridFSBuckets.create(db);
        InputStream streamToUploadFrom = new FileInputStream(new File("C:\\Users\\WinzY\\Desktop\\pajamas.jpg"));
        ObjectId fileId = gridFSBucket.uploadFromStream("pajamas",streamToUploadFrom);

        gridFSBucket.find().forEach(
                new Block<GridFSFile>() {
                    @Override
                    public void apply(GridFSFile gridFSFile) {
                        System.out.println(gridFSFile.getFilename());
                    }
                }
        );

        FileOutputStream streamToDownloadTo = new FileOutputStream("C:\\Users\\WinzY\\Desktop\\pajama3sNew12345.jpg");
        gridFSBucket.downloadToStream(fileId, streamToDownloadTo);
        streamToDownloadTo.close();
        System.out.println(streamToDownloadTo);


        GridFSDownloadStream downloadStream = gridFSBucket.openDownloadStream();
        int fileLength = (int) downloadStream.getGridFSFile().getLength();
        byte[] bytesToWriteTo = new byte[fileLength];
        downloadStream.read(bytesToWriteTo);
        downloadStream.close();

        System.out.println(new String(bytesToWriteTo));
*/
    }
}