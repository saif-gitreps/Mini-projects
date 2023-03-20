import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class ProgramPage extends JFrame{
    private JPanel ProgramPanel;
    private JLabel Title;
    private JCheckBox foodCheckBox;
    private JCheckBox tourGuideCheckBox;
    private JButton BOOKButton;
    private JButton CLEARButton;
    private JTextField NameField;
    private JTextField MemField;
    private JLabel enterLabel;
    private JComboBox BedCombo;
    private JComboBox StayCombo;
    private JLabel OutLabel;
    private JButton viewAsAdminButton;
    private JButton BACKbutton;
    public ArrayList<Customer> customerList = new ArrayList<Customer>();
    public int Cost;

    int CostCalculator(String bed,String dur,boolean food, boolean tour) {
        int cost = 0,Bed = Integer.parseInt(bed) , Dur = Integer.parseInt(dur);
        if (!food && !tour) {
            cost = (Bed * 200) + (1000 * Dur);
        }
        else if (!food && tour) {
            cost = (Bed * 200) + (1200 * Dur );
        }
        else if (food && !tour){
            cost = (Bed * 200) + (1300 * Dur );
        }
        else if (food && tour){
            cost = (Bed * 200) + (1500 * Dur );
        }
        return cost;
    }
    public ProgramPage(){
        BedCombo.setEditable(true);
        BedCombo.addItem(" ");
        BedCombo.addItem("1");
        BedCombo.addItem("2");
        BedCombo.addItem("4");

        StayCombo.setEditable(true);
        StayCombo.addItem(" ");
        StayCombo.addItem("1");
        StayCombo.addItem("3");
        StayCombo.addItem("5");
        StayCombo.addItem("9");


        setContentPane(getProgramPanel());
        setTitle("LOGIN PAGE");
        setSize(600,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        BOOKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = NameField.getText();
                String members = MemField.getText();
                String bed = BedCombo.getSelectedItem().toString();
                String dur = StayCombo.getSelectedItem().toString();
                boolean food = foodCheckBox.isSelected();
                boolean tour = tourGuideCheckBox.isSelected();
                if(name==" " || members==" " || bed==" " || dur==" "){
                    OutLabel.setText("Please do not keep any fields empty.");
                    return;
                }
                else {
                    int value = CostCalculator(bed,dur,food,tour);
                    Customer people = new Customer(name, members, bed, dur, food, tour,value);
                    customerList.add(people);
                    JOptionPane.showMessageDialog(null,"Thank you for booking\nYour total cost is : "+value+"\nHope you enjoy your time!");
                    AdminPage adminPage = new AdminPage(customerList);
                    adminPage.setVisible(true);
                }
            }
        });
        CLEARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NameField.setText(" ");
                MemField.setText(" ");
                BedCombo.setSelectedIndex(0);
                StayCombo.setSelectedIndex(0);
                foodCheckBox.setSelected(false);
                tourGuideCheckBox.setSelected(false);
                OutLabel.setText(" ");
            }
        });
        BACKbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginPage login = new LoginPage();
                login.setVisible(true);
                dispose();
            }
        });
        viewAsAdminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminPage adminPage = new AdminPage(customerList);
                adminPage.setVisible(true);
            }
        });
    }
    public JPanel getProgramPanel() {
        return ProgramPanel;
    }

}
