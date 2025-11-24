import javax.swing.JOptionPane;

public class home extends javax.swing.JFrame {

    public home() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);  // FIXED

        // LOGOUT BUTTON
        jButton1.setBackground(new java.awt.Color(204, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/log out icon.jpg")));
        jButton1.setBounds(1160, 620, 180, 60);
        jButton1.addActionListener(evt -> jButton1ActionPerformed(evt));
        add(jButton1);

        // ISSUE BOOKS
        jButton2.setBackground(new java.awt.Color(204, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jButton2.setForeground(new java.awt.Color(242, 242, 242));
        jButton2.setText("issue books");
        jButton2.setBounds(1160, 360, 180, 60);
        jButton2.addActionListener(evt -> jButton2ActionPerformed(evt));
        add(jButton2);

        // RETURN BOOK
        jButton3.setBackground(new java.awt.Color(204, 0, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jButton3.setForeground(new java.awt.Color(242, 242, 242));
        jButton3.setText("return book");
        jButton3.setBounds(1160, 480, 180, 60);
        jButton3.addActionListener(evt -> jButton3ActionPerformed(evt));
        add(jButton3);

        // ADD BOOK
        jButton4.setBackground(new java.awt.Color(204, 0, 0));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jButton4.setForeground(new java.awt.Color(242, 242, 242));
        jButton4.setText("add book");
        jButton4.setBounds(1160, 240, 180, 60);
        jButton4.addActionListener(evt -> jButton4ActionPerformed(evt));
        add(jButton4);

        // STUDENT REGISTRATION
        jButton5.setBackground(new java.awt.Color(204, 0, 0));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jButton5.setForeground(new java.awt.Color(242, 242, 242));
        jButton5.setText("Student Registration");
        jButton5.setBounds(1160, 80, 180, 60);
        jButton5.addActionListener(evt -> jButton5ActionPerformed(evt));
        add(jButton5);

        // CLOSE APP BUTTON
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close icon.png")));
        jButton6.setBounds(1320, 0, 50, 40);
        jButton6.addActionListener(evt -> jButton6ActionPerformed(evt));
        add(jButton6);

        // BACKGROUND
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home page.jpg")));
        jLabel2.setBounds(0, 0, 1370, 770);
        add(jLabel2);

        pack();
        setSize(1370, 770);
        setLocationRelativeTo(null);
    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        int yes = JOptionPane.showConfirmDialog(this, "Are you sure you want to close?",
                "Exit", JOptionPane.YES_NO_OPTION);
        if (yes == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        int yes = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?",
                "Logout", JOptionPane.YES_NO_OPTION);
        if (yes == JOptionPane.YES_OPTION) {
            new SignIn().setVisible(true);
            dispose();
        }
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        new StudentRegistration().setVisible(true);
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        new AddBook().setVisible(true);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        new IssueBook().setVisible(true);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        new ReturnBook().setVisible(true);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info :
                    javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) { }

        java.awt.EventQueue.invokeLater(() -> new home().setVisible(true));
    }

    // Variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
}
