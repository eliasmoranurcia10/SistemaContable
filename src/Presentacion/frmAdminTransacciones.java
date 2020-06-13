package Presentacion;

import Datos.Conexion;
import Entidades.Empresa;
import Entidades.Transaccion;
import Entidades.Usuario;
import LogicaNegocio.DetalleTransaccionLN;
import LogicaNegocio.EmpresaLN;
import LogicaNegocio.TransaccionLN;
import Modelo.mdlTransaccion;
import java.awt.Image;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


public class frmAdminTransacciones extends javax.swing.JFrame {

    private Usuario user;
    private TransaccionLN transaccionLN;
    private mdlTransaccion modelotransaccion;
    
    public frmAdminTransacciones(Usuario usuario) {
        initComponents();
        Image icon = new ImageIcon(getClass().getResource("/imagenes/transacciones.png")).getImage();
        setIconImage(icon);
        
        
        this.setLocationRelativeTo(null);
        lblNombreAdmin.setText(usuario.toString().toUpperCase());
        user = usuario;
        
        ObtenerFechaActual();
        VerPeriodo();
        ListarTransacciones();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnVolver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbTransacciones = new javax.swing.JTable();
        btnIngresarTransaccion = new javax.swing.JButton();
        btnModificarTransaccion = new javax.swing.JButton();
        btnEliminarTransaccion = new javax.swing.JButton();
        btnVerPdf = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblNombreAdmin = new javax.swing.JLabel();
        btnCambiarPeriodo = new javax.swing.JButton();
        lblFechaActual = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblFechaInicio = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblFechaFin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 0));
        jLabel1.setText("CENTRAL AZUCARERA CHUCARAPI PAMPA BLANCA S.A.");

        jSeparator1.setForeground(new java.awt.Color(0, 102, 0));

        btnVolver.setBackground(new java.awt.Color(153, 0, 0));
        btnVolver.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(153, 0, 0));
        btnVolver.setText("Volver");
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 0));
        jLabel2.setText("Listado de transacciones hechas en el periodo seleccionado");

        jtbTransacciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtbTransacciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(jtbTransacciones);

        btnIngresarTransaccion.setBackground(new java.awt.Color(0, 102, 0));
        btnIngresarTransaccion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnIngresarTransaccion.setForeground(new java.awt.Color(0, 102, 0));
        btnIngresarTransaccion.setText("INGRESAR");
        btnIngresarTransaccion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresarTransaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarTransaccionActionPerformed(evt);
            }
        });

        btnModificarTransaccion.setBackground(new java.awt.Color(0, 102, 0));
        btnModificarTransaccion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificarTransaccion.setForeground(new java.awt.Color(0, 102, 0));
        btnModificarTransaccion.setText("MODIFICAR");
        btnModificarTransaccion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificarTransaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarTransaccionActionPerformed(evt);
            }
        });

        btnEliminarTransaccion.setBackground(new java.awt.Color(0, 102, 0));
        btnEliminarTransaccion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEliminarTransaccion.setForeground(new java.awt.Color(0, 102, 0));
        btnEliminarTransaccion.setText("ELIMINAR");
        btnEliminarTransaccion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarTransaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTransaccionActionPerformed(evt);
            }
        });

        btnVerPdf.setBackground(new java.awt.Color(0, 102, 0));
        btnVerPdf.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnVerPdf.setForeground(new java.awt.Color(0, 102, 0));
        btnVerPdf.setText("VER PDF");
        btnVerPdf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerPdfActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel3.setText("ADMINISTRADOR :");

        lblNombreAdmin.setFont(new java.awt.Font("Times New Roman", 2, 11)); // NOI18N
        lblNombreAdmin.setText("ADMIN");

        btnCambiarPeriodo.setBackground(new java.awt.Color(255, 255, 0));
        btnCambiarPeriodo.setFont(new java.awt.Font("Times New Roman", 1, 8)); // NOI18N
        btnCambiarPeriodo.setForeground(new java.awt.Color(0, 102, 0));
        btnCambiarPeriodo.setText("CAMBIAR PERIODO");
        btnCambiarPeriodo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCambiarPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarPeriodoActionPerformed(evt);
            }
        });

        lblFechaActual.setFont(new java.awt.Font("Times New Roman", 3, 11)); // NOI18N
        lblFechaActual.setForeground(new java.awt.Color(0, 0, 153));
        lblFechaActual.setText("YYYY-MM-dd");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 0));
        jLabel4.setText("del");

        lblFechaInicio.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        lblFechaInicio.setForeground(new java.awt.Color(0, 51, 51));
        lblFechaInicio.setText("YYYY-MM-dd");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 0));
        jLabel6.setText("al");

        lblFechaFin.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        lblFechaFin.setForeground(new java.awt.Color(0, 51, 51));
        lblFechaFin.setText("YYYY-MM-dd");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnVolver)
                        .addContainerGap())
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(100, 100, 100))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblFechaActual)
                        .addGap(23, 23, 23))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnIngresarTransaccion)
                                .addGap(43, 43, 43)
                                .addComponent(btnModificarTransaccion)
                                .addGap(38, 38, 38)
                                .addComponent(btnVerPdf)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEliminarTransaccion))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(29, 29, 29)
                                        .addComponent(lblFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6)
                                        .addGap(29, 29, 29)
                                        .addComponent(lblFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addComponent(btnCambiarPeriodo))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(lblNombreAdmin)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFechaActual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblNombreAdmin))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(btnCambiarPeriodo))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblFechaInicio)
                    .addComponent(jLabel6)
                    .addComponent(lblFechaFin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresarTransaccion)
                    .addComponent(btnModificarTransaccion)
                    .addComponent(btnVerPdf)
                    .addComponent(btnEliminarTransaccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarTransaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarTransaccionActionPerformed
        frmIngresoTransaccion ingresoTransaccion = new frmIngresoTransaccion(user,"ingresar", null);
        ingresoTransaccion.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_btnIngresarTransaccionActionPerformed

    private void btnCambiarPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarPeriodoActionPerformed
        frmPeriodoContable frmContable = new frmPeriodoContable(user);
        frmContable.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCambiarPeriodoActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        
        MenuAdministrador menuAdministrador = new MenuAdministrador(user);
        menuAdministrador.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnModificarTransaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarTransaccionActionPerformed
        
        try {
            Transaccion transaccion = new Transaccion();
            
            int fila = jtbTransacciones.getSelectedRow();
            String idtransaccion = jtbTransacciones.getValueAt(fila, 0).toString();
            transaccion = transaccionLN.ConsultarporId(idtransaccion);
            
            
            frmIngresoTransaccion ingresoTransaccion = new frmIngresoTransaccion(user,"modificar",transaccion);
            ingresoTransaccion.setVisible(true);
            dispose();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione una transaccion", "Error", JOptionPane.WARNING_MESSAGE);
        }       
    }//GEN-LAST:event_btnModificarTransaccionActionPerformed

    private void btnEliminarTransaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTransaccionActionPerformed
        try {
            
            int fila = jtbTransacciones.getSelectedRow();
            
            if (fila != -1) {
                if(JOptionPane.showConfirmDialog(rootPane, "¿ Desea Eliminar esta Transacción incluido sus detalles ?", "¡ Alerta !", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                
                    Transaccion transaccion = new Transaccion();
                    transaccionLN = new TransaccionLN();
                    DetalleTransaccionLN detalleTransaccionLN = new DetalleTransaccionLN();


                    int idtransaccion = Integer.parseInt(jtbTransacciones.getValueAt(fila, 0).toString());

                    detalleTransaccionLN.BorrarDetallesTransaccionporIdTransaccion(idtransaccion);

                    transaccionLN.BorrarTransaccion(idtransaccion);
                    ListarTransacciones();

                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una transaccion", "Error", JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarTransaccionActionPerformed

    private void btnVerPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPdfActionPerformed

        Conexion conn = new Conexion();
        Connection conexion = conn.getConnection();
        
        try {
            String rutaReporte = System.getProperty("user.dir")+"/src/Reportes/rptTransacciones.jasper";
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/rptTransacciones.jasper"));
            JasperPrint jprint = JasperFillManager.fillReport(jasperReport,null ,conexion);
            JasperViewer view = new JasperViewer(jprint,false);
            view.setVisible(true);
            
        } catch (Exception e) {
            System.out.println("Error : " +e.getMessage());
        }
        
        
    }//GEN-LAST:event_btnVerPdfActionPerformed

    public void ObtenerFechaActual() {
        Date fechaactual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
        lblFechaActual.setText(formato.format(fechaactual));
    }
    public void ListarTransacciones(){
        
        transaccionLN = new TransaccionLN();
        this.modelotransaccion = new mdlTransaccion();
        
        jtbTransacciones.setModel(modelotransaccion);
        List<Transaccion> transacciones = null;
        
        try {
            transacciones = transaccionLN.ConsultarTransacciones("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
        }
        modelotransaccion.EstablecerTransacciones(transacciones);
        jtbTransacciones.requestFocus();
        
    }
    
    
    public void VerPeriodo() {
        try {
            Empresa empresa = new Empresa();
            EmpresaLN empresaLN = new EmpresaLN();
            empresa = empresaLN.VerEmpresa();
            lblFechaInicio.setText(empresa.getFechaInicio().toString());
            lblFechaFin.setText(empresa.getFechaFin().toString());
        } catch (Exception ex) {
            Logger.getLogger(frmPeriodoContable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(frmAdminTransacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(frmAdminTransacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(frmAdminTransacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(frmAdminTransacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new frmAdminTransacciones().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarPeriodo;
    private javax.swing.JButton btnEliminarTransaccion;
    private javax.swing.JButton btnIngresarTransaccion;
    private javax.swing.JButton btnModificarTransaccion;
    private javax.swing.JButton btnVerPdf;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jtbTransacciones;
    private javax.swing.JLabel lblFechaActual;
    private javax.swing.JLabel lblFechaFin;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel lblNombreAdmin;
    // End of variables declaration//GEN-END:variables
}
