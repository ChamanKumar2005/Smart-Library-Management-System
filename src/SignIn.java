import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SignIn extends javax.swing.JFrame {

    public SignIn() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jButton6 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        btnlogin = new javax.swing.JButton();
        txtpassword = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);   // <<< FIXED

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close icon.png")));
        jButton6.setBounds(1316, 0, 50, 50);   // <<< FIXED
        jButton6.addActionListener(evt -> jButton6ActionPerformed(evt));
        add(jButton6);

        jLabel4.setBounds(377, 118, 36, 31);   // <<< FIXED
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        add(jLabel4);

        txtemail.setFont(new java.awt.Font("Sitka Display", 1, 18));
        txtemail.setBounds(600, 360, 264, 41);   // <<< FIXED
        add(txtemail);

        btnlogin.setBackground(new java.awt.Color(255, 51, 51));
        btnlogin.setFont(new java.awt.Font("Sitka Display", 1, 14));
        btnlogin.setForeground(new java.awt.Color(255, 255, 255));
        btnlogin.setText("Login now");
        btnlogin.setBounds(580, 500, 122, 30);    // <<< FIXED
        btnlogin.addActionListener(evt -> btnloginActionPerformed(evt));
        add(btnlogin);

        txtpassword.setFont(new java.awt.Font("Tw Cen MT", 1, 24));
        txtpassword.setBounds(600, 420, 264, 40);   // <<< FIXED
        add(txtpassword);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Login now");
        jLabel5.setBounds(610, 310, 130, 30);   // <<< FIXED
        add(jLabel5);

        jLabel2.setFont(new java.awt.Font("Sitka Display", 1, 18));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Password");
        jLabel2.setBounds(500, 420, 100, 30);   // <<< FIXED
        add(jLabel2);

        jLabel1.setFont(new java.awt.Font("Sitka Display", 1, 18));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User ID");
        jLabel1.setBounds(510, 370, 80, 30);   // <<< FIXED
        add(jLabel1);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/login page.jpg")));
        jLabel3.setBounds(0, 0, 1370, 770);     // <<< FIXED
        add(jLabel3);

        pack();
        setSize(1370, 770);
        setLocationRelativeTo(null);
    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        int yes = JOptionPane.showConfirmDialog(this, "Are you really Close this application?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (yes == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) { }

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {
        PreparedStatement pst;
        ResultSet rs;
        Connection c = Connect.ConnectToDB();

        try {
            pst = c.prepareStatement("SELECT * FROM library.login WHERE userid=? AND password=?");
            pst.setString(1, txtemail.getText());
            pst.setString(2, new String(txtpassword.getPassword()));

            rs = pst.executeQuery();

            if (rs.next()) {
                new home().setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid ID or Password");
            }

        } catch (SQLException ex) {
            Logger.getLogger(SignIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new SignIn().setVisible(true));
    }

    // Variables declaration
    private javax.swing.JButton btnlogin;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtemail;
    private javax.swing.JPasswordField txtpassword;
}
