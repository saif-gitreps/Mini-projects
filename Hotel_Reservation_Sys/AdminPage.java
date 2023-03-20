import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminPage extends JFrame{
    public JPanel AdminPanel;
    private JPasswordField passwordField1;
    private JButton enterButton;
    private JLabel passLabel;
    private JTextField BedField;
    private JTextField CustomerNumber;
    private JTextField profitField;
    private JLabel bedLabel;
    public ArrayList<Customer> customers;
    public AdminPage(ArrayList<Customer> customers) {
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] pass= passwordField1.getPassword();
                if(pass.equals(' ')){
                    JOptionPane.showMessageDialog(null,"Sorry you are not allowed.");
                }
                else{

                }
            }
        });


    }
    public JPanel getAdminPanel(){
        return AdminPanel;
    }
}
