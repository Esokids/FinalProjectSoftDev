import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class TableForm {
    private JPanel panel1;
    private JTable table1;

    public static void main(String args[]){
        JFrame frame = new JFrame();
        frame.setContentPane(new TableForm().getShowTable());
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getShowTable(){
        setTable();
        return panel1;
    }

    public void setTable(){
        String columnName[] = {"ID","Name","Price"};
        DefaultTableModel table = new DefaultTableModel(columnName,0);
        ArrayList<Product> product = ProductService.showAllProduct();
        for(Product e : product)
            table.addRow(new Object[] {e.getId(),e.getName(),e.getPrice()});
        table1.setModel(table);
    }

}
