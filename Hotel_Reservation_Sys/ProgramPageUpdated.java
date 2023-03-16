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
    private JTextField NatField;
    private JTextField MemField;
    private JTextField CredField;
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
                String nation = NatField.getText();
                String members = MemField.getText();
                String cred = CredField.getText();
                String bed = BedCombo.getSelectedItem().toString();
                String dur = StayCombo.getSelectedItem().toString();
                boolean food = foodCheckBox.isSelected();
                boolean tour = tourGuideCheckBox.isSelected();
                if(name==" " || nation==" " || members==" " || cred==" " || bed==" " || dur==" "){
                    OutLabel.setText("Please do not keep any fields empty.");
                    return;
                }
                else {
                    Customer people = new Customer(name, nation, members, cred, bed, dur, food, tour);
                    customerList.add(people);
                    int value = CostCalculator(bed,dur,food,tour);
                    JOptionPane.showMessageDialog(null,"Your total cost is : "+value);
                }
            }
        });
        CLEARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NameField.setText("");
                NatField.setText("");
                MemField.setText("");
                CredField.setText("");
                BedCombo.removeAllItems();
                StayCombo.removeAllItems();
                foodCheckBox.setSelected(false);
                tourGuideCheckBox.setSelected(false);
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
    }
    public JPanel getProgramPanel() {
        return ProgramPanel;
    }

}
