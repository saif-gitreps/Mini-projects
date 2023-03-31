import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    private JProgressBar progressBar1;
    private JPanel panel1;
    private JButton sButton;
    private JButton rButton;
    private JComboBox<Integer> comboBox1;
    public int progress =0;
    public int max_progress = 100;
    public Timer timer;
    private int timerDuration;

    public Window(){
        setContentPane(panel1);
        setTitle("Timer");
        setForeground(Color.black);
        setSize(330, 65);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setVisible(true);
        comboBox1.addItem(7);
        comboBox1.addItem(15);
        comboBox1.addItem(30);
        comboBox1.addItem(45);
        comboBox1.addItem(60);

        sButton.setFocusPainted(false);
        rButton.setFocusPainted(false);

        sButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int limit = comboBox1.getItemAt(comboBox1.getSelectedIndex());
                int minutes = limit * 60 * 1000;
                startTimer(minutes);
                sButton.setText("||");
            }
        });

        rButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopTimer();
                sButton.setText("▶");
            }
        });
    }

    private void startTimer(int limit) {
        progress = 0;
        progressBar1.setValue(progress);
        timerDuration = limit;
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progress++;
                progressBar1.setValue(progress * max_progress / (timerDuration / 1000));
                if(progress * max_progress / (timerDuration / 1000) >= max_progress) {
                    stopTimer();
                }
            }
        });
        timer.setInitialDelay(0);
        timer.start();
    }

    private void stopTimer() {
        progress = 0;
        progressBar1.setValue(progress);
        if(timer != null) {
            timer.stop();
        }
    }
}
