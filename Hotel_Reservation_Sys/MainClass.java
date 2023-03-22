public class MainClass {
    public static void main(String args[]){
        LoginPage login = new LoginPage();

    }
}
/*

things i learned from this project :
OOP concepts :

understood why it is good to make different classes in different folder and writing separate code for each section .

Used the windows panel to be open with a constructor call.

To use JFrame features we had to extend the classes with

example :- public class ProgramPage extends JFrame.

In order to return a panel to another window, outside the constructor we had to declare 
public JPanel getAdminPage() { return AdminPanel; }

In order to have database like variable , use public static VariableName.

Java Swing concepts :

// to view the components of the GUI in the panel-> setContentPane(LoginPane); 
// to set a title in the window pane -> setTitle("title");
// setSize(400,350);
// To close an entire program after pressing 'x' -> setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
// To close only current window after pressing 'x' -> setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
// setVisible(true);
// to close the current window after an action is performed -> dispose();

to add a function to a button ->
example -> LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            		// function
		}
        });

// to clear a textfield / Label / textarea -> jTextField1.setText(" ");
// to store password -> char[] pass = PasswordField.getPassword();
// to store String from textfield -> String name = NameField.getText();
// to set cup combo box -> myCombo.setEditable(true);
// to add items in combo box -> myCombo.addItem("item");
// to perfrom action with combo box -> (myCombo.getSelectedItem()=="ITEM")
// to resert combo box -> myCombo.setSelectedIndex(0);

to add a pop up message box -> 
// JOptionPane.showMessageDialog(null,"message");
// to confirm is a checkbox is selected -> JCheckBox1.isSelected();

// to make textfields//Any component invisbible -> Jtextffield1.setVisible(false);
// to make textfields/Any component uneditable -> Jtextfields1.setEditable(false);

/* THE REST OF THE GUI IS MADE IN INTELLIJ */

*/
