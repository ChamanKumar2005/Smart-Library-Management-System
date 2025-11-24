public class Loading1 extends javax.swing.JFrame {

    public Loading1() {
        initComponents();

        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1000);
                new Loading2().setVisible(true);
                dispose();
            } catch (InterruptedException ex) { }
        });
        t.start();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);   // FIXED

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x.jpg")));
        jLabel1.setBounds(0, 0, 1370, 770);   // FIXED
        getContentPane().add(jLabel1);

        pack();
        setSize(1370, 770);      // FIXED
        setLocationRelativeTo(null);
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
        } catch (Exception ex) {}

        java.awt.EventQueue.invokeLater(() -> new Loading1().setVisible(true));
    }

    // Variables
    private javax.swing.JLabel jLabel1;
}
