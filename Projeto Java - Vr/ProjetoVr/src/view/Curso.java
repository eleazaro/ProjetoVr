package view;

import javax.swing.table.DefaultTableModel;
import model.ClassCurso;
import model.CursoDAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bruno
 */
public class Curso extends javax.swing.JFrame {

    /**
     * Creates new form Curso
     */
    public Curso() {
        initComponents();
        readTable();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Curso");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TxtFieldDesc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TxtFieldEmenta = new javax.swing.JTextField();
        BtGrava = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabCurso = new javax.swing.JTable();
        BtAltera = new javax.swing.JButton();
        BtExclui = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Descrição");

        TxtFieldDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFieldDescActionPerformed(evt);
            }
        });

        jLabel2.setText("Ementa");

        TxtFieldEmenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFieldEmentaActionPerformed(evt);
            }
        });

        BtGrava.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/add.png"))); // NOI18N
        BtGrava.setText("Inserir");
        BtGrava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtGravaActionPerformed(evt);
            }
        });

        jTabCurso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DESCRICAO", "EMENTA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabCurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabCursoMouseClicked(evt);
            }
        });
        jTabCurso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTabCursoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTabCurso);

        BtAltera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/edit.png"))); // NOI18N
        BtAltera.setText("Alterar");
        BtAltera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAlteraActionPerformed(evt);
            }
        });

        BtExclui.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/delete.png"))); // NOI18N
        BtExclui.setText("Excluir");
        BtExclui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtExcluiActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/eraser.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(14, 14, 14)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtFieldDesc)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TxtFieldEmenta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtGrava, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(88, 88, 88)
                        .addComponent(BtAltera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(88, 88, 88)
                        .addComponent(BtExclui, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtFieldDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtFieldEmenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtGrava, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtAltera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtExclui, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtFieldEmentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFieldEmentaActionPerformed
  
    }//GEN-LAST:event_TxtFieldEmentaActionPerformed

    private void TxtFieldDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFieldDescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtFieldDescActionPerformed

    public void readTable(){
    
        DefaultTableModel modelo = (DefaultTableModel) jTabCurso.getModel();
        CursoDAO cdao = new CursoDAO();
        modelo.setRowCount(0);
        
        for (ClassCurso c : cdao.read()) {
            
             modelo.addRow(new Object[]{
                 c.getCodigo(),
                 c.getDescricao(),
                 c.getEmenta()
             }
             ); 
            
        }
    
    }
    
    private void limpaCampos(){
        TxtFieldDesc.setText(null);
        TxtFieldEmenta.setText(null);
    }
    
    private void carregaCampos(){
        if (jTabCurso.getSelectedRow() != -1){
            
            TxtFieldDesc.setText(jTabCurso.getValueAt(jTabCurso.getSelectedRow(), 1).toString());
            TxtFieldEmenta.setText(jTabCurso.getValueAt(jTabCurso.getSelectedRow(), 2).toString());
        }
    }
    
    private void BtGravaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtGravaActionPerformed
        // TODO add your handling code here:
        ClassCurso c = new ClassCurso();
        CursoDAO dao = new CursoDAO();
        c.setDescricao(TxtFieldDesc.getText());
        c.setEmenta(TxtFieldEmenta.getText());
        dao.create(c);
        readTable();
        limpaCampos();
    }//GEN-LAST:event_BtGravaActionPerformed

    private void jTabCursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabCursoMouseClicked
        // TODO add your handling code here:
        carregaCampos();
    }//GEN-LAST:event_jTabCursoMouseClicked

    private void jTabCursoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTabCursoKeyReleased
        // TODO add your handling code here:

        carregaCampos();
    }//GEN-LAST:event_jTabCursoKeyReleased

    private void BtAlteraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAlteraActionPerformed
        // TODO add your handling code here:
        if (jTabCurso.getSelectedRow() != -1){
            
        ClassCurso c = new ClassCurso();
        CursoDAO dao = new CursoDAO();
        c.setDescricao(TxtFieldDesc.getText());
        c.setEmenta(TxtFieldEmenta.getText());
        c.setCodigo((int) jTabCurso.getValueAt(jTabCurso.getSelectedRow(), 0));
        dao.update(c);
        readTable();
        limpaCampos();
        
        }
    }//GEN-LAST:event_BtAlteraActionPerformed

    private void BtExcluiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtExcluiActionPerformed
        // TODO add your handling code here:
     if (jTabCurso.getSelectedRow() != -1){
            
        ClassCurso c = new ClassCurso();
        CursoDAO dao = new CursoDAO();
        c.setCodigo((int) jTabCurso.getValueAt(jTabCurso.getSelectedRow(), 0));
        dao.delete(c);
        readTable();
        limpaCampos();
        }       
    }//GEN-LAST:event_BtExcluiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        limpaCampos();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Curso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Curso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Curso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Curso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Curso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAltera;
    private javax.swing.JButton BtExclui;
    private javax.swing.JButton BtGrava;
    private javax.swing.JTextField TxtFieldDesc;
    private javax.swing.JTextField TxtFieldEmenta;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabCurso;
    // End of variables declaration//GEN-END:variables
}
