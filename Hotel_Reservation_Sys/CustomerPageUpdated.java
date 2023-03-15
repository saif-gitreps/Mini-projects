import javax.swing.*;

public class ProgramPage extends JFrame{
    private JPanel ProgramPanel;
    private JLabel Title;
    private JCheckBox foodCheckBox;
    private JCheckBox tourGuideCheckBox;
    private JButton BOOKButton;
    private JButton CANCELButton;
    private JTextField NameField;
    private JTextField NatField;
    private JTextField MemField;
    private JTextField CredField;
    private JLabel enterLabel;
    private JComboBox BedCombo;
    private JComboBox StayCombo;

    public ProgramPage(){
        setContentPane(getProgramPanel());
        setTitle("LOGIN PAGE");
        setSize(600,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public JPanel getProgramPanel() {
        return ProgramPanel;
    }

    public void setProgramPanel(JPanel programPanel) {
        ProgramPanel = programPanel;
    }
}
