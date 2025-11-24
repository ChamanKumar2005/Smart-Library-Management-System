import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReturnBook extends javax.swing.JFrame {

    Connection c = Connect.ConnectToDB();
    PreparedStatement pst;
    ResultSet rs;

    public ReturnBook() {
        initComponents();
    }

    public void clear() {
        txtbookid.setText("");
        txtbookname.setText("");
        txtduedate.setText("");
        txtissuedate.setText("");
        txtstudentid.setText("");
        txtstudentname.setText("");
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jButton6 = new javax.swing.JButton();
        txtduedate = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtissuedate = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtbookname = new javax.swing.JTextField();
        txtbookid = new javax.swing.JTextField();
        txtstudentid = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtstudentname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null); // FIXED

        // Close button
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close icon.png")));
        jButton6.setBounds(1088, 0, 50, 40);
        jButton6.addActionListener(evt -> jButton6ActionPerformed(evt));
        add(jButton6);

        txtduedate.setFont(new java.awt.Font("Segoe UI", 1, 14));
        txtduedate.setBounds(340, 560, 350, 40);
        add(txtduedate);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel2.setText("Book ID");
        jLabel2.setBounds(120, 180, 270, 50);
        add(jLabel2);

        txtissuedate.setFont(new java.awt.Font("Segoe UI", 1, 14));
        txtissuedate.setBounds(340, 480, 350, 40);
        add(txtissuedate);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel3.setText("Student ID");
        jLabel3.setBounds(120, 260, 270, 50);
        add(jLabel3);

        jButton1.setBackground(new java.awt.Color(204, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jButton1.setForeground(new java.awt.Color(242, 242, 242));
        jButton1.setText("Return");
        jButton1.setBounds(330, 640, 130, 40);
        jButton1.addActionListener(evt -> jButton1ActionPerformed(evt));
        add(jButton1);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel5.setText("Issue Date");
        jLabel5.setBounds(120, 490, 270, 50);
        add(jLabel5);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel6.setText("Book Name");
        jLabel6.setBounds(120, 410, 220, 50);
        add(jLabel6);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel7.setText("Due Date");
        jLabel7.setBounds(120, 560, 270, 50);
        add(jLabel7);

        txtbookname.setFont(new java.awt.Font("Segoe UI", 1, 14));
        txtbookname.setBounds(340, 410, 350, 40);
        add(txtbookname);

        txtbookid.setFont(new java.awt.Font("Segoe UI", 1, 14));
        txtbookid.setBounds(340, 180, 350, 40);
        add(txtbookid);

        txtstudentid.setFont(new java.awt.Font("Segoe UI", 1, 14));
        txtstudentid.setBounds(340, 260, 350, 40);
        add(txtstudentid);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/isue.jpg")));
        jLabel1.setText("Return Book");
        jLabel1.setBounds(20, 40, 240, 60);
        add(jLabel1);

        jButton2.setBackground(new java.awt.Color(204, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jButton2.setForeground(new java.awt.Color(242, 242, 242));
        jButton2.setText("Search");
        jButton2.setBounds(696, 267, 90, 30);
        jButton2.addActionListener(evt -> jButton2ActionPerformed(evt));
        add(jButton2);

        txtstudentname.setFont(new java.awt.Font("Segoe UI", 1, 14));
        txtstudentname.setBounds(340, 340, 350, 40);
        add(txtstudentname);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel8.setText("Student Name");
        jLabel8.setBounds(120, 340, 220, 50);
        add(jLabel8);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/All Page Backgraound.jpg")));
        jLabel4.setBounds(0, -4, 1140, 770);
        add(jLabel4);

        pack();
        setSize(1140, 770);
        setLocationRelativeTo(null);
    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            pst = c.prepareStatement("SELECT * FROM library.book WHERE id=?");
            pst.setString(1, txtstudentid.getText());
            rs = pst.executeQuery();

            if (rs.next()) {
                txtbookname.setText(rs.getString("name"));
                txtbookid.setText(rs.getString("id"));
                txtissuedate.setText(rs.getString("issue"));
                txtduedate.setText(rs.getString("due"));
            } else {
                JOptionPane.showMessageDialog(this, "Please Enter Valid Student ID");
            }

            pst = c.prepareStatement("SELECT * FROM library.student WHERE id=?");
            pst.setString(1, txtstudentid.getText());
            rs = pst.executeQuery();

            if (rs.next()) {
                txtstudentname.setText(rs.getString("name"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

        if (txtbookid.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Please enter Student ID and Search it again");
            txtstudentid.requestFocus();
        } else {
            try {
                pst = c.prepareStatement("UPDATE `library`.`book` SET `status`='NotIssue', `issue`='', `due`='', `studentid`='' WHERE (`id`=?)");
                pst.setString(1, txtstudentid.getText());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Return Successful");
                clear();
            } catch (SQLException ex) {
                Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new ReturnBook().setVisible(true));
    }

    // Variables declaration
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtbookid;
    private javax.swing.JTextField txtbookname;
    private javax.swing.JTextField txtduedate;
    private javax.swing.JTextField txtissuedate;
    private javax.swing.JTextField txtstudentid;
    private javax.swing.JTextField txtstudentname;
}
