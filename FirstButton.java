import javax.swing.*;
import java.awt.*;
public class ClassDisplay {
    public static void main(String[] args){
       JFrame frame = new JFrame("simple button");
       JButton button = new JButton("click me");
       button.setSize(200,400);
       frame.setSize(500,400);
       frame.setBackground(Color.cyan);
       frame.getContentPane().add(button);
       frame.setVisible(true);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
