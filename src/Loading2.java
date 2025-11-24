import java.sql.*;
import javax.swing.*;

public class Loading2 extends javax.swing.JFrame {

    public Loading2() {
        initComponents();

        Thread t = new Thread(() -> {
            for (int i = 0; i <= 100; i++) {
                try {
                    jProgressBar1.setValue(i);
                    Thread.sleep(50);

                    String percent = jProgressBar1.getString();

                    if (percent.equals("100%")) {
                        new SignIn().setVisible(true);
                        dispose();
                    }
                    if (percent.equals("50%")) {
                        jLabel.setText("Loading Modules.....");
                    }
                    if (percent.equals("25%")) {
                        jLabel.setText("Connecting Database....");
                    }
                    if (percent.equals("95%")) {
                        jLabel.setText("Launching Application....");
                    }

                } catch (InterruptedException ex) { }
            }
        });
        t.start();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);   // FIXED

        jPanel1.setBackground(new java.awt.Color(0, 255, 0));
        jPanel1.setLayout(null); // FIXED
        jPanel1.setBounds(0, 0, 650, 470);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Picsart_23-10-30_17-47-04-022.jpg")));
        jLabel1.setBounds(10, 10, 630, 400);
        jPanel1.add(jLabel1);

        jProgressBar1.setBackground(new java.awt.Color(0, 0, 153));
        jProgressBar1.setForeground(new java.awt.Color(0, 0, 153));
        jProgressBar1.setStringPainted(true);
        jProgressBar1.setBounds(0, 440, 650, 16);
        jPanel1.add(jProgressBar1);

        jLabel.setBounds(400, 420, 247, 22);
        jPanel1.add(jLabel);

        getContentPane().add(jPanel1);
        pack();

        setSize(650, 470);   // FIXED
        setLocationRelativeTo(null);
    }

    public static void main(String args[]) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
        }

        java.awt.EventQueue.invokeLater(() -> new Loading2().setVisible(true));
    }

    // Variables
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
}
