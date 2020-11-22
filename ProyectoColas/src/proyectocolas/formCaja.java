/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocolas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectocolas.datos.DataGlobal;
import proyectocolas.modelos.Caracteristicas;
import proyectocolas.modelos.Cliente;
import proyectocolas.modelos.Cola;
import proyectocolas.modelos.Tickets;

/**
 *
 * @author T420S
 */
public class formCaja extends javax.swing.JFrame {

    /**
     * Creates new form formCaja
     */
    DefaultTableModel modeloCopnfig = new DefaultTableModel();
    DefaultTableModel modelo = new DefaultTableModel();

    public formCaja() {
        initComponents();
        this.tablaConfig.setModel(modeloCopnfig);
        this.modeloCopnfig.addColumn("Nombre");

        this.tablaCola.setModel(modelo);
        this.modelo.addColumn("Nombre");
        this.modelo.addColumn("Apellido");
        this.modelo.addColumn("Condicion");
        this.modelo.addColumn("Transaccion");
        this.modelo.addColumn("Ticket");
        Tickets nodo = null;
        if (DataGlobal.cola1 != null && DataGlobal.cola1.getInicioCola() != null) {
            nodo = DataGlobal.cola1.getInicioCola();
        }
        modelo.setRowCount(0);
        while (nodo != null) {
            this.modelo.addRow(DataGlobal.cola1.vecRegistro(nodo));
            nodo = nodo.getSiguiente();
        }
        if (DataGlobal.caracteristicas == null) {
            DataGlobal.caracteristicas = DataGlobal.caracteristicasIniciales();
        }
        if (!DataGlobal.caracteristicas.isEmpty()) {
            DataGlobal.caracteristicas.forEach((caracteristica) -> {
                jComboCaracteristicas.addItem(caracteristica.getNombre());
            });
        }
    }

    public void ordenar() {
        List<Tickets> list = obtenerUtilList(DataGlobal.cola1);
        if (list != null && !list.isEmpty()) {
            if (DataGlobal.caracteristicasConfig != null && !DataGlobal.caracteristicasConfig.isEmpty()) {
                List<Tickets> lst = new ArrayList<>();
                DataGlobal.caracteristicasConfig.stream().map((caracteristica) -> {
                    List<Tickets> lst2 = new ArrayList<>();
                    list.stream().filter((ticke) -> (ticke.getCliente().getCondicion().getNumero() == caracteristica.getNumero())).forEachOrdered((ticke) -> {
                        lst2.add(ticke);
                    });
                    return lst2;
                }).filter((lst2) -> (!lst2.isEmpty())).forEachOrdered((lst2) -> {
                    lst.addAll(lst2);
                });
                if (!lst.isEmpty()) {
                    modelo.setRowCount(0);
                    for (Tickets tick : lst) {
                        this.modelo.addRow(vecRegistro(tick));
                    }
                } else {
                    modelo.setRowCount(0);
                }
            }
        } else {
            modelo.setRowCount(0);
        }
    }

    public void ordenarBuscar() {
        List<Tickets> list = obtenerUtilList(DataGlobal.cola1);
        if (list != null && !list.isEmpty()) {
            if (DataGlobal.caracteristicasConfig != null && !DataGlobal.caracteristicasConfig.isEmpty()) {
                List<Tickets> lst = new ArrayList<>();
                DataGlobal.caracteristicasConfig.stream().map((caracteristica) -> {
                    List<Tickets> lst2 = new ArrayList<>();
                    list.stream().filter((ticke) -> (ticke.getCliente().getCondicion().getNumero() == caracteristica.getNumero())).forEachOrdered((ticke) -> {
                        lst2.add(ticke);
                    });
                    return lst2;
                }).filter((lst2) -> (!lst2.isEmpty())).forEachOrdered((lst2) -> {
                    lst.addAll(lst2);
                });
                if (!lst.isEmpty()) {
                    Tickets tr = lst.get(0);
                    buscarDespachar(tr);
                    txtApellido.setText(tr.getCliente().getApellido());
                    txtNombre.setText(tr.getCliente().getNombre());
                    txtEdad.setText(String.valueOf(tr.getCliente().getEdad()));
                    txtDui.setText(tr.getCliente().getDui());
                    txtCondicion.setText(tr.getCliente().getCondicion().getNombre());
                    txtTransaccion.setText(tr.getTipoTransac().getNombre());
                }
            }
        }
    }

    public void buscarDespachar(Tickets tst) {
        if (DataGlobal.cola1 != null && DataGlobal.cola1.getInicioCola() != null) {
            List<Tickets> lista = obtenerUtilList(DataGlobal.cola1);
            int del = -1;
            int x = 0;
            for (Tickets tickets : lista) {
                if (tickets.getNumero().equals(tst.getNumero())) {
                    del = x;
                }
                x++;
            }
            if (del > -1) {
                lista.remove(del);
            }
            DataGlobal.cola1.vaciar();
            for (Tickets tickets : lista) {
                DataGlobal.cola1.ingresarReversa(tickets);
            }
        }
    }

    public String[] vecRegistro(Tickets nodo) {
        String nom = nodo.getCliente().getNombre();
        String apell = nodo.getCliente().getApellido();
        String cond = nodo.getCliente().getCondicion().getNombre();
        String transac = nodo.getTipoTransac().getNombre();
        String tkt = nodo.getCliente().getNumerodeTicket();
        String vec[] = {nom, apell, cond, transac, tkt};
        return vec;
    }

    public List<Tickets> obtenerUtilList(Cola colar) {
        List<Tickets> lista = new ArrayList<>();

        Tickets nodo = null;
        if (colar != null && colar.getInicioCola() != null) {
            nodo = colar.getInicioCola();
        }
        while (nodo != null) {
            lista.add(nodo);
            nodo = nodo.getSiguiente();
        }
        return lista;
    }

    public void verConfig() {
        if (DataGlobal.caracteristicasConfig != null && !DataGlobal.caracteristicasConfig.isEmpty()) {
            modeloCopnfig.setRowCount(0);
            for (Caracteristicas caracteristicas : DataGlobal.caracteristicasConfig) {
                String st[] = {caracteristicas.getNombre()};
                this.modeloCopnfig.addRow(st);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCola = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnDespachar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDui = new javax.swing.JTextField();
        txtTransaccion = new javax.swing.JTextField();
        txtCondicion = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jComboCaracteristicas = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        btnAlearios = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaConfig = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaCola.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tablaCola.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaCola);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Ingreso uno a uno"));

        txtNombre.setEnabled(false);

        txtApellido.setEnabled(false);

        jLabel1.setText("Nombre");

        jLabel2.setText("Apellido");

        jLabel3.setText("Edad");
        jLabel3.setToolTipText("");

        btnDespachar.setText("Despachar");
        btnDespachar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDespacharActionPerformed(evt);
            }
        });

        jLabel5.setText("Tipo Transaccion");

        jLabel6.setText("Condicion");

        jLabel10.setText("dui");

        txtDui.setEnabled(false);

        txtTransaccion.setEnabled(false);

        txtCondicion.setEnabled(false);

        txtEdad.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCondicion, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtDui, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(btnDespachar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDui, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCondicion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(btnDespachar)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "COnfiguracion"));

        jLabel9.setText("Caracteristicas");

        btnAlearios.setText("Agregar");
        btnAlearios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAleariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jComboCaracteristicas, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(btnAlearios)
                .addGap(44, 44, 44))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAlearios, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jComboCaracteristicas))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        tablaConfig.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tablaConfig.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jScrollPane2.setViewportView(tablaConfig);

        jButton1.setText("TomarCliente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Vaciar Configuracion");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Inicio");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jButton3)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(43, 43, 43))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDespacharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDespacharActionPerformed
        txtApellido.setText("");
        txtNombre.setText("");
        txtEdad.setText("");
        txtDui.setText("");
        txtCondicion.setText("");
        txtTransaccion.setText("");
        ordenar();
    }//GEN-LAST:event_btnDespacharActionPerformed

    private void btnAleariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAleariosActionPerformed
        // TODO add your handling code here:
        String condicion = jComboCaracteristicas.getSelectedItem().toString();
        Caracteristicas caracteristicar = null;
        if (DataGlobal.caracteristicas != null) {
            for (Caracteristicas caracteristica : DataGlobal.caracteristicas) {
                if (caracteristica.getNombre().equals(condicion)) {
                    caracteristicar = caracteristica;
                }
            }
        }
        if (caracteristicar != null) {
            if (DataGlobal.caracteristicasConfig == null) {
                DataGlobal.caracteristicasConfig = new ArrayList<>();
            }
            DataGlobal.caracteristicasConfig.add(caracteristicar);
        }
        ordenar();
        verConfig();
    }//GEN-LAST:event_btnAleariosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ordenarBuscar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Principal.frmI.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DataGlobal.caracteristicasConfig = new ArrayList<>();
        modelo.setRowCount(0);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(formCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formCaja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlearios;
    private javax.swing.JButton btnDespachar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboCaracteristicas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaCola;
    private javax.swing.JTable tablaConfig;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCondicion;
    private javax.swing.JTextField txtDui;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTransaccion;
    // End of variables declaration//GEN-END:variables
}
