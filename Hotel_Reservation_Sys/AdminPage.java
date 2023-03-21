import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPage extends JFrame{
    public JPanel AdminPanel;
    private JPasswordField passwordField1;
    private JButton enterButton;
    private JLabel passLabel;
    private JTextField BedField;
    private JTextField CustomerNumber;
    private JTextField profitField;
    private JLabel bedLabel;
    private JLabel customerLabel;
    private JLabel profitLabel;
    private JLabel HotelLabel;
    private JButton backLOGIN;
    private JButton backPROGRAM;

    public AdminPage(Customer customer) {
        setSize(470,260);
        setContentPane(getAdminPanel());
        setTitle("ADMIN PANEL");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        BedField.setVisible(false);
        CustomerNumber.setVisible(false);
        profitField.setVisible(false);
        profitLabel.setVisible(false);
        customerLabel.setVisible(false);
        bedLabel.setVisible(false);

        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] pass= passwordField1.getPassword();
                if(pass.equals(' ')){
                    JOptionPane.showMessageDialog(null,"Sorry you are not allowed.");
                }
                else{
                    enterButton.setVisible(false);
                    passwordField1.setVisible(false);
                    passLabel.setVisible(false);
                    BedField.setVisible(true);
                    BedField.setEditable(false);
                    CustomerNumber.setVisible(true);
                    CustomerNumber.setEditable(false);
                    profitField.setVisible(true);
                    profitField.setEditable(false);
                    profitLabel.setVisible(true);
                    customerLabel.setVisible(true);
                    bedLabel.setVisible(true);

                    BedField.setText(String.valueOf(customer.bedOccupied));
                    CustomerNumber.setText(String.valueOf(customer.totalMembers));
                    profitField.setText(String.valueOf(customer.finalCost));
                }
            }
        });
        backLOGIN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginPage login = new LoginPage();
                login.setVisible(true);
                dispose();
            }
        });
        backPROGRAM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProgramPage program = new ProgramPage();
                program.setVisible(true);
                dispose();
            }
        });

    }
    public JPanel getAdminPanel(){
        return AdminPanel;
    }
}
