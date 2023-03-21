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
    public static Customer people;
    public static int value;

    int CostCalculator(int bed,String dur,boolean food, boolean tour) {
        int cost = 0,Bed = bed , Dur = Integer.parseInt(dur);
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
        setSize(600,450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        BOOKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = NameField.getText();
                String members = MemField.getText();
                int Members = Integer.parseInt(members);
                String bedString = BedCombo.getSelectedItem().toString();
                int bed = Integer.parseInt(bedString);
                String dur = StayCombo.getSelectedItem().toString();
                boolean food = foodCheckBox.isSelected();
                boolean tour = tourGuideCheckBox.isSelected();
                if(name==" " || members==" " || dur==" "){
                    OutLabel.setText("Please do not keep any fields empty.");
                    return;
                }
                else {
                    value = CostCalculator(bed,dur,food,tour);
                    people = new Customer (Members, bed,value-((value*2)/100));
                    JOptionPane.showMessageDialog(null,"Thank you "+name+" for booking\nYour total cost is : "+value+"\nHope you enjoy your time!");
                    NameField.setText("");
                    MemField.setText("");
                    BedCombo.setSelectedIndex(0);
                    StayCombo.setSelectedIndex(0);
                    OutLabel.setText("");
                }
            }
        });
        CLEARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NameField.setText("");
                MemField.setText("");
                BedCombo.setSelectedIndex(0);
                StayCombo.setSelectedIndex(0);
                OutLabel.setText("");
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
                AdminPage adminPage = new AdminPage(people);
                adminPage.setVisible(true);
                dispose();
            }
        });
    }
    public JPanel getProgramPanel() {
        return ProgramPanel;
    }

}
