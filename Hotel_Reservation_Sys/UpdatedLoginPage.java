import javax.swing.*;
import java.lang.String;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class LoginPage extends JFrame{
    private JPanel LoginPanel;
    private JTextField name_text;
    private JLabel PasswordLabel;
    private JPasswordField PasswordField;
    private JLabel NameLabel;
    private JButton LoginButton;
    private JButton ClearButton;
    private JButton passHintButton;
    private JLabel OutPutLabel;
    private JComboBox myCombo;
    private JTextField HintField;

    public LoginPage(){
        setContentPane(LoginPanel);
        setTitle("LOGIN PAGE");
        setSize(400,350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        //Making my comboBox items.
        myCombo.setEditable(true);
        myCombo.addItem(" ");
        myCombo.addItem("Admin");
        myCombo.addItem("Customer");

        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] pass = PasswordField.getPassword();
                if (name_text.getText().isEmpty() || pass.length == 0) {
                    //this checks if any of the fields are empty.
                    OutPutLabel.setText("Please do not keep fields empty.");
                } else {
                    // the entire conditions are der to make sure,
                    // Name == PassName; -4 because there is 4 dig of birth-year.
                    String Name = name_text.getText();
                    String pass_w = new String(pass);
                    String pass_word = pass_w.substring(0, pass_w.length() - 4);

                    if ((pass.length - 4) < Name.length()) {
                        OutPutLabel.setText("Password too short");
                        return;
                    } else if ((pass.length - 4) > Name.length()) {
                        OutPutLabel.setText("Password Beyond system limit!");
                        return;
                    }
                    if (pass_word.equals(Name)) {
                        OutPutLabel.setText("Logging you in..");
                        if(myCombo.getSelectedItem()=="Customer") {
                            //my customer panel.
                            ProgramPage NewPanel = new ProgramPage();
                            NewPanel.setVisible(true);
                            dispose();
                        }
                        else{
                            ///admin panel.
                        }
                    } else {
                        //JOptionPane.showMessageDialog(null, "Wrong password! ");
                        OutPutLabel.setText("Wrong Password! ");
                    }
                }
            }
        });
        ClearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name_text.setText("");
                PasswordField.setText("");
                OutPutLabel.setText("");
            }
        });
    }

}
