package Presentacion;

import Entidades.Cuenta;
import Entidades.Subcuenta;
import Entidades.TipoCuenta;
import Entidades.Usuario;
import LogicaNegocio.CuentaLN;
import LogicaNegocio.SubcuentaLN;
import LogicaNegocio.TipoCuentaLN;
import Modelo.mdlCuenta;
import Modelo.mdlSubcuenta;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class frmCatalogoCtas extends javax.swing.JFrame {

    private Usuario user;
    private CuentaLN cuentaLN;
    private SubcuentaLN subcuentaLN;
    private TipoCuentaLN tipoCuentaLN;
    private mdlCuenta modelocuentas;
    private mdlSubcuenta modelosubcuentas;
    
    public frmCatalogoCtas(Usuario usuario) {
        initComponents();
        
        Image icon = new ImageIcon(getClass().getResource("/imagenes/catalogo.png")).getImage();
        setIconImage(icon);
        this.setLocationRelativeTo(null);
        lbladmin.setText(usuario.toString().toUpperCase());
        user = usuario;
        
        ListarCuentas("","");
        ListarTipoCuentas();
        ListarCodigoCuentas();
        ListarSubCuentas("");
    }
    
    public void ListarCuentas(String patron,String patron2){
        cuentaLN = new CuentaLN();
        this.modelocuentas = new mdlCuenta();
        jtbCuentas.setModel(modelocuentas);
        List<Cuenta> cuentas = null;
        
        try {
            cuentas = cuentaLN.ConsultarCuentas(patron,patron2);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
        }
        modelocuentas.EstablecerCuentas(cuentas);
        jtbCuentas.requestFocus();
    }
    
    public void ListarTipoCuentas() {
        
        try {
            tipoCuentaLN = new TipoCuentaLN();
            List<TipoCuenta> tipocuentas = tipoCuentaLN.ConsultarTipoCuenta();

            cboTipoCuenta.addItem("Seleccionar...");
            for (int i = 0; i < tipocuentas.size(); i++) {
                cboTipoCuenta.addItem(tipocuentas.get(i).getNombreTipocuenta());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
        }
        
    }
    public void ListarCodigoCuentas(){
        cuentaLN = new CuentaLN();
        List<Cuenta> cuentas = null;
        
        try {
            cuentas = cuentaLN.ConsultarCuentas("","") ;
            cboCodigocta.addItem("Seleccionar ...");
            for (int i = 0; i < cuentas.size(); i++) {
                cboCodigocta.addItem(Integer.toString(cuentas.get(i).getCodigoCuenta()));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
        }
        
        
    }
    public void ListarSubCuentas(String patron) {
        subcuentaLN = new SubcuentaLN();
        this.modelosubcuentas = new mdlSubcuenta();
        jtbSubcuentas.setModel(modelosubcuentas);
        List<Subcuenta> subcuentas = null;
        
        try {
            subcuentas = subcuentaLN.ConsultarSubcuentas(patron);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
        }
        modelosubcuentas.EstablecerSubcuentas(subcuentas);
        jtbSubcuentas.requestFocus();
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo1 = new javax.swing.JLabel();
        lblTitulo2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lbladmin = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCodigoCuenta = new javax.swing.JTextField();
        txtNombreCuenta = new javax.swing.JTextField();
        btnInsertarCuenta = new javax.swing.JButton();
        btnModificarCuenta = new javax.swing.JButton();
        btnEliminarCuenta = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtCodigoSubcuenta = new javax.swing.JTextField();
        txtNombreSubcuenta = new javax.swing.JTextField();
        btnInsertarSubcuenta = new javax.swing.JButton();
        btnModificarSubcuenta = new javax.swing.JButton();
        btnEliminarSubcuenta = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtBuscarporCodigo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtBuscarporNombre = new javax.swing.JTextField();
        btnBuscarCuenta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbSubcuentas = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        VerTodaSubcta = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbCuentas = new javax.swing.JTable();
        cboTipoCuenta = new javax.swing.JComboBox<>();
        cboCodigocta = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 0), 2, true));

        lblTitulo1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(0, 102, 0));
        lblTitulo1.setText("CENTRAL AZUCARERA CHUCARAPI PAMPA BLANCA S.A.");

        lblTitulo2.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        lblTitulo2.setForeground(new java.awt.Color(204, 0, 0));
        lblTitulo2.setText("CATÁLOGO DE CUENTAS");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/catalogo.png"))); // NOI18N

        btnVolver.setBackground(new java.awt.Color(153, 0, 0));
        btnVolver.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(204, 0, 0));
        btnVolver.setText("Volver");
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel8.setText("Administrador :");

        lbladmin.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        lbladmin.setForeground(new java.awt.Color(0, 0, 102));
        lbladmin.setText("admin");

        jSeparator1.setForeground(new java.awt.Color(51, 0, 51));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("CUENTA");

        jSeparator2.setForeground(new java.awt.Color(0, 102, 0));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setText("Codigo cuenta : ");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setText("Nombre cuenta : ");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setText("Tipo cuenta : ");

        txtCodigoCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoCuentaActionPerformed(evt);
            }
        });
        txtCodigoCuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoCuentaKeyReleased(evt);
            }
        });

        txtNombreCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreCuentaActionPerformed(evt);
            }
        });
        txtNombreCuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreCuentaKeyReleased(evt);
            }
        });

        btnInsertarCuenta.setText("Insertar");
        btnInsertarCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsertarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarCuentaActionPerformed(evt);
            }
        });

        btnModificarCuenta.setText("Modificar");
        btnModificarCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarCuentaActionPerformed(evt);
            }
        });

        btnEliminarCuenta.setText("Eliminar");
        btnEliminarCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCuentaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setText("SUBCUENTA");

        jSeparator3.setForeground(new java.awt.Color(0, 102, 0));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel10.setText("Codigo subcuenta : ");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel11.setText("Nombre subcuenta : ");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel12.setText("Codigo de cuenta :");

        txtCodigoSubcuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoSubcuentaActionPerformed(evt);
            }
        });
        txtCodigoSubcuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoSubcuentaKeyReleased(evt);
            }
        });

        txtNombreSubcuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreSubcuentaKeyReleased(evt);
            }
        });

        btnInsertarSubcuenta.setText("Insertar");
        btnInsertarSubcuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsertarSubcuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarSubcuentaActionPerformed(evt);
            }
        });

        btnModificarSubcuenta.setText("Modificar");
        btnModificarSubcuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificarSubcuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarSubcuentaActionPerformed(evt);
            }
        });

        btnEliminarSubcuenta.setText("Eliminar");
        btnEliminarSubcuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarSubcuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarSubcuentaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel4.setText("Código: ");

        txtBuscarporCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarporCodigoActionPerformed(evt);
            }
        });
        txtBuscarporCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarporCodigoKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 11)); // NOI18N
        jLabel5.setText("Nombre Cuenta : ");

        txtBuscarporNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarporNombreKeyReleased(evt);
            }
        });

        btnBuscarCuenta.setText("Buscar Cuentas");
        btnBuscarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCuentaActionPerformed(evt);
            }
        });

        jtbSubcuentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtbSubcuentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtbSubcuentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbSubcuentasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbSubcuentas);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 0));
        jLabel13.setText("Subcuentas");

        VerTodaSubcta.setText("Ver todas las Subcuentas");
        VerTodaSubcta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerTodaSubctaActionPerformed(evt);
            }
        });

        jtbCuentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtbCuentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtbCuentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbCuentasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtbCuentas);

        cboTipoCuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cboTipoCuentaKeyReleased(evt);
            }
        });

        cboCodigocta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cboCodigoctaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(lblTitulo2)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblTitulo1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnVolver)
                                .addContainerGap())
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(lbladmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator2)
                        .addComponent(jSeparator3)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnInsertarCuenta)
                                    .addGap(45, 45, 45)
                                    .addComponent(btnModificarCuenta)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEliminarCuenta))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtCodigoSubcuenta))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel12)
                                        .addComponent(btnInsertarSubcuenta))
                                    .addGap(13, 13, 13)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(btnModificarSubcuenta)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                            .addComponent(btnEliminarSubcuenta))
                                        .addComponent(txtNombreSubcuenta)
                                        .addComponent(cboCodigocta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNombreCuenta)
                                            .addComponent(txtCodigoCuenta)
                                            .addComponent(cboTipoCuenta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel2)))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscarporCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarporNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscarCuenta))
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VerTodaSubcta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblTitulo1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTitulo2)
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(lbladmin)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVolver)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtBuscarporCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(txtBuscarporNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarCuenta))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCodigoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtNombreCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cboTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInsertarCuenta)
                            .addComponent(btnModificarCuenta)
                            .addComponent(btnEliminarCuenta)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(VerTodaSubcta)
                    .addComponent(jLabel9))
                .addGap(3, 3, 3)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtCodigoSubcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtNombreSubcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(cboCodigocta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInsertarSubcuenta)
                            .addComponent(btnModificarSubcuenta)
                            .addComponent(btnEliminarSubcuenta)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        MenuAdministrador menu = new MenuAdministrador(user);
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void txtCodigoCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoCuentaActionPerformed

    private void txtNombreCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreCuentaActionPerformed

    private void btnInsertarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarCuentaActionPerformed

        Cuenta cuenta = new Cuenta();
        TipoCuenta tipoCuenta = new TipoCuenta();

        if( (!txtCodigoCuenta.getText().equals("")) && (!txtNombreCuenta.getText().equals(""))){

            if(cboTipoCuenta.getSelectedIndex() != 0){
                try {
                    cuenta.setCodigoCuenta(Integer.parseInt(txtCodigoCuenta.getText()));
                    cuenta.setNombreCuenta(txtNombreCuenta.getText());
                    tipoCuenta.setIdTipocuenta(cboTipoCuenta.getSelectedIndex());
                    tipoCuenta.setNombreTipocuenta((String) cboTipoCuenta.getSelectedItem());
                    cuenta.setoTipoCuenta(tipoCuenta);

                    cuentaLN.RegistrarCuenta(cuenta);
                    btnBuscarCuenta.doClick();

                    txtCodigoCuenta.setText("");
                    txtNombreCuenta.setText("");
                    cboTipoCuenta.setSelectedIndex(0);
                    ListarCodigoCuentas();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error de Conexión:  "+e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
                }

            }else{
                JOptionPane.showMessageDialog(null, "Seleccione Tipo de Cuenta ", "Error", JOptionPane.WARNING_MESSAGE);
            }

        }else{
            JOptionPane.showMessageDialog(null, "Datos vacíos ", "Error", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnInsertarCuentaActionPerformed

    private void btnEliminarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCuentaActionPerformed

        Cuenta cuenta = new Cuenta();
        TipoCuenta tipoCuenta = new TipoCuenta();

        if( (!txtCodigoCuenta.getText().equals("")) && (!txtNombreCuenta.getText().equals(""))){

            if(cboTipoCuenta.getSelectedIndex() != 0){
                try {
                    cuenta.setCodigoCuenta(Integer.parseInt(txtCodigoCuenta.getText()));
                    cuenta.setNombreCuenta(txtNombreCuenta.getText());
                    tipoCuenta.setIdTipocuenta(cboTipoCuenta.getSelectedIndex());
                    tipoCuenta.setNombreTipocuenta((String) cboTipoCuenta.getSelectedItem());
                    cuenta.setoTipoCuenta(tipoCuenta);

                    cuentaLN.BorrarCuenta(cuenta);
                    btnBuscarCuenta.doClick();

                    txtCodigoCuenta.setText("");
                    txtNombreCuenta.setText("");
                    cboTipoCuenta.setSelectedIndex(0);
                    ListarCodigoCuentas();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error de Conexión:  "+e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
                }

            }else{
                JOptionPane.showMessageDialog(null, "Seleccione Tipo de Cuenta ", "Error", JOptionPane.WARNING_MESSAGE);
            }

        }else{
            JOptionPane.showMessageDialog(null, "Datos vacíos ", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarCuentaActionPerformed

    private void btnInsertarSubcuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarSubcuentaActionPerformed

        Subcuenta subcuenta = new Subcuenta();
        Cuenta cuenta = new Cuenta();

        if( (!txtCodigoSubcuenta.getText().equals("")) && (!txtNombreSubcuenta.getText().equals(""))  ){

            if(cboCodigocta.getSelectedIndex() != 0){
                try {
                    subcuenta.setCodigoSubcuenta(Integer.parseInt(txtCodigoSubcuenta.getText()));
                    subcuenta.setNombreSubcuenta(txtNombreSubcuenta.getText());
                    cuenta.setCodigoCuenta(Integer.parseInt(cboCodigocta.getSelectedItem().toString()));
                    subcuenta.setoCuenta(cuenta);

                    subcuentaLN.RegistrarSubcuenta(subcuenta);
                    ListarSubCuentas(cboCodigocta.getSelectedItem().toString());

                    txtCodigoSubcuenta.setText("");
                    txtNombreSubcuenta.setText("");
                    cboCodigocta.setSelectedIndex(0);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error de Conexión:  "+e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Seleccione coddigo de cuenta ", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Datos vacíos ", "Error", JOptionPane.WARNING_MESSAGE);
        }

        
    }//GEN-LAST:event_btnInsertarSubcuentaActionPerformed

    private void btnModificarSubcuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarSubcuentaActionPerformed

        Subcuenta subcuenta = new Subcuenta();
        Cuenta cuenta = new Cuenta();

        if( (!txtCodigoSubcuenta.getText().equals("")) &&  (!txtNombreSubcuenta.getText().equals(""))  ){

            if(cboCodigocta.getSelectedIndex() != 0) {

                try {
                    subcuenta.setCodigoSubcuenta(Integer.parseInt(txtCodigoSubcuenta.getText()));
                    subcuenta.setNombreSubcuenta(txtNombreSubcuenta.getText());
                    cuenta.setCodigoCuenta(Integer.parseInt(cboCodigocta.getSelectedItem().toString()));
                    subcuenta.setoCuenta(cuenta);

                    subcuentaLN.ModificarSubcuenta(subcuenta);
                    ListarSubCuentas(cboCodigocta.getSelectedItem().toString());

                    txtCodigoSubcuenta.setText("");
                    txtNombreSubcuenta.setText("");
                    cboCodigocta.setSelectedIndex(0);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error de Conexión:  "+e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Seleccione Tipo de Cuenta ", "Error", JOptionPane.WARNING_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Datos vacíos ", "Error", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnModificarSubcuentaActionPerformed

    private void btnEliminarSubcuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarSubcuentaActionPerformed


        Subcuenta subcuenta = new Subcuenta();
        Cuenta cuenta = new Cuenta();

        if((!txtCodigoSubcuenta.getText().equals("")) && (!txtNombreSubcuenta.getText().equals(""))) {
            if(cboCodigocta.getSelectedIndex() != 0){

                try {
                    subcuenta.setCodigoSubcuenta(Integer.parseInt(txtCodigoSubcuenta.getText()));
                    subcuenta.setNombreSubcuenta(txtNombreSubcuenta.getText());
                    cuenta.setCodigoCuenta(Integer.parseInt(cboCodigocta.getSelectedItem().toString()));
                    subcuenta.setoCuenta(cuenta);

                    subcuentaLN.BorrarSubcuenta(subcuenta);
                    ListarSubCuentas(cboCodigocta.getSelectedItem().toString());

                    txtCodigoSubcuenta.setText("");
                    txtNombreSubcuenta.setText("");
                    cboCodigocta.setSelectedIndex(0);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error de Conexión:  "+e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Seleccione Tipo de Cuenta ", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Datos vacíos ", "Error", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_btnEliminarSubcuentaActionPerformed

    private void txtBuscarporCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarporCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarporCodigoActionPerformed

    private void VerTodaSubctaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerTodaSubctaActionPerformed
        ListarSubCuentas("");
    }//GEN-LAST:event_VerTodaSubctaActionPerformed

    private void txtCodigoCuentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoCuentaKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtNombreCuenta.requestFocus();
            try {

                int codcta = Integer.parseInt(txtCodigoCuenta.getText());

                if(codcta >= 10 && codcta < 20){
                    cboTipoCuenta.setSelectedIndex(1);
                }
                else if(codcta >= 20 && codcta < 30){
                    cboTipoCuenta.setSelectedIndex(2);
                }
                else if(codcta >= 30 && codcta < 40){
                    cboTipoCuenta.setSelectedIndex(3);
                }
                else if(codcta >= 40 && codcta < 50) {
                    cboTipoCuenta.setSelectedIndex(4);
                }
                else if(codcta >= 50 && codcta < 60) {
                    cboTipoCuenta.setSelectedIndex(5);
                }
                else if(codcta >= 60 && codcta < 70) {
                    cboTipoCuenta.setSelectedIndex(6);
                }
                else if(codcta >= 70 && codcta < 80) {
                    cboTipoCuenta.setSelectedIndex(7);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Fuera del límite de Codigo de Cuenta", "Error", JOptionPane.WARNING_MESSAGE);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Escriba un número", "Error", JOptionPane.WARNING_MESSAGE);
            }

        }
    }//GEN-LAST:event_txtCodigoCuentaKeyReleased

    private void txtNombreCuentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreCuentaKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            cboTipoCuenta.requestFocus();
        }
    }//GEN-LAST:event_txtNombreCuentaKeyReleased

    private void cboTipoCuentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboTipoCuentaKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnInsertarCuenta.requestFocus();
        }
    }//GEN-LAST:event_cboTipoCuentaKeyReleased

    private void btnModificarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarCuentaActionPerformed

        Cuenta cuenta = new Cuenta();
        TipoCuenta tipoCuenta = new TipoCuenta();

        if( (!txtCodigoCuenta.getText().equals("")) && (!txtNombreCuenta.getText().equals(""))){

            if(cboTipoCuenta.getSelectedIndex() != 0){
                try {
                    cuenta.setCodigoCuenta(Integer.parseInt(txtCodigoCuenta.getText()));
                    cuenta.setNombreCuenta(txtNombreCuenta.getText());
                    tipoCuenta.setIdTipocuenta(cboTipoCuenta.getSelectedIndex());
                    tipoCuenta.setNombreTipocuenta((String) cboTipoCuenta.getSelectedItem());
                    cuenta.setoTipoCuenta(tipoCuenta);

                    cuentaLN.ModificarCuenta(cuenta);
                    btnBuscarCuenta.doClick();

                    txtCodigoCuenta.setText("");
                    txtNombreCuenta.setText("");
                    cboTipoCuenta.setSelectedIndex(0);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error de Conexión:  "+e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
                }

            }else{
                JOptionPane.showMessageDialog(null, "Seleccione Tipo de Cuenta ", "Error", JOptionPane.WARNING_MESSAGE);
            }

        }else{
            JOptionPane.showMessageDialog(null, "Datos vacíos ", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarCuentaActionPerformed

    private void txtCodigoSubcuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoSubcuentaActionPerformed

    }//GEN-LAST:event_txtCodigoSubcuentaActionPerformed

    private void txtCodigoSubcuentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoSubcuentaKeyReleased

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtNombreSubcuenta.requestFocus();
        }
    }//GEN-LAST:event_txtCodigoSubcuentaKeyReleased

    private void txtNombreSubcuentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreSubcuentaKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            cboCodigocta.requestFocus();
        }
    }//GEN-LAST:event_txtNombreSubcuentaKeyReleased

    private void cboCodigoctaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboCodigoctaKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnInsertarSubcuenta.requestFocus();
        }
    }//GEN-LAST:event_cboCodigoctaKeyReleased

    private void txtBuscarporCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarporCodigoKeyReleased

        try {
            ListarCuentas(txtBuscarporCodigo.getText(),"");
            txtBuscarporCodigo.requestFocus();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_txtBuscarporCodigoKeyReleased

    private void txtBuscarporNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarporNombreKeyReleased

        try {
            ListarCuentas("", txtBuscarporNombre.getText());
            txtBuscarporNombre.requestFocus();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtBuscarporNombreKeyReleased

    private void btnBuscarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCuentaActionPerformed

        try {
            ListarCuentas(txtBuscarporCodigo.getText(),txtBuscarporNombre.getText());
            txtBuscarporCodigo.requestFocus();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarCuentaActionPerformed

    private void jtbCuentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbCuentasMouseClicked
        Cuenta cuenta = new Cuenta();

        try {
            int fila = jtbCuentas.getSelectedRow();
            int Id = Integer.parseInt(jtbCuentas.getValueAt(fila,0).toString());

            cuenta = cuentaLN.ConsultarCuentaporCodigo(Id);

            txtCodigoCuenta.setText(Integer.toString(cuenta.getCodigoCuenta()));
            txtNombreCuenta.setText(cuenta.getNombreCuenta());
            cboTipoCuenta.setSelectedIndex(cuenta.getoTipoCuenta().getIdTipocuenta());
            ListarSubCuentas(Integer.toString(Id));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, ""+e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jtbCuentasMouseClicked

    private void jtbSubcuentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbSubcuentasMouseClicked

        Subcuenta subcuenta = new Subcuenta();
        Cuenta cuenta = new Cuenta();

        try {

            int fila = jtbSubcuentas.getSelectedRow();
            int Id = Integer.parseInt(jtbSubcuentas.getValueAt(fila, 0).toString());

            subcuenta = subcuentaLN.ConsultarSubcuentaporCodigo(Id);

            txtCodigoSubcuenta.setText(Integer.toString(subcuenta.getCodigoSubcuenta()));
            txtNombreSubcuenta.setText(subcuenta.getNombreSubcuenta());

            String codigocuenta = Integer.toString(subcuenta.getoCuenta().getCodigoCuenta());
            cboCodigocta.setSelectedItem(codigocuenta);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, ""+e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jtbSubcuentasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton VerTodaSubcta;
    private javax.swing.JButton btnBuscarCuenta;
    private javax.swing.JButton btnEliminarCuenta;
    private javax.swing.JButton btnEliminarSubcuenta;
    private javax.swing.JButton btnInsertarCuenta;
    private javax.swing.JButton btnInsertarSubcuenta;
    private javax.swing.JButton btnModificarCuenta;
    private javax.swing.JButton btnModificarSubcuenta;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cboCodigocta;
    private javax.swing.JComboBox<String> cboTipoCuenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jtbCuentas;
    private javax.swing.JTable jtbSubcuentas;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JLabel lbladmin;
    private javax.swing.JTextField txtBuscarporCodigo;
    private javax.swing.JTextField txtBuscarporNombre;
    private javax.swing.JTextField txtCodigoCuenta;
    private javax.swing.JTextField txtCodigoSubcuenta;
    private javax.swing.JTextField txtNombreCuenta;
    private javax.swing.JTextField txtNombreSubcuenta;
    // End of variables declaration//GEN-END:variables
}
