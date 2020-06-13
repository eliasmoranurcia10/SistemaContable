package Presentacion;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class inicio extends javax.swing.JFrame {
    
    private Timer t;
    private ActionListener ac;
    private int x = 0 ;
    

    public inicio() {
        initComponents();
        Image icon = new ImageIcon(getClass().getResource("/imagenes/Azucarera.png")).getImage();
        setIconImage(icon);
        
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        
        ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                x = x + 1;
                jProgressBar1.setValue(x);
                
                if(jProgressBar1.getValue() == 100){
                    t.stop();
                    dispose();
                    frmLogin login = new frmLogin();
                    login.setVisible(true);
                }
            }
        };
        t = new Timer(30, ac);
        t.start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbltitulo1 = new javax.swing.JLabel();
        lbltitulo2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbltitulo1.setBackground(new java.awt.Color(255, 255, 255));
        lbltitulo1.setFont(new java.awt.Font("Cambria", 3, 14)); // NOI18N
        lbltitulo1.setForeground(new java.awt.Color(0, 102, 0));
        lbltitulo1.setText("CENTRAL AZUCARERA ");
        jPanel1.add(lbltitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 154, 32));

        lbltitulo2.setBackground(new java.awt.Color(255, 255, 255));
        lbltitulo2.setFont(new java.awt.Font("Cambria", 3, 14)); // NOI18N
        lbltitulo2.setForeground(new java.awt.Color(0, 102, 0));
        lbltitulo2.setText("CHUCARAPI PAMPA BLANCA S.A.");
        jPanel1.add(lbltitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 230, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagen2.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 220, -1));

        jProgressBar1.setBackground(new java.awt.Color(0, 102, 0));
        jProgressBar1.setForeground(new java.awt.Color(0, 102, 0));
        jProgressBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0)));
        jProgressBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 220, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel lbltitulo1;
    private javax.swing.JLabel lbltitulo2;
    // End of variables declaration//GEN-END:variables
}
