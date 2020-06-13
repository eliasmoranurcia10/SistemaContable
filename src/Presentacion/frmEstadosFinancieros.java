package Presentacion;

import Datos.Conexion;
import Entidades.Usuario;
import java.awt.Image;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class frmEstadosFinancieros extends javax.swing.JFrame {

    private Usuario user;
    public frmEstadosFinancieros(Usuario usuario) {
        initComponents();
        Image icon = new ImageIcon(getClass().getResource("/imagenes/Estados Financieros.png")).getImage();
        setIconImage(icon);
        
        this.setLocationRelativeTo(null);
        user = usuario;
        lblAdmin.setText("ADMINISTRADOR : " +user.toString().toUpperCase());
        ObtenerFechaActual();
    }
    public void ObtenerFechaActual(){
        Date fechaactual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd-MMM-YYYY");
        lblFechaActual.setText("FECHA :  "+formato.format(fechaactual));    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblAdmin = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblFechaActual = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        btnVariacionCC = new javax.swing.JButton();
        btnBalanceGeneral = new javax.swing.JButton();
        btnEstadoResultados = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 0), 2, true));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Azucarera.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 0));
        jLabel2.setText("ESTADOS FINANCIEROS");

        lblAdmin.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        lblAdmin.setForeground(new java.awt.Color(102, 0, 102));
        lblAdmin.setText("ADMINISTRADOR : ADMIN");

        jSeparator1.setForeground(new java.awt.Color(0, 102, 0));

        lblFechaActual.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        lblFechaActual.setForeground(new java.awt.Color(102, 0, 102));
        lblFechaActual.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFechaActual.setText("FECHA : YYYY-MM-dd");

        btnVolver.setBackground(new java.awt.Color(204, 0, 0));
        btnVolver.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(153, 0, 0));
        btnVolver.setText("Volver");
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnVariacionCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/EsradodeVariaciondeCC.png"))); // NOI18N
        btnVariacionCC.setContentAreaFilled(false);
        btnVariacionCC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVariacionCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVariacionCCActionPerformed(evt);
            }
        });

        btnBalanceGeneral.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BalanceGeneral.png"))); // NOI18N
        btnBalanceGeneral.setContentAreaFilled(false);
        btnBalanceGeneral.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBalanceGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBalanceGeneralActionPerformed(evt);
            }
        });

        btnEstadoResultados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/EstadodeResultados.png"))); // NOI18N
        btnEstadoResultados.setContentAreaFilled(false);
        btnEstadoResultados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEstadoResultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadoResultadosActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 102));
        jLabel3.setText("Estado de Resultados");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 102));
        jLabel4.setText("Estado de variación de");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 102));
        jLabel5.setText("Balance General");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 102));
        jLabel6.setText("Capital Contable");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2)
                        .addContainerGap(41, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblFechaActual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnVolver)))
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(btnEstadoResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVariacionCC, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5))
                    .addComponent(btnBalanceGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(btnVolver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVariacionCC)
                    .addComponent(btnEstadoResultados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBalanceGeneral)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        
        MenuAdministrador menu = new MenuAdministrador(user);
        menu.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnEstadoResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadoResultadosActionPerformed
        
        try {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection();
            String rutareporte = System.getProperty("user.dir")+"/src/Reportes/EstadoResultados.jasper";
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/EstadoResultados.jasper"));
            
            Map parametro = new HashMap();
            parametro.put("admin", "ADMINISTRADOR :  " +user.toString().toUpperCase());
            
            JasperPrint jprint = JasperFillManager.fillReport(jasperReport, parametro, conexion);
            JasperViewer view = new JasperViewer(jprint,false);
            view.setVisible(true);
            
        } catch (JRException ex) {
            Logger.getLogger(frmEstadosFinancieros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnEstadoResultadosActionPerformed

    private void btnVariacionCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVariacionCCActionPerformed

        try {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection();
            String rutareporte = System.getProperty("user.dir")+"/src/Reportes/rptEstadoVariacionCapitalContable.jasper";
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/rptEstadoVariacionCapitalContable.jasper"));
            
            Map parametro = new HashMap();
            parametro.put("admin", "ADMINISTRADOR :  " +user.toString().toUpperCase());
            
            JasperPrint jprint = JasperFillManager.fillReport(jasperReport, parametro, conexion);
            JasperViewer view = new JasperViewer(jprint,false);
            view.setVisible(true);
            
        } catch (JRException ex) {
            Logger.getLogger(frmEstadosFinancieros.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
    }//GEN-LAST:event_btnVariacionCCActionPerformed

    private void btnBalanceGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBalanceGeneralActionPerformed
   
        try {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection();
            String rutareporte = System.getProperty("user.dir")+"/src/Reportes/rptBalanceGeneral.jasper";
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/rptBalanceGeneral.jasper"));
            
            Map parametro = new HashMap();
            parametro.put("admin", "ADMINISTRADOR :  " +user.toString().toUpperCase());
            
            JasperPrint jprint = JasperFillManager.fillReport(jasperReport, parametro, conexion);
            JasperViewer view = new JasperViewer(jprint,false);
            view.setVisible(true);
            
        } catch (JRException ex) {
            Logger.getLogger(frmEstadosFinancieros.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }//GEN-LAST:event_btnBalanceGeneralActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBalanceGeneral;
    private javax.swing.JButton btnEstadoResultados;
    private javax.swing.JButton btnVariacionCC;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAdmin;
    private javax.swing.JLabel lblFechaActual;
    // End of variables declaration//GEN-END:variables
}
