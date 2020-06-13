package Presentacion;

import Datos.Conexion;
import Entidades.Cuenta;
import Entidades.Empresa;
import Entidades.Usuario;
import LogicaNegocio.CuentaLN;
import LogicaNegocio.EmpresaLN;
import java.awt.Image;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


public class MenuAdministrador extends javax.swing.JFrame {

    private Usuario user;

    
    public MenuAdministrador(Usuario usuario) {
        initComponents();
        Image icon = new ImageIcon(getClass().getResource("/imagenes/Azucarera.png")).getImage();
        setIconImage(icon);
        
        this.setLocationRelativeTo(null);
        
        lblNombreAdmin.setText(usuario.toString().toUpperCase());
        user = usuario;
        
        ObtenerFechaActual();
        
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblInsignia = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblTitulo1 = new javax.swing.JLabel();
        jspSeparador = new javax.swing.JSeparator();
        btnTransacciones = new javax.swing.JButton();
        btnPeriodocontable = new javax.swing.JButton();
        btnBalanceinicial = new javax.swing.JButton();
        btnLibrodiario = new javax.swing.JButton();
        btnEstadosfinancieros = new javax.swing.JButton();
        btnUsuarios = new javax.swing.JButton();
        btnLibromayor = new javax.swing.JButton();
        lblUsuarios = new javax.swing.JLabel();
        lblPeriodocontable = new javax.swing.JLabel();
        lblTransacciones = new javax.swing.JLabel();
        lblBalanceinicial = new javax.swing.JLabel();
        lblLibrodiario = new javax.swing.JLabel();
        lblLibromayor = new javax.swing.JLabel();
        lblEstadosfinancieros = new javax.swing.JLabel();
        btnCerrarsesion = new javax.swing.JButton();
        lblAdmin = new javax.swing.JLabel();
        lblNombreAdmin = new javax.swing.JLabel();
        btnCatalogoCuentas = new javax.swing.JButton();
        lblCatalogoCuentas = new javax.swing.JLabel();
        lblFechaActual = new javax.swing.JLabel();
        btnBalanzaComprobacion = new javax.swing.JButton();
        lblEstadosfinancieros1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 0), 2, true));

        lblInsignia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Azucarera.png"))); // NOI18N

        lblTitulo.setFont(new java.awt.Font("Times New Roman", 3, 30)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 102, 0));
        lblTitulo.setText("CHUCARAPI PAMPA BLANCA S.A.");

        lblTitulo1.setFont(new java.awt.Font("Times New Roman", 3, 28)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(0, 102, 0));
        lblTitulo1.setText("CENTRAL AZUCARERA");

        jspSeparador.setForeground(new java.awt.Color(0, 102, 0));

        btnTransacciones.setBackground(new java.awt.Color(255, 255, 255));
        btnTransacciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/transacciones.png"))); // NOI18N
        btnTransacciones.setBorder(null);
        btnTransacciones.setContentAreaFilled(false);
        btnTransacciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTransacciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransaccionesActionPerformed(evt);
            }
        });

        btnPeriodocontable.setBackground(new java.awt.Color(255, 255, 255));
        btnPeriodocontable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Today_96px.png"))); // NOI18N
        btnPeriodocontable.setBorder(null);
        btnPeriodocontable.setContentAreaFilled(false);
        btnPeriodocontable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPeriodocontable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeriodocontableActionPerformed(evt);
            }
        });

        btnBalanceinicial.setBackground(new java.awt.Color(255, 255, 255));
        btnBalanceinicial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/balance inicial2.png"))); // NOI18N
        btnBalanceinicial.setBorder(null);
        btnBalanceinicial.setBorderPainted(false);
        btnBalanceinicial.setContentAreaFilled(false);
        btnBalanceinicial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBalanceinicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBalanceinicialActionPerformed(evt);
            }
        });

        btnLibrodiario.setBackground(new java.awt.Color(255, 255, 255));
        btnLibrodiario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Libro diario.png"))); // NOI18N
        btnLibrodiario.setBorder(null);
        btnLibrodiario.setContentAreaFilled(false);
        btnLibrodiario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLibrodiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLibrodiarioActionPerformed(evt);
            }
        });

        btnEstadosfinancieros.setBackground(new java.awt.Color(255, 255, 255));
        btnEstadosfinancieros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Estados Financieros.png"))); // NOI18N
        btnEstadosfinancieros.setBorder(null);
        btnEstadosfinancieros.setContentAreaFilled(false);
        btnEstadosfinancieros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEstadosfinancieros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadosfinancierosActionPerformed(evt);
            }
        });

        btnUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_User_96px_2.png"))); // NOI18N
        btnUsuarios.setBorder(null);
        btnUsuarios.setContentAreaFilled(false);
        btnUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });

        btnLibromayor.setBackground(new java.awt.Color(255, 255, 255));
        btnLibromayor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/libro mayor2.png"))); // NOI18N
        btnLibromayor.setBorder(null);
        btnLibromayor.setBorderPainted(false);
        btnLibromayor.setContentAreaFilled(false);
        btnLibromayor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLibromayor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLibromayorActionPerformed(evt);
            }
        });

        lblUsuarios.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        lblUsuarios.setForeground(new java.awt.Color(0, 102, 0));
        lblUsuarios.setText("Usuarios");

        lblPeriodocontable.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        lblPeriodocontable.setForeground(new java.awt.Color(0, 102, 0));
        lblPeriodocontable.setText("Periodo Contable");

        lblTransacciones.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        lblTransacciones.setForeground(new java.awt.Color(0, 102, 0));
        lblTransacciones.setText("Transacciones");

        lblBalanceinicial.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        lblBalanceinicial.setForeground(new java.awt.Color(0, 102, 0));
        lblBalanceinicial.setText("Balance inicial");

        lblLibrodiario.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        lblLibrodiario.setForeground(new java.awt.Color(0, 102, 0));
        lblLibrodiario.setText("Libro diario");

        lblLibromayor.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        lblLibromayor.setForeground(new java.awt.Color(0, 102, 0));
        lblLibromayor.setText("Libro mayor");

        lblEstadosfinancieros.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        lblEstadosfinancieros.setForeground(new java.awt.Color(0, 102, 0));
        lblEstadosfinancieros.setText("Estados Financieros");

        btnCerrarsesion.setFont(new java.awt.Font("Times New Roman", 3, 11)); // NOI18N
        btnCerrarsesion.setForeground(new java.awt.Color(0, 102, 0));
        btnCerrarsesion.setText("Cerrar Sesión");
        btnCerrarsesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrarsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarsesionActionPerformed(evt);
            }
        });

        lblAdmin.setFont(new java.awt.Font("Times New Roman", 3, 11)); // NOI18N
        lblAdmin.setForeground(new java.awt.Color(0, 102, 0));
        lblAdmin.setText("ADMINISTRADOR : ");

        lblNombreAdmin.setFont(new java.awt.Font("Times New Roman", 3, 11)); // NOI18N
        lblNombreAdmin.setText("ADMINISTRADOR : ");

        btnCatalogoCuentas.setBackground(new java.awt.Color(255, 255, 255));
        btnCatalogoCuentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/catalogo.png"))); // NOI18N
        btnCatalogoCuentas.setBorder(null);
        btnCatalogoCuentas.setContentAreaFilled(false);
        btnCatalogoCuentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCatalogoCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCatalogoCuentasActionPerformed(evt);
            }
        });

        lblCatalogoCuentas.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        lblCatalogoCuentas.setForeground(new java.awt.Color(0, 102, 0));
        lblCatalogoCuentas.setText("Catálogo de Cuentas");

        lblFechaActual.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        lblFechaActual.setForeground(new java.awt.Color(0, 102, 0));
        lblFechaActual.setText("**-**-****");

        btnBalanzaComprobacion.setBackground(new java.awt.Color(255, 255, 255));
        btnBalanzaComprobacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/balanzadecomprobacion.png"))); // NOI18N
        btnBalanzaComprobacion.setBorder(null);
        btnBalanzaComprobacion.setBorderPainted(false);
        btnBalanzaComprobacion.setContentAreaFilled(false);
        btnBalanzaComprobacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBalanzaComprobacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBalanzaComprobacionActionPerformed(evt);
            }
        });

        lblEstadosfinancieros1.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        lblEstadosfinancieros1.setForeground(new java.awt.Color(0, 102, 0));
        lblEstadosfinancieros1.setText("Balanza Comprobación");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jspSeparador)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnLibromayor)
                                        .addComponent(btnTransacciones, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(98, 98, 98)
                                        .addComponent(lblPeriodocontable))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(73, 73, 73)
                                        .addComponent(btnPeriodocontable, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(73, 73, 73)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnBalanceinicial, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                            .addComponent(lblEstadosfinancieros1)
                                            .addComponent(btnBalanzaComprobacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(lblUsuarios))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(lblLibromayor)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLibrodiario, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCatalogoCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCatalogoCuentas)
                            .addComponent(lblEstadosfinancieros)))
                    .addComponent(btnEstadosfinancieros))
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNombreAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(220, 220, 220))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblAdmin))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblInsignia)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(77, 77, 77)
                                        .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCerrarsesion)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(lblTransacciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblBalanceinicial)
                .addGap(130, 130, 130)
                .addComponent(lblLibrodiario)
                .addGap(86, 86, 86))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblFechaActual)
                                .addGap(38, 38, 38))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblTitulo1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(lblTitulo))
                    .addComponent(lblInsignia, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jspSeparador, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdmin)
                    .addComponent(lblNombreAdmin))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(btnPeriodocontable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCatalogoCuentas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuarios)
                    .addComponent(lblPeriodocontable)
                    .addComponent(lblCatalogoCuentas))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnLibrodiario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBalanceinicial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                    .addComponent(btnTransacciones, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblBalanceinicial)
                        .addComponent(lblLibrodiario))
                    .addComponent(lblTransacciones))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLibromayor, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLibromayor)
                            .addComponent(lblEstadosfinancieros1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnEstadosfinancieros, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblEstadosfinancieros)
                                .addGap(13, 13, 13)
                                .addComponent(btnCerrarsesion))
                            .addComponent(btnBalanzaComprobacion, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

    private void btnCerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarsesionActionPerformed
        
        if(JOptionPane.showConfirmDialog(rootPane, "¿Desea cerrar Sesión?", "¡ Alerta !", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            
            frmLogin frmlogin = new frmLogin();
            frmlogin.setVisible(true);
            dispose();
        }
        
        
    }//GEN-LAST:event_btnCerrarsesionActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed

        frmUsuarios frmusuarios = new frmUsuarios(user);
        frmusuarios.setVisible(true);
        String administrador = "";
        administrador = this.getTitle().toString();
        frmusuarios.setTitle(administrador);
        dispose();
        
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnTransaccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransaccionesActionPerformed
        
        
        frmAdminTransacciones frmaadmintransacciones = new frmAdminTransacciones(user);
        frmaadmintransacciones.setVisible(true);
        String administrador = "";
        administrador = this.getTitle().toString();
        frmaadmintransacciones.setTitle(administrador);
        dispose();
    }//GEN-LAST:event_btnTransaccionesActionPerformed

    private void btnPeriodocontableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeriodocontableActionPerformed
        frmPeriodoContable frmperiodocontable = new frmPeriodoContable(user);
        frmperiodocontable.setVisible(true);
        String administrador = "";
        administrador = this.getTitle().toString();
        frmperiodocontable.setTitle(administrador);
        dispose();
        
    }//GEN-LAST:event_btnPeriodocontableActionPerformed

    private void btnBalanceinicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBalanceinicialActionPerformed

        try {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection();

            String rutaReporte = System.getProperty("user.dir")+"/src/Reportes/rptBalanceInicial.jasper";
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/rptBalanceInicial.jasper"));
            
            String sumadebe = conn.VerSumaSaldosInicialesDebe();
            String sumahaber = conn.VerSumaSaldosInicialesHaber();
            
            Map parametro = new HashMap();
            parametro.put("administrador",user.toString().toUpperCase() );
            parametro.put("sumasaldodebe", sumadebe);
            parametro.put("sumasaldohaber", sumahaber);
            
            JasperPrint jprint = JasperFillManager.fillReport(jasperReport, parametro, conexion);
            JasperViewer view = new JasperViewer(jprint,false);
            view.setVisible(true);
            
            
        } catch (Exception ex) {
            Logger.getLogger(MenuAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnBalanceinicialActionPerformed

    private void btnLibrodiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLibrodiarioActionPerformed
        
        try {
            
            EmpresaLN empresaLN = new EmpresaLN();
            Empresa empresa = new Empresa();
            
            empresa = empresaLN.VerEmpresa();
            
            
            try {
                Conexion conn = new Conexion();
                Connection conexion = conn.getConnection();
                
                String rutaReporte = System.getProperty("user.dir")+"/src/Reportes/rptLibroDiario.jasper";
                JasperReport jasperReport = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/rptLibroDiario.jasper"));
                
                
                Map parametro = new HashMap();
                parametro.put("inicioperiodo", empresa.getFechaInicio().toString());
                parametro.put("finperiodo", empresa.getFechaFin().toString());
                parametro.put("admin", user.toString().toUpperCase());
                
                JasperPrint jprint = JasperFillManager.fillReport(jasperReport, parametro, conexion);
                JasperViewer view = new JasperViewer(jprint,false);
                view.setVisible(true);
                
                
            } catch (Exception ex) {
                Logger.getLogger(MenuAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(MenuAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_btnLibrodiarioActionPerformed

    private void btnLibromayorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLibromayorActionPerformed

        try {
            Conexion  conn = new Conexion();
            Connection conexion = conn.getConnection();
            String rutaReporte = System.getProperty("user.dir")+"/src/Reportes/rptMayorGeneral.jasper";
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/rptMayorGeneral.jasper"));
            
            Map parametro = new HashMap();
            parametro.put("admin", user.toString().toUpperCase());
            
            JasperPrint jprint = JasperFillManager.fillReport(jasperReport, parametro, conexion);
            JasperViewer view = new JasperViewer(jprint,false);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(MenuAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnLibromayorActionPerformed

    private void btnEstadosfinancierosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadosfinancierosActionPerformed
        frmEstadosFinancieros frmFinancieros = new frmEstadosFinancieros(user);
        frmFinancieros.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnEstadosfinancierosActionPerformed

    private void btnCatalogoCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatalogoCuentasActionPerformed
        frmCatalogoCtas frmCtas = new frmCatalogoCtas(user);
        frmCtas.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCatalogoCuentasActionPerformed

    private void btnBalanzaComprobacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBalanzaComprobacionActionPerformed

        try {
            List<Integer> Sumadebehaber = new ArrayList<>();
            Conexion conn = new Conexion();
            
            Sumadebehaber = conn.ConsultarTotalesDebeHaber();
            
            Connection conexion = conn.getConnection();
            String rutaReporte = System.getProperty("user.dir")+"/src/Reportes/rptBalanzaComprobacion.jasper";
            JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/rptBalanzaComprobacion.jasper"));
            
            Map parametro = new HashMap();
            parametro.put("admin", user.toString().toUpperCase());
            parametro.put("totaldebe", Sumadebehaber.get(0).toString());
            parametro.put("totalhaber", Sumadebehaber.get(1).toString());
            
            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, conexion);
            JasperViewer view = new JasperViewer(jprint,false);
            view.setVisible(true);
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(MenuAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnBalanzaComprobacionActionPerformed

    public void ObtenerFechaActual(){
        Date fechaactual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd-MMM-YYYY");
        lblFechaActual.setText(formato.format(fechaactual));    
    }

//    public static void main(String args[]) {
//
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MenuAdministrador().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBalanceinicial;
    private javax.swing.JButton btnBalanzaComprobacion;
    private javax.swing.JButton btnCatalogoCuentas;
    private javax.swing.JButton btnCerrarsesion;
    private javax.swing.JButton btnEstadosfinancieros;
    private javax.swing.JButton btnLibrodiario;
    private javax.swing.JButton btnLibromayor;
    private javax.swing.JButton btnPeriodocontable;
    private javax.swing.JButton btnTransacciones;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jspSeparador;
    private javax.swing.JLabel lblAdmin;
    private javax.swing.JLabel lblBalanceinicial;
    private javax.swing.JLabel lblCatalogoCuentas;
    private javax.swing.JLabel lblEstadosfinancieros;
    private javax.swing.JLabel lblEstadosfinancieros1;
    private javax.swing.JLabel lblFechaActual;
    private javax.swing.JLabel lblInsignia;
    private javax.swing.JLabel lblLibrodiario;
    private javax.swing.JLabel lblLibromayor;
    private javax.swing.JLabel lblNombreAdmin;
    private javax.swing.JLabel lblPeriodocontable;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTransacciones;
    private javax.swing.JLabel lblUsuarios;
    // End of variables declaration//GEN-END:variables
}
