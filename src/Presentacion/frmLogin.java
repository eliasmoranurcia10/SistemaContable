package Presentacion;

import Datos.Conexion;
import Entidades.Usuario;
import LogicaNegocio.UsuarioLN;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class frmLogin extends javax.swing.JFrame {


    public frmLogin() {
        initComponents();
        Image icon = new ImageIcon(getClass().getResource("/imagenes/f6f1a7763f12.png")).getImage();
        setIconImage(icon);
        
        this.setLocationRelativeTo(null);
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jplLogeo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnIngresar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jplLogeo.setBackground(new java.awt.Color(255, 255, 255));
        jplLogeo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 3));
        jplLogeo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 0));
        jLabel2.setText("CENTRAL AZUCARERA  ");
        jplLogeo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, 40));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 0));
        jLabel3.setText("Usuario : ");
        jplLogeo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 90, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/f6f1a7763f12.png"))); // NOI18N
        jplLogeo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 150, 160));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 0));
        jLabel1.setText("Contraseña :");
        jplLogeo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, -1));

        txtUser.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        txtUser.setForeground(new java.awt.Color(102, 102, 102));
        txtUser.setBorder(null);
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUserKeyReleased(evt);
            }
        });
        jplLogeo.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 210, 40));

        txtPassword.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(102, 102, 102));
        txtPassword.setBorder(null);
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordKeyReleased(evt);
            }
        });
        jplLogeo.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, 225, 39));

        jLabel5.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 0));
        jLabel5.setText(" CHUCARAPI PAMPA BLANCA S.A.");
        jplLogeo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 40));
        jplLogeo.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, 240, 10));
        jplLogeo.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 225, 10));

        btnIngresar.setBackground(new java.awt.Color(0, 102, 0));
        btnIngresar.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(0, 102, 0));
        btnIngresar.setText("INGRESAR");
        btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        btnIngresar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnIngresarKeyReleased(evt);
            }
        });
        jplLogeo.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 490, 120, 50));
        jplLogeo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, 320, 0));

        btnCerrar.setBackground(new java.awt.Color(204, 0, 0));
        btnCerrar.setForeground(new java.awt.Color(204, 0, 0));
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Multiply_32px.png"))); // NOI18N
        btnCerrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 0), 1, true));
        btnCerrar.setBorderPainted(false);
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jplLogeo.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jplLogeo, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jplLogeo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        
        if(JOptionPane.showConfirmDialog(rootPane, "¿ Desea salir de la Aplicación ?", "¡ Alerta !", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void txtUserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtPassword.requestFocus();
        }
    }//GEN-LAST:event_txtUserKeyReleased

    private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnIngresar.requestFocus();
        }
    }//GEN-LAST:event_txtPasswordKeyReleased

    private void btnIngresarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnIngresarKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnIngresar.doClick();
        }
    }//GEN-LAST:event_btnIngresarKeyReleased

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        
        UsuarioLN usuarioln = new UsuarioLN();
        Usuario usuario = new Usuario();
        try{
            String user = txtUser.getText();
            String password = txtPassword.getText();
            usuario = usuarioln.validarUsuario(user,password);
            
            if(usuario.getTipousuario().equals("Administrador")){
                MenuAdministrador menuadmin = new MenuAdministrador(usuario);
                menuadmin.setVisible(true);
                menuadmin.setTitle("ADMINISTRADOR : " +usuario.toString());
                setVisible(false);
            }
            else if(usuario.getTipousuario().equals("Normal")){
                frmIngresoTransaccion ingresotrans = new frmIngresoTransaccion(usuario,"ingresar",null);
                ingresotrans.setVisible(true);
                ingresotrans.setTitle("USUARIO : " +usuario.toString());
                setVisible(false);
            } else if(usuario == null ) {
                JOptionPane.showMessageDialog(null, "Datos incorrectos ", "Error", JOptionPane.WARNING_MESSAGE);
            }
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Datos Incorrectos ", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnIngresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel jplLogeo;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
