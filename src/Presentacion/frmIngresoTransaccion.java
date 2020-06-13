package Presentacion;

import Datos.Conexion;
import Entidades.Cuenta;
import Entidades.DetalleTransaccion;
import Entidades.Naturaleza;
import Entidades.Subcuenta;
import Entidades.Transaccion;
import Entidades.Usuario;
import LogicaNegocio.CuentaLN;
import LogicaNegocio.DetalleTransaccionLN;
import LogicaNegocio.NaturalezaLN;
import LogicaNegocio.SubcuentaLN;
import LogicaNegocio.TransaccionLN;
import Modelo.mdlDetalleTransaccion;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class frmIngresoTransaccion extends javax.swing.JFrame {
   
    private Usuario user;
    private TransaccionLN transaccionLN;
    private CuentaLN cuentaLN;
    private SubcuentaLN subcuentaLN;
    private NaturalezaLN naturalezaLN;
    private DetalleTransaccionLN detalleTransaccionLN;
    private mdlDetalleTransaccion modelodetalles;
    
    private boolean ingresartransaccion;
            
    public frmIngresoTransaccion(Usuario usuario, String acción, Transaccion transaccion) {
        initComponents();
        Image icon = new ImageIcon(getClass().getResource("/imagenes/transacciones.png")).getImage();
        setIconImage(icon);
        
        this.setLocationRelativeTo(null);
        
        lblNombreUsuario.setText(usuario.toString().toUpperCase());
        user = usuario;
        
        txtIdtransaccion.setEditable(false);
        txtFechaActual.setEditable(false);
        txtTotalDebe.setEditable(false);
        txtTotalHaber.setEditable(false);
        
        if(acción.equals("ingresar") && transaccion == null) {
            lblTituloAccion.setText("INGRESO DE TRANSACCIÓN");
            this.ingresartransaccion = true;
            SiguienteTransaccion();
            
            ObtenerFechaActual();
            
            
        } else if(acción.equals("modificar")) {
            lblTituloAccion.setText("MODIFICACIÓN DE TRANSACCIÓN");
            this.ingresartransaccion = false;
            txtIdtransaccion.setText(Integer.toString(transaccion.getIdTransaccion()));
            txtFechaActual.setText(transaccion.getFecha().toString());
            txtDescripcion.setText(transaccion.getDescripcion());
            
            ListarDetallestransaccion(transaccion.getIdTransaccion());
            TotalDebeyTotalHaber(transaccion.getIdTransaccion());
            
        }
        
        ListarCuentasenCombobox();
        ListarSubcuentasenCombobox("");
        ListarNaturalezaenCombobox();
                
    }
    public void SiguienteTransaccion() {
        Conexion conn = new Conexion();
        
        try {
            txtIdtransaccion.setText(Integer.toString(conn.SiguienteIdTransaccion()));
        } catch (Exception ex) {
            Logger.getLogger(frmIngresoTransaccion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void ObtenerFechaActual() {
        Date fechaactual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
        txtFechaActual.setText(formato.format(fechaactual));
    }
    public void ListarCuentasenCombobox(){
        
        cuentaLN = new CuentaLN();
        List<Cuenta> cuentas = null;
        
        try {
            cuentas = cuentaLN.ConsultarCuentas("", "");
            cboNombreCuenta.addItem("Seleccionar...");
            
            for (int i = 0; i < cuentas.size(); i++) {
                cboNombreCuenta.addItem(cuentas.get(i).getNombreCuenta());
                
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
        }   
    }
    public void ListarSubcuentasenCombobox(String codcta) {
        subcuentaLN = new SubcuentaLN();
        List<Subcuenta> subcuentas = null;
        
        try {
            subcuentas = subcuentaLN.ConsultarSubcuentas(codcta);
            
            cboNombreSubcuenta.addItem("Seleccionar...");
            
            for (int i = 0; i < subcuentas.size(); i++) {
                cboNombreSubcuenta.addItem(subcuentas.get(i).getNombreSubcuenta());
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
        }
        
    }
    public void ListarNaturalezaenCombobox(){
        naturalezaLN = new NaturalezaLN();
        List<Naturaleza> naturalezas = null;
        
        try {
            naturalezas = naturalezaLN.ConsultarNaturaleza();
            
            cboNaturaleza.addItem("Seleccionar...");
            
            for (int i = 0; i < naturalezas.size(); i++) {
                cboNaturaleza.addItem(naturalezas.get(i).getIdNaturaleza());
                
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
        }
        
    }
    
    public void ListarDetallestransaccion(int patron) {
        detalleTransaccionLN = new DetalleTransaccionLN();
        this.modelodetalles = new mdlDetalleTransaccion();
        tblDetallesTransaccion.setModel(modelodetalles);
        List<DetalleTransaccion> detalles = null;
        
        try {
            detalles = detalleTransaccionLN.ConsultarDetallesTransaccion(patron);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
        }
        
        modelodetalles.EstablecerDetallesTransaccion(detalles);
        tblDetallesTransaccion.requestFocus();
        
    }
    
    public void TotalDebeyTotalHaber(int patron) {
        String numerodebe = "";
        String numerohaber = "";
        Conexion conn = new Conexion();
        try {
            numerodebe = conn.TotalDebeTransaccion(patron);
            numerohaber = conn.TotalHaberTransaccion(patron);
            txtTotalDebe.setText(numerodebe);
            txtTotalHaber.setText(numerohaber);
            
            if(txtTotalDebe.getText().equals(txtTotalHaber.getText())) {
                txtTotalDebe.setBackground(Color.green);
                txtTotalHaber.setBackground(Color.green);
            } else {
                txtTotalDebe.setBackground(Color.red);
                txtTotalHaber.setBackground(Color.red);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Transacción cuyo estado faltan detalles ","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
        }        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        lblTituloAccion = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblNombreUsuario = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIdtransaccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtFechaActual = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        txtCodigoCuenta = new javax.swing.JTextField();
        btnBuscarCuenta = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cboNombreCuenta = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        cboNombreSubcuenta = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cboNaturaleza = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        btnAgregarDetalleTrans = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetallesTransaccion = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtTotalDebe = new javax.swing.JTextField();
        txtTotalHaber = new javax.swing.JTextField();
        btnAceptarTransaccion = new javax.swing.JButton();
        btnModificarTrans = new javax.swing.JButton();
        btnEliminarTrans = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblCodigoSubcuenta = new javax.swing.JLabel();
        txtCodigoSubcuenta = new javax.swing.JTextField();
        btnBuscarSubcuenta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 0), 2, true));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Azucarera.png"))); // NOI18N

        jSeparator1.setForeground(new java.awt.Color(0, 102, 0));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("CENTRAL AZUCARERA CHUCARAPI PAMPA BLANCA S.A.");

        lblTituloAccion.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        lblTituloAccion.setForeground(new java.awt.Color(0, 102, 0));
        lblTituloAccion.setText("ACCIÓN");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 0));
        jLabel4.setText("USUARIO :");

        lblNombreUsuario.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        lblNombreUsuario.setText("jLabel5");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("N° Transacción  : ");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setText("Fecha  :");

        txtFechaActual.setText("YYYY-MM-dd");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setText("Descripción  :");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setText("Código cuenta  :");

        txtCodigoCuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoCuentaKeyReleased(evt);
            }
        });

        btnBuscarCuenta.setFont(new java.awt.Font("Times New Roman", 3, 11)); // NOI18N
        btnBuscarCuenta.setText("buscar Cuenta");
        btnBuscarCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCuentaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel9.setText("Nombre de la cuenta :");

        cboNombreCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cboNombreCuenta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboNombreCuentaItemStateChanged(evt);
            }
        });
        cboNombreCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboNombreCuentaMouseClicked(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(0, 102, 0));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel10.setText("Nombre Subcuenta  : ");

        cboNombreSubcuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cboNombreSubcuenta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboNombreSubcuentaItemStateChanged(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel11.setText("Naturaleza  : ");

        cboNaturaleza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNaturalezaActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel12.setText("Monto  :");

        btnAgregarDetalleTrans.setText("AGREGAR");
        btnAgregarDetalleTrans.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarDetalleTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarDetalleTransActionPerformed(evt);
            }
        });

        tblDetallesTransaccion.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        tblDetallesTransaccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblDetallesTransaccion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblDetallesTransaccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDetallesTransaccionMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDetallesTransaccion);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel13.setText("Totales  :");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel14.setText("Debe");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel15.setText("Haber");

        txtTotalDebe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalDebeActionPerformed(evt);
            }
        });

        txtTotalHaber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalHaberActionPerformed(evt);
            }
        });

        btnAceptarTransaccion.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnAceptarTransaccion.setText("ACEPTAR");
        btnAceptarTransaccion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptarTransaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarTransaccionActionPerformed(evt);
            }
        });

        btnModificarTrans.setText("MODIFICAR");
        btnModificarTrans.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificarTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarTransActionPerformed(evt);
            }
        });

        btnEliminarTrans.setText("ELIMINAR");
        btnEliminarTrans.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTransActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 0));
        jLabel3.setText("DETALLE DE LA TRANSACCIÓN");

        lblCodigoSubcuenta.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblCodigoSubcuenta.setText("Código Subcuenta  : ");

        txtCodigoSubcuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoSubcuentaKeyReleased(evt);
            }
        });

        btnBuscarSubcuenta.setFont(new java.awt.Font("Times New Roman", 3, 11)); // NOI18N
        btnBuscarSubcuenta.setText("buscar Subcuenta");
        btnBuscarSubcuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarSubcuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarSubcuentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(lblNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(395, 395, 395)
                        .addComponent(lblTituloAccion))))
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1471, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(lblCodigoSubcuenta))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCodigoSubcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscarSubcuenta))
                    .addComponent(cboNombreCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdtransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboNombreSubcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCodigoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscarCuenta)))
                .addGap(130, 130, 130)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addGap(60, 60, 60)
                        .addComponent(cboNaturaleza, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addGap(88, 88, 88)
                        .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(txtTotalDebe, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(txtTotalHaber, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(btnAceptarTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAgregarDetalleTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97)
                                .addComponent(btnModificarTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84)
                                .addComponent(btnEliminarTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(41, 41, 41)
                                .addComponent(jLabel14)
                                .addGap(171, 171, 171)
                                .addComponent(jLabel15))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(11, 11, 11)
                        .addComponent(lblTituloAccion)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(lblNombreUsuario)))))
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(cboNaturaleza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnModificarTrans)
                                    .addComponent(btnEliminarTrans)
                                    .addComponent(btnAgregarDetalleTrans))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel15))))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTotalDebe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTotalHaber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addComponent(btnAceptarTransaccion)))
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtIdtransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(txtFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel5)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel6)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel7)))
                        .addGap(32, 32, 32)
                        .addComponent(jLabel3)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarCuenta)
                            .addComponent(jLabel8))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(cboNombreCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCodigoSubcuenta)
                            .addComponent(txtCodigoSubcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarSubcuenta))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(cboNombreSubcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1087, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTotalDebeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalDebeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalDebeActionPerformed

    private void txtTotalHaberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalHaberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalHaberActionPerformed

    private void btnAceptarTransaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarTransaccionActionPerformed

        frmAdminTransacciones frmadAdminTransacciones = new frmAdminTransacciones(user);
        frmLogin frmlogin = new frmLogin();
        
        if (txtTotalDebe.getText().equals(txtTotalHaber.getText())) {
        
            if(user.getTipousuario().equals("Administrador")) {
                
                frmadAdminTransacciones.setVisible(true);
                dispose();
            } else{
                if(JOptionPane.showConfirmDialog(rootPane, "¿ Desea cerrar sesión ?", "¡ Alerta !", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    
                    frmlogin.setVisible(true);
                    dispose();
                } 
            }
            
        } else {
            JOptionPane.showMessageDialog(null," Montos del deudor y acreedor no cuadran ","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarTransaccionActionPerformed

    private void btnBuscarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCuentaActionPerformed
        
        cuentaLN = new CuentaLN();
        try {
            
            Cuenta cuenta = cuentaLN.ConsultarCuentaporCodigo(Integer.parseInt(txtCodigoCuenta.getText()));
            if(cuenta.getCodigoCuenta() != 0) {
                cboNombreCuenta.setSelectedItem(cuenta.getNombreCuenta());
            } else {
                cboNombreCuenta.setSelectedItem("Seleccionar...");
                JOptionPane.showMessageDialog(null,"Cuenta no encontrada","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
                txtCodigoCuenta.setText("");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Cuenta no encontrada","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
            
        }
        
        
    }//GEN-LAST:event_btnBuscarCuentaActionPerformed

    private void cboNombreCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboNombreCuentaMouseClicked
                
    }//GEN-LAST:event_cboNombreCuentaMouseClicked

    private void cboNombreCuentaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboNombreCuentaItemStateChanged

        cuentaLN = new CuentaLN();
        Cuenta cuenta;
        
        try {
            if (!cboNombreCuenta.getSelectedItem().equals("Seleccionar...")) {
                cuenta = cuentaLN.ConsultarCuentaporNombre(cboNombreCuenta.getSelectedItem().toString());
                if(!Integer.toString(cuenta.getCodigoCuenta()).equals("0")) {
                    txtCodigoCuenta.setText(Integer.toString(cuenta.getCodigoCuenta()));
                    cboNombreSubcuenta.removeAllItems();
                    ListarSubcuentasenCombobox(Integer.toString(cuenta.getCodigoCuenta()));
                }
                
            } else {
                txtCodigoCuenta.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Cuenta no encontrada","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_cboNombreCuentaItemStateChanged

    private void txtCodigoCuentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoCuentaKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnBuscarCuenta.doClick();
            cboNombreCuenta.requestFocus();
        }
    }//GEN-LAST:event_txtCodigoCuentaKeyReleased

    private void cboNaturalezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNaturalezaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboNaturalezaActionPerformed

    private void btnAgregarDetalleTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarDetalleTransActionPerformed

        transaccionLN = new TransaccionLN();
        SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
        
        if(ingresartransaccion) {
            
            if(!txtDescripcion.getText().equals("")) {
                
                try {
                    Transaccion transaccion = new Transaccion();
                    
                    transaccion.setIdTransaccion(Integer.parseInt(txtIdtransaccion.getText()));
                    Date fechaactual = new Date();
                    transaccion.setFecha(fechaactual);                    
                    transaccion.setDescripcion(txtDescripcion.getText().toString());
                    
                    transaccionLN.RegistrarTransaccion(transaccion);
                    ingresartransaccion = false;
                    txtDescripcion.setEditable(false);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,e.getMessage(),"Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null,"Falta Agregar Descripción","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
            }
        }
        if(ingresartransaccion == false) {
            if( !txtCodigoCuenta.getText().equals("") && (cboNombreCuenta.getSelectedIndex() != 0) &&
                !txtCodigoSubcuenta.getText().equals("") && (cboNombreSubcuenta.getSelectedIndex() != 0) &&
                (cboNaturaleza.getSelectedIndex() != 0 ) && !txtMonto.getText().equals("")  ){
                
                DetalleTransaccion detalleTransaccion = new DetalleTransaccion();
                detalleTransaccionLN = new DetalleTransaccionLN();
                
                try {
                    Transaccion transaccion = new Transaccion();
                    transaccion.setIdTransaccion(Integer.parseInt(txtIdtransaccion.getText()));
                    detalleTransaccion.setoTransaccion(transaccion);
                    
                    Naturaleza naturaleza = new Naturaleza();
                    naturaleza.setIdNaturaleza(cboNaturaleza.getSelectedItem().toString());
                    detalleTransaccion.setoNaturaleza(naturaleza);
                    
                    Cuenta cuenta = new Cuenta();
                    cuenta.setCodigoCuenta(Integer.parseInt(txtCodigoCuenta.getText()));
                    cuenta.setNombreCuenta(cboNombreCuenta.getSelectedItem().toString());
                    detalleTransaccion.setoCuenta(cuenta);
                    
                    Subcuenta subcuenta = new Subcuenta();
                    subcuenta.setCodigoSubcuenta(Integer.parseInt(txtCodigoSubcuenta.getText()));
                    subcuenta.setNombreSubcuenta(cboNombreSubcuenta.getSelectedItem().toString());
                    detalleTransaccion.setoSubcuenta(subcuenta);
                    
                    detalleTransaccion.setMonto(Integer.parseInt(txtMonto.getText()));
                    
                    detalleTransaccionLN.RegistrarDetalleTransaccion(detalleTransaccion);
                    ListarDetallestransaccion(transaccion.getIdTransaccion());
                    TotalDebeyTotalHaber(transaccion.getIdTransaccion());
                    
                   txtCodigoCuenta.setText("");
                   cboNombreCuenta.setSelectedIndex(0);
                   txtCodigoSubcuenta.setText("");
                   cboNombreSubcuenta.setSelectedIndex(0);
                   cboNaturaleza.setSelectedIndex(0);
                   txtMonto.setText("");
                    
                } catch (Exception e) {
                }
                
                
            } else {
                JOptionPane.showMessageDialog(null, " Ingrese Detalles de la Transacción ");
                txtCodigoCuenta.requestFocus();
            }
            
        }
        
        
    }//GEN-LAST:event_btnAgregarDetalleTransActionPerformed

    private void txtCodigoSubcuentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoSubcuentaKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnBuscarSubcuenta.doClick();
            cboNombreSubcuenta.requestFocus();
        }
    }//GEN-LAST:event_txtCodigoSubcuentaKeyReleased

    private void btnBuscarSubcuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarSubcuentaActionPerformed
        subcuentaLN = new SubcuentaLN();
        
        try {
            Subcuenta subcuenta = subcuentaLN.ConsultarSubcuentaporCodigo(Integer.parseInt(txtCodigoSubcuenta.getText()));
            
            if(!subcuenta.getNombreSubcuenta().equals("")) {
                cboNombreSubcuenta.setSelectedItem(subcuenta.getNombreSubcuenta());
            } else {
                JOptionPane.showMessageDialog(null,"Sucuenta no encontrada","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Sucuenta no encontrada","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarSubcuentaActionPerformed

    private void cboNombreSubcuentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboNombreSubcuentaKeyReleased

    }//GEN-LAST:event_cboNombreSubcuentaKeyReleased

    private void cboNombreSubcuentaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboNombreSubcuentaItemStateChanged

        subcuentaLN = new SubcuentaLN();
        Subcuenta subcuenta = new Subcuenta();
        
        try {
            subcuenta = subcuentaLN.ConsultarSubcuentaporNombre(cboNombreSubcuenta.getSelectedItem().toString());
            if(subcuenta.getCodigoSubcuenta() != 0) {
                txtCodigoSubcuenta.setText(Integer.toString(subcuenta.getCodigoSubcuenta()));
                txtCodigoCuenta.setText(Integer.toString(subcuenta.getoCuenta().getCodigoCuenta()));
                btnBuscarCuenta.doClick();
            }
        } catch (Exception e) {
        }
        

    }//GEN-LAST:event_cboNombreSubcuentaItemStateChanged

    private void tblDetallesTransaccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetallesTransaccionMouseClicked
        
        DetalleTransaccion detalleTransaccion = new DetalleTransaccion();
        detalleTransaccionLN = new DetalleTransaccionLN();
        
        try {
            int fila = tblDetallesTransaccion.getSelectedRow();
            int Id = Integer.parseInt(tblDetallesTransaccion.getValueAt(fila,0).toString());
            
            detalleTransaccion = detalleTransaccionLN.ConsultarDetalleTransaccionporId(Id);
            
            txtCodigoCuenta.setText(Integer.toString(detalleTransaccion.getoCuenta().getCodigoCuenta()));
            btnBuscarCuenta.doClick();
            txtCodigoSubcuenta.setText(Integer.toString(detalleTransaccion.getoSubcuenta().getCodigoSubcuenta()));
            btnBuscarSubcuenta.doClick();
            cboNaturaleza.setSelectedItem(detalleTransaccion.getoNaturaleza().getIdNaturaleza());
            txtMonto.setText(Integer.toString(detalleTransaccion.getMonto()));
            
            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, ""+e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_tblDetallesTransaccionMouseClicked

    private void btnModificarTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarTransActionPerformed

        if(ingresartransaccion == false) {
            int fila = tblDetallesTransaccion.getSelectedRow();
            
            if(fila == -1) {
                try {
                    Transaccion transaccion = new Transaccion();
                    transaccionLN = new TransaccionLN();
                    SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
                    if(!txtDescripcion.getText().equals("")) {
                        transaccion.setIdTransaccion(Integer.parseInt(txtIdtransaccion.getText()));
                        transaccion.setFecha(formato.parse(txtFechaActual.getText()));
                        transaccion.setDescripcion(txtDescripcion.getText());
                                                
                        transaccionLN.ModificarTransaccion(transaccion);                        
                        JOptionPane.showMessageDialog(null, "Seleccione un Detalle de la transacción para modificarlo ");
                        
                    } else {
                        JOptionPane.showMessageDialog(null,"Falta Agregar Descripción","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
                    }
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,e.getMessage(),"Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
                }
                
            } else if (fila != -1) {
                try {
                    
                    if( !txtCodigoCuenta.getText().equals("") && (cboNombreCuenta.getSelectedIndex() != 0) &&
                    !txtCodigoSubcuenta.getText().equals("") && (cboNombreSubcuenta.getSelectedIndex() != 0) &&
                    (cboNaturaleza.getSelectedIndex() != 0 ) && !txtMonto.getText().equals("")  ){
                    
                        int Id = Integer.parseInt(tblDetallesTransaccion.getValueAt(fila,0).toString());
                        DetalleTransaccion detalleTransaccion = new DetalleTransaccion();
                        detalleTransaccionLN = new DetalleTransaccionLN();

                        detalleTransaccion.setIdDetalle(Id);

                        Transaccion transaccion = new Transaccion();
                        transaccion.setIdTransaccion(Integer.parseInt(txtIdtransaccion.getText()));
                        detalleTransaccion.setoTransaccion(transaccion);

                        Naturaleza naturaleza = new Naturaleza();
                        naturaleza.setIdNaturaleza(cboNaturaleza.getSelectedItem().toString());
                        detalleTransaccion.setoNaturaleza(naturaleza);

                        Cuenta cuenta = new Cuenta();
                        cuenta.setCodigoCuenta(Integer.parseInt(txtCodigoCuenta.getText()));
                        cuenta.setNombreCuenta(cboNombreCuenta.getSelectedItem().toString());
                        detalleTransaccion.setoCuenta(cuenta);

                        Subcuenta subcuenta = new Subcuenta();
                        subcuenta.setCodigoSubcuenta(Integer.parseInt(txtCodigoSubcuenta.getText()));
                        subcuenta.setNombreSubcuenta(cboNombreSubcuenta.getSelectedItem().toString());
                        detalleTransaccion.setoSubcuenta(subcuenta);

                        detalleTransaccion.setMonto(Integer.parseInt(txtMonto.getText()));

                        detalleTransaccionLN.ModificarDetalleTransaccion(detalleTransaccion);
                        ListarDetallestransaccion(transaccion.getIdTransaccion());
                        TotalDebeyTotalHaber(transaccion.getIdTransaccion());

                        txtCodigoCuenta.setText("");
                        cboNombreCuenta.setSelectedIndex(0);
                        txtCodigoSubcuenta.setText("");
                        cboNombreSubcuenta.setSelectedIndex(0);
                        cboNaturaleza.setSelectedIndex(0);
                        txtMonto.setText("");
                    
                    } else {
                        JOptionPane.showMessageDialog(null, " Ingrese Detalles de la Transacción ");
                        txtCodigoCuenta.requestFocus();
                        
                    }
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,e.getMessage(),"Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
                }     
            }
            
        } else {
            JOptionPane.showMessageDialog(null,"No existe Transacción, por favor ingrese transacción ","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_btnModificarTransActionPerformed

    private void btnEliminarTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTransActionPerformed

        if(ingresartransaccion == false) {
            int fila = tblDetallesTransaccion.getSelectedRow();
            if(fila != -1) {
                
                try {
                    int Id = Integer.parseInt(tblDetallesTransaccion.getValueAt(fila,0).toString());                
                    detalleTransaccionLN = new DetalleTransaccionLN();
                    
                    detalleTransaccionLN.BorrarDetalleTransaccion(Id);
                    ListarDetallestransaccion(Integer.parseInt(txtIdtransaccion.getText()));
                    TotalDebeyTotalHaber(Integer.parseInt(txtIdtransaccion.getText()));

                    txtCodigoCuenta.setText("");
                    cboNombreCuenta.setSelectedIndex(0);
                    txtCodigoSubcuenta.setText("");
                    cboNombreSubcuenta.setSelectedIndex(0);
                    cboNaturaleza.setSelectedIndex(0);
                    txtMonto.setText("");
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Error de Conexión","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
                }
            } else{
                JOptionPane.showMessageDialog(null,"Seleccione un detalle de la transacción ","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
            }
            
        } else {
            JOptionPane.showMessageDialog(null,"No existe Transacción, por favor ingrese transacción ","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarTransActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarTransaccion;
    private javax.swing.JButton btnAgregarDetalleTrans;
    private javax.swing.JButton btnBuscarCuenta;
    private javax.swing.JButton btnBuscarSubcuenta;
    private javax.swing.JButton btnEliminarTrans;
    private javax.swing.JButton btnModificarTrans;
    private javax.swing.JComboBox<String> cboNaturaleza;
    private javax.swing.JComboBox<String> cboNombreCuenta;
    private javax.swing.JComboBox<String> cboNombreSubcuenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblCodigoSubcuenta;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblTituloAccion;
    private javax.swing.JTable tblDetallesTransaccion;
    private javax.swing.JTextField txtCodigoCuenta;
    private javax.swing.JTextField txtCodigoSubcuenta;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtFechaActual;
    private javax.swing.JTextField txtIdtransaccion;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtTotalDebe;
    private javax.swing.JTextField txtTotalHaber;
    // End of variables declaration//GEN-END:variables
}
