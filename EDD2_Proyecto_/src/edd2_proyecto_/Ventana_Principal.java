package edd2_proyecto_;
import java.util.ArrayList;
public class Ventana_Principal extends javax.swing.JFrame {

    /**
     * Creates new form Ventana_Principal
     */
    public Ventana_Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jd_Archivo = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jd_Campos = new javax.swing.JDialog();
        jb_BorrarCampos = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jb_CrearCampo = new javax.swing.JButton();
        jb_ModificarCampos = new javax.swing.JButton();
        jb_ListarCampos = new javax.swing.JButton();
        jb_SalirdeCampos = new javax.swing.JButton();
        jd_Registros = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jb_SalirDeRegistros = new javax.swing.JButton();
        jd_indices = new javax.swing.JDialog();
        jLabel5 = new javax.swing.JLabel();
        jb_CrearIndice = new javax.swing.JButton();
        jb_ReIndexarArchivos = new javax.swing.JButton();
        jd_Estandarizacion = new javax.swing.JDialog();
        jLabel6 = new javax.swing.JLabel();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jd_CrearCampo = new javax.swing.JDialog();
        jl_nameCampo = new javax.swing.JLabel();
        tf_NombredelCampo = new javax.swing.JTextField();
        jl_tipodevariable = new javax.swing.JLabel();
        jb_TerminarCreacionCampo = new javax.swing.JButton();
        rb_tip_string = new javax.swing.JRadioButton();
        rb_tip_integer = new javax.swing.JRadioButton();
        jl_longitud = new javax.swing.JLabel();
        tf_longitudelcampo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        rb_key_si = new javax.swing.JRadioButton();
        rb_key_no = new javax.swing.JRadioButton();
        bg_TipoDeVariable = new javax.swing.ButtonGroup();
        bg_LlavePrimaria = new javax.swing.ButtonGroup();
        jb_Archivo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jb_Campos = new javax.swing.JButton();
        jb_Registros = new javax.swing.JButton();
        jb_Indices = new javax.swing.JButton();
        jb_Estandarizacion = new javax.swing.JButton();
        jb_Salir1 = new javax.swing.JButton();

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setText("Archivo");

        jButton7.setText("Nuevo Archivo");

        jButton8.setText("Salvar Archivo");

        jButton9.setText("Cerrar Archivo");

        jButton10.setText("Salir");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jd_ArchivoLayout = new javax.swing.GroupLayout(jd_Archivo.getContentPane());
        jd_Archivo.getContentPane().setLayout(jd_ArchivoLayout);
        jd_ArchivoLayout.setHorizontalGroup(
            jd_ArchivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_ArchivoLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jd_ArchivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jd_ArchivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jd_ArchivoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132))
        );
        jd_ArchivoLayout.setVerticalGroup(
            jd_ArchivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_ArchivoLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jd_ArchivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jd_ArchivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jb_BorrarCampos.setText("Borrar Campos");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel3.setText("Campos");

        jb_CrearCampo.setText("Crear Campos");
        jb_CrearCampo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_CrearCampoMouseClicked(evt);
            }
        });

        jb_ModificarCampos.setText("Modificar Campos");

        jb_ListarCampos.setText("Listar Campos");

        jb_SalirdeCampos.setText("Salir");
        jb_SalirdeCampos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_SalirdeCamposMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jd_CamposLayout = new javax.swing.GroupLayout(jd_Campos.getContentPane());
        jd_Campos.getContentPane().setLayout(jd_CamposLayout);
        jd_CamposLayout.setHorizontalGroup(
            jd_CamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_CamposLayout.createSequentialGroup()
                .addGroup(jd_CamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jd_CamposLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jd_CamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jb_CrearCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jb_ModificarCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(68, 68, 68)
                        .addGroup(jd_CamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jb_ListarCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jb_BorrarCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jd_CamposLayout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jd_CamposLayout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jb_SalirdeCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jd_CamposLayout.setVerticalGroup(
            jd_CamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_CamposLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jd_CamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_ListarCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_CrearCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jd_CamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_ModificarCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_BorrarCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jb_SalirdeCampos)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel4.setText("Registros");

        jButton15.setText("Introducir Registros");

        jButton16.setText("Modificar Registros");

        jButton17.setText("Buscar Registros");

        jButton18.setText("Borrar Registros");

        jButton19.setText("Listar Registros");

        jb_SalirDeRegistros.setText("Salir");
        jb_SalirDeRegistros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_SalirDeRegistrosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jd_RegistrosLayout = new javax.swing.GroupLayout(jd_Registros.getContentPane());
        jd_Registros.getContentPane().setLayout(jd_RegistrosLayout);
        jd_RegistrosLayout.setHorizontalGroup(
            jd_RegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_RegistrosLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jd_RegistrosLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jd_RegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jd_RegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_SalirDeRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
        jd_RegistrosLayout.setVerticalGroup(
            jd_RegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_RegistrosLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jd_RegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jd_RegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jd_RegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton19, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jb_SalirDeRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel5.setText("Índices");

        jb_CrearIndice.setText("Crear Índices");

        jb_ReIndexarArchivos.setText("Re Indexar Archivos");

        javax.swing.GroupLayout jd_indicesLayout = new javax.swing.GroupLayout(jd_indices.getContentPane());
        jd_indices.getContentPane().setLayout(jd_indicesLayout);
        jd_indicesLayout.setHorizontalGroup(
            jd_indicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_indicesLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jb_CrearIndice, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jb_ReIndexarArchivos, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jd_indicesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(139, 139, 139))
        );
        jd_indicesLayout.setVerticalGroup(
            jd_indicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_indicesLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel5)
                .addGap(28, 28, 28)
                .addGroup(jd_indicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jb_CrearIndice, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(jb_ReIndexarArchivos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel6.setText("Estandarización");

        jButton22.setText("Exportar Excel");

        jButton23.setText("Exportar XML con Schema");

        javax.swing.GroupLayout jd_EstandarizacionLayout = new javax.swing.GroupLayout(jd_Estandarizacion.getContentPane());
        jd_Estandarizacion.getContentPane().setLayout(jd_EstandarizacionLayout);
        jd_EstandarizacionLayout.setHorizontalGroup(
            jd_EstandarizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_EstandarizacionLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jButton23)
                .addGap(28, 28, 28))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jd_EstandarizacionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
        jd_EstandarizacionLayout.setVerticalGroup(
            jd_EstandarizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_EstandarizacionLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jd_EstandarizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jl_nameCampo.setText("Nombre del campo:");

        jl_tipodevariable.setText("Tipo de variable:");

        jb_TerminarCreacionCampo.setText("Crear Campo");
        jb_TerminarCreacionCampo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_TerminarCreacionCampoMouseClicked(evt);
            }
        });

        bg_TipoDeVariable.add(rb_tip_string);
        rb_tip_string.setSelected(true);
        rb_tip_string.setText("String");

        bg_TipoDeVariable.add(rb_tip_integer);
        rb_tip_integer.setText("Integer");

        jl_longitud.setText("Longitud del campo");

        jLabel7.setText("Es llave primaria?");

        bg_LlavePrimaria.add(rb_key_si);
        rb_key_si.setText("Si");

        bg_LlavePrimaria.add(rb_key_no);
        rb_key_no.setSelected(true);
        rb_key_no.setText("No");

        javax.swing.GroupLayout jd_CrearCampoLayout = new javax.swing.GroupLayout(jd_CrearCampo.getContentPane());
        jd_CrearCampo.getContentPane().setLayout(jd_CrearCampoLayout);
        jd_CrearCampoLayout.setHorizontalGroup(
            jd_CrearCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_CrearCampoLayout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jb_TerminarCreacionCampo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jd_CrearCampoLayout.createSequentialGroup()
                .addGroup(jd_CrearCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jl_nameCampo)
                    .addComponent(tf_NombredelCampo)
                    .addComponent(jl_tipodevariable, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jd_CrearCampoLayout.createSequentialGroup()
                        .addComponent(rb_tip_string)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb_tip_integer))
                    .addComponent(jl_longitud)
                    .addComponent(tf_longitudelcampo, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jd_CrearCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jd_CrearCampoLayout.createSequentialGroup()
                        .addComponent(rb_key_si)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rb_key_no)))
                .addGap(70, 70, 70))
        );
        jd_CrearCampoLayout.setVerticalGroup(
            jd_CrearCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_CrearCampoLayout.createSequentialGroup()
                .addComponent(jl_nameCampo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_NombredelCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jl_tipodevariable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jd_CrearCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jd_CrearCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rb_tip_string)
                        .addComponent(rb_tip_integer))
                    .addGroup(jd_CrearCampoLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(10, 10, 10)
                        .addGroup(jd_CrearCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rb_key_si)
                            .addComponent(rb_key_no))))
                .addGap(21, 21, 21)
                .addComponent(jl_longitud)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_longitudelcampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jb_TerminarCreacionCampo))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Standard File Manager");
        setName("Standard File Manager"); // NOI18N

        jb_Archivo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jb_Archivo.setText("Archivo");
        jb_Archivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_ArchivoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setText("Standard File Manager");
        jLabel1.setName("Standard File Manager"); // NOI18N

        jb_Campos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jb_Campos.setText("Campos");
        jb_Campos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_CamposActionPerformed(evt);
            }
        });

        jb_Registros.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jb_Registros.setText("Registros");

        jb_Indices.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jb_Indices.setText("Índices");
        jb_Indices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_IndicesActionPerformed(evt);
            }
        });

        jb_Estandarizacion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jb_Estandarizacion.setText("Estandarización");
        jb_Estandarizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_EstandarizacionActionPerformed(evt);
            }
        });

        jb_Salir1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jb_Salir1.setText("Salir");
        jb_Salir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_Salir1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jb_Archivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb_Registros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb_Estandarizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(126, 126, 126)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jb_Indices, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb_Campos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb_Salir1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jb_Campos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb_Archivo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jb_Indices, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb_Registros, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jb_Estandarizacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb_Salir1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(144, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_Salir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_Salir1ActionPerformed
       System.exit(0);
    }//GEN-LAST:event_jb_Salir1ActionPerformed

    private void jb_ArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_ArchivoActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        jd_Archivo.pack();
        jd_Archivo.setModal(true);
        jd_Archivo.setLocationRelativeTo(this);
        jd_Archivo.setVisible(true);
    }//GEN-LAST:event_jb_ArchivoActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        jd_Archivo.dispose();
        this.setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jb_CamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_CamposActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        jd_Campos.pack();
        jd_Campos.setModal(true);
        jd_Campos.setLocationRelativeTo(this);
        jd_Campos.setVisible(true);
    }//GEN-LAST:event_jb_CamposActionPerformed

    private void jb_IndicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_IndicesActionPerformed
        // TODO add your handling code here:
        jd_indices.pack();
        jd_indices.setModal(true);
        jd_indices.setLocationRelativeTo(this);
        jd_indices.setVisible(true);
    }//GEN-LAST:event_jb_IndicesActionPerformed

    private void jb_EstandarizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_EstandarizacionActionPerformed
        // TODO add your handling code here:
        jd_Estandarizacion.pack();
        jd_Estandarizacion.setModal(true);
        jd_Estandarizacion.setLocationRelativeTo(this);
        jd_Estandarizacion.setVisible(true);
    }//GEN-LAST:event_jb_EstandarizacionActionPerformed

    private void jb_CrearCampoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_CrearCampoMouseClicked
        jd_CrearCampo.pack();
        jd_CrearCampo.setModal(true);
        jd_CrearCampo.setLocationRelativeTo(this);
        jd_CrearCampo.setVisible(true);
    }//GEN-LAST:event_jb_CrearCampoMouseClicked

    private void jb_SalirdeCamposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_SalirdeCamposMouseClicked
        jd_Campos.dispose();
        this.setVisible(true);
    }//GEN-LAST:event_jb_SalirdeCamposMouseClicked

    private void jb_SalirDeRegistrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_SalirDeRegistrosMouseClicked
        jd_Registros.dispose();
        this.setVisible(true);
    }//GEN-LAST:event_jb_SalirDeRegistrosMouseClicked

    private void jb_TerminarCreacionCampoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_TerminarCreacionCampoMouseClicked
       String nombre = tf_NombredelCampo.toString();
       int longitud = Integer.parseInt(tf_longitudelcampo.toString()) ;
       boolean key;
       
       if(rb_key_no.isSelected()){
           key = false;
       }else{
           key = true;
       }
          
       if(rb_tip_integer.isSelected()){
           campos.add(new Campo(nombre, "int", key, longitud));
           
       }else{
           campos.add(new Campo(nombre, "String", key, longitud));
       }
    }//GEN-LAST:event_jb_TerminarCreacionCampoMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bg_LlavePrimaria;
    private javax.swing.ButtonGroup bg_TipoDeVariable;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton jb_Archivo;
    private javax.swing.JButton jb_BorrarCampos;
    private javax.swing.JButton jb_Campos;
    private javax.swing.JButton jb_CrearCampo;
    private javax.swing.JButton jb_CrearIndice;
    private javax.swing.JButton jb_Estandarizacion;
    private javax.swing.JButton jb_Indices;
    private javax.swing.JButton jb_ListarCampos;
    private javax.swing.JButton jb_ModificarCampos;
    private javax.swing.JButton jb_ReIndexarArchivos;
    private javax.swing.JButton jb_Registros;
    private javax.swing.JButton jb_Salir1;
    private javax.swing.JButton jb_SalirDeRegistros;
    private javax.swing.JButton jb_SalirdeCampos;
    private javax.swing.JButton jb_TerminarCreacionCampo;
    private javax.swing.JDialog jd_Archivo;
    private javax.swing.JDialog jd_Campos;
    private javax.swing.JDialog jd_CrearCampo;
    private javax.swing.JDialog jd_Estandarizacion;
    private javax.swing.JDialog jd_Registros;
    private javax.swing.JDialog jd_indices;
    private javax.swing.JLabel jl_longitud;
    private javax.swing.JLabel jl_nameCampo;
    private javax.swing.JLabel jl_tipodevariable;
    private javax.swing.JRadioButton rb_key_no;
    private javax.swing.JRadioButton rb_key_si;
    private javax.swing.JRadioButton rb_tip_integer;
    private javax.swing.JRadioButton rb_tip_string;
    private javax.swing.JTextField tf_NombredelCampo;
    private javax.swing.JTextField tf_longitudelcampo;
    // End of variables declaration//GEN-END:variables
    ArrayList<Campo> campos = new ArrayList();
}
