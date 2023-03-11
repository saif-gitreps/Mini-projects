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
    private JCheckBox YESCheckBox;
    private JLabel NotRobot;
    private JButton passHintButton;
    private JLabel OutPutLabel;
    private JLabel HintLabel;
    private JTextField HintField;

    public LoginPage(){
        setContentPane(LoginPanel);
        setTitle("LOGIN PAGE");
        setSize(400,350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] pass = PasswordField.getPassword();
                if (name_text.getText().isEmpty() || pass.length == 0) {
                    OutPutLabel.setText("Please do not keep fields empty.");
                } else {
                    String Name = name_text.getText();
                    boolean checkBot = YESCheckBox.isSelected();
                    String pass_w = new String(pass);
                    String pass_word = pass_w.substring(0, pass_w.length() - 4);

                    if (checkBot == false) {
                        JOptionPane.showMessageDialog(null, "You are a Bot!\nOnly humans are allowed!");
                        return;
                    }
                    if ((pass.length - 4) < Name.length()) {
                        OutPutLabel.setText("Password too short");
                        return;
                    } else if ((pass.length - 4) > Name.length()) {
                        OutPutLabel.setText("Password Beyond system limit!");
                        return;
                    }
                    if (pass_word.equals(Name)) {
                        OutPutLabel.setText("Logging you in..");
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
