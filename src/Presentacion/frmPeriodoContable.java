
package Presentacion;

import Entidades.Empresa;
import Entidades.Usuario;
import LogicaNegocio.EmpresaLN;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class frmPeriodoContable extends javax.swing.JFrame {

    private Usuario user;
    
    public frmPeriodoContable(Usuario usuario) {
        initComponents();
        Image icon = new ImageIcon(getClass().getResource("/imagenes/icons8_Today_96px.png")).getImage();
        setIconImage(icon);
        
        this.setLocationRelativeTo(null);
        
        lblAdmin.setText(usuario.toString().toUpperCase());
        user = usuario;
        
        ObtenerFechaActual();
        VerPeriodo();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo1 = new javax.swing.JLabel();
        lblFechaActual = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        llblInicioPeriodo = new javax.swing.JLabel();
        lblFinPeriodo = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblTitulo0 = new javax.swing.JLabel();
        lblAdmin = new javax.swing.JLabel();
        jmesIncioPeriodo = new com.toedter.calendar.JMonthChooser();
        jmesFinPeriodo = new com.toedter.calendar.JMonthChooser();
        jyearInicioPeriodo = new com.toedter.calendar.JYearChooser();
        jyearFinPeriodo = new com.toedter.calendar.JYearChooser();
        jLabel1 = new javax.swing.JLabel();
        lblFechaInicio = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblFechaFin = new javax.swing.JLabel();
        btnVerTransacciones = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 0), 2, true));

        lblTitulo1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(0, 102, 0));
        lblTitulo1.setText("PERIODO CONTABLE");

        lblFechaActual.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        lblFechaActual.setText("YYYY-MM-dd");

        jSeparator1.setForeground(new java.awt.Color(0, 102, 0));

        llblInicioPeriodo.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        llblInicioPeriodo.setForeground(new java.awt.Color(0, 51, 51));
        llblInicioPeriodo.setText("INICIO DE PERIODO :");

        lblFinPeriodo.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lblFinPeriodo.setForeground(new java.awt.Color(0, 51, 51));
        lblFinPeriodo.setText("FIN DE PERIODO :");

        btnModificar.setBackground(new java.awt.Color(0, 51, 51));
        btnModificar.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(0, 51, 51));
        btnModificar.setText("Modificar");
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(204, 0, 51));
        btnCancelar.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(204, 0, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblTitulo0.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblTitulo0.setText("Administrador: ");

        lblAdmin.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        lblAdmin.setText("*****");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 0));
        jLabel1.setText("del");

        lblFechaInicio.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblFechaInicio.setForeground(new java.awt.Color(0, 51, 51));
        lblFechaInicio.setText("FechaInicio");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 2, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 0));
        jLabel3.setText("al");

        lblFechaFin.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblFechaFin.setForeground(new java.awt.Color(0, 51, 51));
        lblFechaFin.setText("FechaFin");

        btnVerTransacciones.setBackground(new java.awt.Color(0, 51, 51));
        btnVerTransacciones.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnVerTransacciones.setForeground(new java.awt.Color(0, 51, 51));
        btnVerTransacciones.setText("Ver Transacciones");
        btnVerTransacciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerTransacciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTransaccionesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo0)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo1)
                .addGap(63, 63, 63))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(llblInicioPeriodo)
                    .addComponent(lblFinPeriodo)
                    .addComponent(btnModificar))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVerTransacciones)
                        .addGap(31, 31, 31)
                        .addComponent(btnCancelar)
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jmesIncioPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jmesFinPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jyearInicioPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jyearFinPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lblFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(31, 31, 31)
                .addComponent(lblFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo0)
                    .addComponent(lblAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitulo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(lblFechaFin)
                    .addComponent(lblFechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jmesIncioPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jyearInicioPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(llblInicioPeriodo, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jmesFinPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jyearFinPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFinPeriodo, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnCancelar)
                    .addComponent(btnVerTransacciones))
                .addGap(39, 39, 39))
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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        
        MenuAdministrador menuAdministrador = new MenuAdministrador(user);
        menuAdministrador.setVisible(true);
        
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int anioinicio = jyearInicioPeriodo.getValue();
        int mesinicio = jmesIncioPeriodo.getMonth()+1;
        int aniofin = jyearFinPeriodo.getValue();
        int mesfin = jmesFinPeriodo.getMonth()+1;
        
        
        try {
            
            if((anioinicio <= aniofin) &&  (mesinicio <= mesfin)){
                
                EmpresaLN empresaLN = new EmpresaLN();
        
                empresaLN.ActualizarPeriodoEmpresa(anioinicio, mesinicio, aniofin, mesfin);
        
                JOptionPane.showMessageDialog(null, "Periodo Actualizado Correctamente");
                VerPeriodo();
            }else {
                JOptionPane.showMessageDialog(null, "Error al elegir fechas ", "Error", JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Periodo No actualizado por error :" +e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnVerTransaccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTransaccionesActionPerformed
        frmAdminTransacciones frmtransacciones = new frmAdminTransacciones(user);
        frmtransacciones.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVerTransaccionesActionPerformed
    
    public void ObtenerFechaActual() {
        Date fechaactual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
        lblFechaActual.setText(formato.format(fechaactual));
    }
    public void VerPeriodo() {
        try {
            Empresa empresa = new Empresa();
            EmpresaLN empresaLN = new EmpresaLN();
            empresa = empresaLN.VerEmpresa();
            lblFechaInicio.setText(empresa.getFechaInicio().toString());
            lblFechaFin.setText(empresa.getFechaFin().toString());
            
            jmesIncioPeriodo.setMonth(empresa.getFechaInicio().getMonth());
            jyearInicioPeriodo.setYear(empresa.getFechaInicio().getYear() +1900);
            
            jmesFinPeriodo.setMonth(empresa.getFechaFin().getMonth());
            jyearFinPeriodo.setYear(empresa.getFechaFin().getYear() + 1900);
        } catch (Exception ex) {
            Logger.getLogger(frmPeriodoContable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnVerTransacciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private com.toedter.calendar.JMonthChooser jmesFinPeriodo;
    private com.toedter.calendar.JMonthChooser jmesIncioPeriodo;
    private com.toedter.calendar.JYearChooser jyearFinPeriodo;
    private com.toedter.calendar.JYearChooser jyearInicioPeriodo;
    private javax.swing.JLabel lblAdmin;
    private javax.swing.JLabel lblFechaActual;
    private javax.swing.JLabel lblFechaFin;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel lblFinPeriodo;
    private javax.swing.JLabel lblTitulo0;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel llblInicioPeriodo;
    // End of variables declaration//GEN-END:variables
}
