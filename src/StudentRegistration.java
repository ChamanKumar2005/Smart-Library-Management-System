import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentRegistration extends javax.swing.JFrame {

    public StudentRegistration() {
        initComponents();
    }

    public void clear() {
        txtbranch.setText("");
        txtcourse.setText("");
        txtid.setText("");
        txtname.setText("");
        txtsem.setText("");
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtcourse = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        txtsem = new javax.swing.JTextField();
        txtbranch = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);   // FIXED

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close icon.png")));
        jButton6.setBounds(1088, 0, 50, 40);  // FIXED
        jButton6.addActionListener(evt -> jButton6ActionPerformed(evt));
        add(jButton6);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/isue.jpg")));
        jLabel1.setText("Student Registration");
        jLabel1.setBounds(40, 40, 250, 60);  // FIXED
        add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel2.setText("Student ID");
        jLabel2.setBounds(130, 170, 239, 46);
        add(jLabel2);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel3.setText("Student Name");
        jLabel3.setBounds(130, 240, 239, 46);
        add(jLabel3);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel5.setText("Branch Name");
        jLabel5.setBounds(130, 390, 239, 46);
        add(jLabel5);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel6.setText("Course Name");
        jLabel6.setBounds(120, 320, 239, 46);
        add(jLabel6);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel7.setText("Semester");
        jLabel7.setBounds(130, 460, 239, 46);
        add(jLabel7);

        txtcourse.setFont(new java.awt.Font("Segoe UI", 1, 18));
        txtcourse.setBounds(370, 320, 310, 40);
        add(txtcourse);

        txtid.setFont(new java.awt.Font("Segoe UI", 1, 18));
        txtid.setBounds(370, 170, 310, 40);
        add(txtid);

        txtname.setFont(new java.awt.Font("Segoe UI", 1, 18));
        txtname.setBounds(370, 240, 310, 40);
        add(txtname);

        txtsem.setFont(new java.awt.Font("Segoe UI", 1, 18));
        txtsem.setBounds(370, 460, 310, 40);
        add(txtsem);

        txtbranch.setFont(new java.awt.Font("Segoe UI", 1, 18));
        txtbranch.setBounds(370, 390, 310, 40);
        add(txtbranch);

        btnsave.setBackground(new java.awt.Color(204, 0, 0));
        btnsave.setFont(new java.awt.Font("Segoe UI", 1, 18));
        btnsave.setForeground(new java.awt.Color(242, 242, 242));
        btnsave.setText("Save");
        btnsave.setBounds(330, 570, 110, 30);
        btnsave.addActionListener(evt -> btnsaveActionPerformed(evt));
        add(btnsave);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/All Page Backgraound.jpg")));
        jLabel4.setBounds(0, 0, 1140, 770);
        add(jLabel4);

        pack();
        setSize(1140, 770);
        setLocationRelativeTo(null);
    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {

        PreparedStatement pst;
        Connection c = Connect.ConnectToDB();

        if (txtid.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Please enter Student ID");
            txtid.requestFocus();
        } else if (txtname.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Please enter Student Name");
            txtname.requestFocus();
        } else if (txtcourse.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Please enter Course");
            txtcourse.requestFocus();
        } else if (txtbranch.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Please enter Branch");
            txtbranch.requestFocus();
        } else if (txtsem.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Please enter Semester");
            txtsem.requestFocus();
        } else {
            try {
                pst = c.prepareStatement(
                        "INSERT INTO `library`.`student` (`id`, `name`, `course`, `branch`, `semester`) VALUES (?,?,?,?,?)");
                pst.setString(1, txtid.getText());
                pst.setString(2, txtname.getText());
                pst.setString(3, txtcourse.getText());
                pst.setString(4, txtbranch.getText());
                pst.setString(5, txtsem.getText());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, "Record Saved", "Saved", JOptionPane.INFORMATION_MESSAGE);
                clear();
            } catch (SQLException ex) {
                Logger.getLogger(StudentRegistration.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {}

        java.awt.EventQueue.invokeLater(() -> new StudentRegistration().setVisible(true));
    }

    // Variables
    private javax.swing.JButton btnsave;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtbranch;
    private javax.swing.JTextField txtcourse;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtsem;
}
