import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame{
    private JProgressBar progressBar1;
    private JPanel panel1;
    private JButton sButton;
    private JButton rButton;
    private JComboBox<Integer> comboBox1;
    public int progress =0;
    public int max_progress = 100;
    public Timer timer;
    public Window(){
        setContentPane(panel1);
        setTitle("timer");
        setForeground(Color.black);
        setSize(330,65);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setVisible(true);
        comboBox1.addItem(7);
        comboBox1.addItem(15);
        comboBox1.addItem(30);
        comboBox1.addItem(45);
        comboBox1.addItem(60);
        int progress =0;
        int max_progress = 100;
        sButton.setFocusPainted(false);
        rButton.setFocusPainted(false);
        sButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int limit = comboBox1.getItemAt(comboBox1.getSelectedIndex());
                int minutes = limit*60*1000;
                startTimer(minutes);
                sButton.setText("||");
            }
        });
        rButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeStop();
                sButton.setText("▶");
            }
        });
    }
    private void startTimer(int limit){
        progress = 0;
        progressBar1.setValue(progress);
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progress++;
                progressBar1.setValue(progress);
                if(progress==max_progress){
                    timer.stop();
                }
            }
        });
        timer.setInitialDelay(0);
        timer.setDelay(limit / max_progress);
        timer.start();
    }
    private void timeStop(){
        progress= 0;
        progressBar1.setValue(progress);
        timer.stop();
    }
}
