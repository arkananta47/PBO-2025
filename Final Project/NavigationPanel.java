
/**
 * Write a description of class NavigationPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import javax.swing.*;
import java.awt.event.*;

public class NavigationPanel {
    public static JMenuBar createMenuBar(JFrame frame, User user) {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuFile = new JMenu("File");
        JMenuItem miLogout = new JMenuItem("Logout");
        JMenuItem miExit = new JMenuItem("Exit");
        menuFile.add(miLogout);
        menuFile.add(miExit);

        miLogout.addActionListener(e -> {
            frame.dispose();
            new LoginGUI();
        });

        miExit.addActionListener(e -> System.exit(0));

        menuBar.add(menuFile);

        JMenu menuView = new JMenu("View");
        if ("admin".equals(user.getRole())) {
            JMenuItem miManage = new JMenuItem("Manage Taxpayers");
            JMenuItem miChart = new JMenuItem("Charts");
            menuView.add(miManage);
            menuView.add(miChart);

            miManage.addActionListener(e -> {
                if (frame instanceof AdminDashboard) ((AdminDashboard) frame).showManagePanel();
            });
            miChart.addActionListener(e -> {
                if (frame instanceof AdminDashboard) ((AdminDashboard) frame).showChartPanel();
            });
        } else {
            JMenuItem miMyTax = new JMenuItem("My Tax (by NPWP)");
            JMenuItem miChart = new JMenuItem("My Tax Chart");
            menuView.add(miMyTax);
            menuView.add(miChart);

            miMyTax.addActionListener(e -> {
                if (frame instanceof CustomerDashboard) ((CustomerDashboard) frame).showMyTaxPanel();
            });
            miChart.addActionListener(e -> {
                if (frame instanceof CustomerDashboard) ((CustomerDashboard) frame).showChartPanel();
            });
        }

        menuBar.add(menuView);
        return menuBar;
    }
}
