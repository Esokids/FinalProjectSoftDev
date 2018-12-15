import java.util.ArrayList;

public class Order {
    private String id;
    private ArrayList<Cart> list;

    public Order(String id, ArrayList<Cart> list){
        this.id = id;
        for(Cart e: list)
            this.list.add(e);
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Cart> getList() {
        return list;
    }

    public void setList(ArrayList<Cart> list) {
        this.list = list;
    }
}