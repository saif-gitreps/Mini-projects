import javax.swing.*;
import java.util.ArrayList;

public class AdminPage extends JFrame{
    public JPanel AdminPanel;
    private JTable Table;
    public ArrayList<Customer> customers;
    public AdminPage(ArrayList<Customer> customers) {
        this.customers = customers;
        setContentPane(getAdminPanel());
        setTitle("Admin View");
        setSize(500,600);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

        Object[][] data = new Object[customers.size()][6];
        for(int i=0;i< customers.size();i++){
            data[i][0] = customers.get(i).name;
            data[i][1] = customers.get(i).members;
            data[i][2] = customers.get(i).national;
            data[i][3] = customers.get(i).cred;
            data[i][4] = customers.get(i).bed;
            data[i][5] = customers.get(i).duration;
        }
        Table = new JTable(data, new String[]{"Name","Members","Nationality","Credit Card","Bed","Duration"});
        JScrollPane scrollPane = new JScrollPane(Table);
        AdminPanel.add(scrollPane);

    }
    public JPanel getAdminPanel(){
        return AdminPanel;
    }
}
