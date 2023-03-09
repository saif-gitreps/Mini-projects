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
                    JOptionPane pane = new JOptionPane("Please do not keep fields empty.");
                    JDialog dialog = pane.createDialog(null, "Message");
                    dialog.setModal(false);
                    dialog.setVisible(true);
                    Timer timer = new Timer(600, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JOptionPane.getRootFrame().dispose();
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
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
                        JOptionPane.showMessageDialog(null, "Password too short!");
                        return;
                    } else if ((pass.length - 4) > Name.length()) {
                        JOptionPane.showMessageDialog(null, "Password Beyond system limit!");
                        return;
                    }
                    if (pass_word.equals(Name)) {
                        JOptionPane pane = new JOptionPane("Logging you in...");
                        JDialog dialog = pane.createDialog(null, "Message");
                        dialog.setModal(false);
                        dialog.setVisible(true);
                        Timer timer = new Timer(600, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JOptionPane.getRootFrame().dispose();
                            }
                        });
                        timer.setRepeats(false);
                        timer.start();
                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong password! ");
                    }
                }
            }
        });
        ClearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name_text.setText("");
                PasswordField.setText("");
            }
        });
        passHintButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Your password is your exact Name + birth year.\nexample: Name= Sam ,password = Sam1998");
            }
        });
    }


}
