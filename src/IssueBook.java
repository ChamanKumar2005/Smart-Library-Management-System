import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IssueBook extends javax.swing.JFrame {

    PreparedStatement pst;
    ResultSet rs;
    Connection c = Connect.ConnectToDB();

    public IssueBook() {
        initComponents();

        // Set today's issue date
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        txtissuedate.setText(sdf.format(new Date()));
    }

    public void clear() {
        txtbookname.setText("");
        txtduedate.setText("");
        txtissuedate.setText("");
        txtstudentid.setText("");
        txtid.setText("");
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnissue = new javax.swing.JButton();
        txtid = new javax.swing.JTextField();
        txtstudentid = new javax.swing.JTextField();
        txtbookname = new javax.swing.JTextField();
        txtissuedate = new javax.swing.JTextField();
        txtduedate = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);   // FIXED

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24));
        jLabel1.setForeground(java.awt.Color.WHITE);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/isue.jpg")));
        jLabel1.setText("Issue Book");
        jLabel1.setBounds(40, 60, 200, 70);
        add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel2.setText("Book ID");
        jLabel2.setBounds(140, 200, 250, 40);
        add(jLabel2);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel3.setText("Student ID");
        jLabel3.setBounds(140, 280, 240, 40);
        add(jLabel3);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel4.setText("Book Name");
        jLabel4.setBounds(140, 360, 250, 40);
        add(jLabel4);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel5.setText("Issue Date");
        jLabel5.setBounds(140, 450, 240, 40);
        add(jLabel5);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel6.setText("Due Date");
        jLabel6.setBounds(140, 540, 240, 40);
        add(jLabel6);

        btnissue.setBackground(new java.awt.Color(204, 0, 0));
        btnissue.setFont(new java.awt.Font("Segoe UI", 1, 18));
        btnissue.setForeground(java.awt.Color.WHITE);
        btnissue.setText("Issue Book");
        btnissue.setBounds(260, 630, 130, 40);
        btnissue.addActionListener(evt -> btnissueActionPerformed(evt));
        add(btnissue);

        txtid.setFont(new java.awt.Font("Segoe UI", 1, 18));
        txtid.setBounds(320, 200, 350, 40);
        add(txtid);

        txtstudentid.setFont(new java.awt.Font("Segoe UI", 1, 18));
        txtstudentid.setBounds(320, 280, 350, 40);
        add(txtstudentid);

        txtbookname.setEditable(false);
        txtbookname.setFont(new java.awt.Font("Segoe UI", 1, 18));
        txtbookname.setBounds(320, 360, 350, 40);
        add(txtbookname);

        txtissuedate.setEditable(false);
        txtissuedate.setFont(new java.awt.Font("Segoe UI", 1, 18));
        txtissuedate.setBounds(320, 450, 350, 40);
        add(txtissuedate);

        txtduedate.setFont(new java.awt.Font("Segoe UI", 1, 18));
        txtduedate.setBounds(320, 540, 350, 40);
        add(txtduedate);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close icon.png")));
        jButton2.setBounds(1090, 0, 51, 40);
        jButton2.addActionListener(evt -> dispose());
        add(jButton2);

        jButton1.setBackground(new java.awt.Color(204, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jButton1.setForeground(java.awt.Color.WHITE);
        jButton1.setText("Search");
        jButton1.setBounds(676, 204, 100, 30);
        jButton1.addActionListener(evt -> jButton1ActionPerformed(evt));
        add(jButton1);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/All Page Backgraound.jpg")));
        jLabel7.setBounds(0, 0, 1140, 770);
        add(jLabel7);

        setSize(1140, 770);
        setLocationRelativeTo(null);
    }

    private void btnissueActionPerformed(java.awt.event.ActionEvent evt) {

        if (txtid.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter Book ID, then Search.");
            txtid.requestFocus();
            return;
        }

        try {
            pst = c.prepareStatement(
                    "UPDATE library.book SET status='Issued', issue=?, due=?, studentid=? WHERE id=?"
            );
            pst.setString(1, txtissuedate.getText());
            pst.setString(2, txtduedate.getText());
            pst.setString(3, txtstudentid.getText());
            pst.setString(4, txtid.getText());
            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Book Issued Successfully");
            clear();
        } catch (SQLException ex) {
            Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

        try {
            pst = c.prepareStatement("SELECT * FROM library.book WHERE id=?");
            pst.setString(1, txtid.getText());
            rs = pst.executeQuery();

            if (rs.next()) {
                txtbookname.setText(rs.getString("name"));
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Book ID");
            }

        } catch (SQLException ex) {
            Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {

        try {
            for (UIManager.LookAndFeelInfo info :
                    UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {}

        java.awt.EventQueue.invokeLater(() -> new IssueBook().setVisible(true));
    }

    // Variables
    private javax.swing.JButton btnissue;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtbookname;
    private javax.swing.JTextField txtduedate;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtissuedate;
    private javax.swing.JTextField txtstudentid;
}
