import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class ClockGUI extends JFrame {
    private ClockDisplay clock;
    private JLabel timeLabel;
    private JLabel dateLabel;
    private JLabel tempLabel;
    private Timer timer;

    public ClockGUI() {
        LocalTime curTime = LocalTime.now();
        clock = new ClockDisplay(curTime.getHour(), curTime.getMinute(), curTime.getSecond());

        setTitle("Jam di IF-105");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLACK);

        timeLabel = new JLabel(clock.getTime(), SwingConstants.CENTER);
        timeLabel.setFont(new Font("DS-Digital", Font.BOLD, 48));
        timeLabel.setForeground(Color.RED);

        LocalDate curDate = LocalDate.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dateLabel = new JLabel(curDate.format(dateFormat), SwingConstants.LEFT);
        dateLabel.setFont(new Font("DS-Digital", Font.PLAIN, 16));
        dateLabel.setForeground(Color.RED);

        tempLabel = new JLabel("30°C", SwingConstants.RIGHT);
        tempLabel.setFont(new Font("DS-Digital", Font.PLAIN, 16));
        tempLabel.setForeground(Color.RED);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(Color.BLACK);
        bottomPanel.add(dateLabel, BorderLayout.WEST);
        bottomPanel.add(tempLabel, BorderLayout.EAST);

        add(timeLabel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        startClock();

        setVisible(true);
    }

    private void startClock() {
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock.timeTick();
                timeLabel.setText(clock.getTime());
                LocalDate curDate = LocalDate.now();
                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                dateLabel.setText(curDate.format(dateFormat));
            }
        });
        timer.start();
    }
}
