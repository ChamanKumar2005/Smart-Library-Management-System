import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AddBook extends javax.swing.JFrame {

    public AddBook() {
        initComponents();
    }

    public void clear() {
        txtid.setText("");
        txtname.setText("");
        txtprice.setText("");
        txtpublisher.setText("");
        txtyear.setText("");
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jButton6 = new javax.swing.JButton();
        txtyear = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtprice = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtpublisher = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);   // FIXED

        // Close button
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close icon.png")));
        jButton6.setBounds(1088, 0, 50, 40);
        jButton6.addActionListener(evt -> jButton6ActionPerformed(evt));
        add(jButton6);

        txtyear.setFont(new java.awt.Font("Segoe UI", 1, 14));
        txtyear.setBounds(370, 570, 320, 36);
        add(txtyear);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel2.setText("Book ID");
        jLabel2.setBounds(170, 210, 239, 46);
        add(jLabel2);

        txtprice.setFont(new java.awt.Font("Segoe UI", 1, 14));
        txtprice.setBounds(370, 470, 320, 40);
        add(txtprice);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel3.setText("Book Name");
        jLabel3.setBounds(170, 300, 239, 46);
        add(jLabel3);

        jButton1.setBackground(new java.awt.Color(204, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jButton1.setForeground(new java.awt.Color(242, 242, 242));
        jButton1.setText("Save");
        jButton1.setBounds(310, 670, 120, 30);
        jButton1.addActionListener(evt -> jButton1ActionPerformed(evt));
        add(jButton1);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel5.setText("Price");
        jLabel5.setBounds(170, 470, 239, 46);
        add(jLabel5);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel6.setText("Publisher");
        jLabel6.setBounds(170, 400, 239, 46);
        add(jLabel6);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel7.setText("Publisher Year");
        jLabel7.setBounds(170, 560, 239, 46);
        add(jLabel7);

        txtpublisher.setFont(new java.awt.Font("Segoe UI", 1, 14));
        txtpublisher.setBounds(370, 390, 320, 40);
        add(txtpublisher);

        txtid.setFont(new java.awt.Font("Segoe UI", 1, 14));
        txtid.setBounds(370, 210, 320, 40);
        add(txtid);

        txtname.setFont(new java.awt.Font("Segoe UI", 1, 14));
        txtname.setBounds(370, 300, 320, 40);
        add(txtname);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/isue.jpg")));
        jLabel1.setText("Add Book Details");
        jLabel1.setBounds(60, 50, 230, 53);
        add(jLabel1);

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

        PreparedStatement pst;
        Connection c = Connect.ConnectToDB();

        if (txtid.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Please enter Book ID");
            txtid.requestFocus();
        } else if (txtname.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Please enter Book Name");
            txtname.requestFocus();
        } else if (txtpublisher.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Please enter Publisher");
            txtpublisher.requestFocus();
        } else if (txtprice.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Please enter Book Price");
            txtprice.requestFocus();
        } else if (txtyear.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Please enter Publisher Year");
            txtyear.requestFocus();
        } else {
            try {
                pst = c.prepareStatement(
                        "INSERT INTO library.book(id,name,publisher,price,year,status) VALUES (?,?,?,?,?,?)");
                pst.setString(1, txtid.getText());
                pst.setString(2, txtname.getText());
                pst.setString(3, txtpublisher.getText());
                pst.setString(4, txtprice.getText());
                pst.setString(5, txtyear.getText());
                pst.setString(6, "NotIssued");

                pst.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, "Record Saved", "Saved", JOptionPane.INFORMATION_MESSAGE);
                clear();

            } catch (SQLException ex) {
                Logger.getLogger(AddBook.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (Exception ex) { }

        java.awt.EventQueue.invokeLater(() -> new AddBook().setVisible(true));
    }

    // Variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtpublisher;
    private javax.swing.JTextField txtyear;
}
