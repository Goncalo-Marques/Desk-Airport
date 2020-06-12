/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.Voo;

import java.sql.Date;
import java.sql.Time;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.bean.Piloto;
import model.bean.Voo;
import model.dao.PilotoDao;
import model.dao.VooDao;

/**
 *
 * @author Beatriz Marques
 */
public class vooEditar extends javax.swing.JFrame {

    /**
     * Creates new form vooEditar
     */
    public vooEditar() {
        initComponents();

        atualizaComboBoxIdPiloto();
        atualizaComboBoxNum(null);
    }

    public void atualizaComboBoxNum(String num) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        comboNum.setModel(model);

        VooDao vooDao = new VooDao();

        for (Voo v : vooDao.read()) {
            comboNum.addItem(v.getNum());
        }

        if (num != null) {
            for (Voo v : vooDao.read()) {
                if (v.getNum().equals(num)) {
                    comboNum.setSelectedItem((String) num);
                }
            }
        }
    }

    public void atualizaComboBoxIdPiloto() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        comboId.setModel(model);

        PilotoDao pilotoDao = new PilotoDao();

        for (Piloto p : pilotoDao.read()) {
            comboId.addItem(p.getIdPiloto());
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

        jPanel1 = new javax.swing.JPanel();
        comboNum = new javax.swing.JComboBox();
        comboId = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        jLabel11 = new javax.swing.JLabel();
        txtDe = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        txtPara = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        txtHora = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Voo Editar");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        comboNum.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        comboNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboNumActionPerformed(evt);
            }
        });

        comboId.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        comboId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboIdActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Número");

        txtMatricula.setBackground(new java.awt.Color(51, 51, 51));
        txtMatricula.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txtMatricula.setForeground(new java.awt.Color(255, 255, 255));
        txtMatricula.setBorder(null);
        txtMatricula.setCaretColor(new java.awt.Color(204, 204, 204));
        txtMatricula.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatriculaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Matrícula");

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));

        jLabel7.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Data (aaaa-mm-dd)");

        jSeparator6.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator7.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));

        jLabel10.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Hora (hh:mm:ss)");

        button1.setActionCommand("Editar");
        button1.setBackground(new java.awt.Color(51, 51, 51));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setLabel("Editar");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setBackground(new java.awt.Color(51, 51, 51));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setLabel("Cancelar");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("De");

        txtDe.setBackground(new java.awt.Color(51, 51, 51));
        txtDe.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txtDe.setForeground(new java.awt.Color(255, 255, 255));
        txtDe.setBorder(null);
        txtDe.setCaretColor(new java.awt.Color(204, 204, 204));
        txtDe.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDeActionPerformed(evt);
            }
        });

        jSeparator8.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));

        txtPara.setBackground(new java.awt.Color(51, 51, 51));
        txtPara.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txtPara.setForeground(new java.awt.Color(255, 255, 255));
        txtPara.setBorder(null);
        txtPara.setCaretColor(new java.awt.Color(204, 204, 204));
        txtPara.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtPara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtParaActionPerformed(evt);
            }
        });

        jSeparator9.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));

        jLabel12.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Para");

        txtData.setBackground(new java.awt.Color(51, 51, 51));
        txtData.setBorder(null);
        txtData.setForeground(new java.awt.Color(255, 255, 255));
        txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        txtData.setCaretColor(new java.awt.Color(255, 255, 255));
        txtData.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtData.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtData.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        txtHora.setBackground(new java.awt.Color(51, 51, 51));
        txtHora.setBorder(null);
        txtHora.setForeground(new java.awt.Color(255, 255, 255));
        txtHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance())));
        txtHora.setCaretColor(new java.awt.Color(255, 255, 255));
        txtHora.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtHora.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtHora.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 15)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Id Piloto");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboNum, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtMatricula)
                                        .addComponent(jSeparator5)
                                        .addComponent(jLabel5)
                                        .addComponent(jSeparator6)
                                        .addComponent(jLabel7)
                                        .addComponent(jSeparator7)
                                        .addComponent(txtDe)
                                        .addComponent(jSeparator8)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtPara, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                                                .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE))
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel13)
                                            .addComponent(comboId, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel10)
                                        .addComponent(txtData)
                                        .addComponent(txtHora))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(comboNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel5)
                .addGap(6, 6, 6)
                .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(6, 6, 6)
                .addComponent(txtDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(6, 6, 6)
                .addComponent(txtPara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void comboNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboNumActionPerformed
        if (comboNum.getItemCount() != 0) {
            VooDao vooDao = new VooDao();

            Voo voo = vooDao.readNum((String) comboNum.getSelectedItem());

            txtMatricula.setText(voo.getMatr());
            txtData.setText(String.valueOf(voo.getData()));
            txtHora.setText(String.valueOf(voo.getHora()));
            txtDe.setText(voo.getDe());
            txtPara.setText(voo.getPara());
            comboId.setSelectedItem((int) voo.getIdPiloto());
        }
    }//GEN-LAST:event_comboNumActionPerformed

    private void txtParaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtParaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtParaActionPerformed

    private void txtDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDeActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_button2ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        if (comboNum.getItemCount() != 0 && comboId.getItemCount() != 0 && !txtMatricula.getText().equals("") && !txtData.getText().equals("") && !txtHora.getText().equals("") && !txtDe.getText().equals("") && !txtPara.getText().equals("")) {
            try {
                Voo voo = new Voo();
                VooDao vooDao = new VooDao();

                voo.setNum((String) comboNum.getSelectedItem());
                voo.setMatr(txtMatricula.getText());
                voo.setData(Date.valueOf(txtData.getText()));
                voo.setHora(Time.valueOf(txtHora.getText()));
                voo.setDe(txtDe.getText());
                voo.setPara(txtPara.getText());
                voo.setIdPiloto((int) comboId.getSelectedItem());

                vooDao.update(voo);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nada Selecionado!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_button1ActionPerformed

    private void txtMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatriculaActionPerformed

    private void comboIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboIdActionPerformed

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
            java.util.logging.Logger.getLogger(vooEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vooEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vooEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vooEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vooEditar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Button button2;
    private javax.swing.JComboBox comboId;
    private javax.swing.JComboBox comboNum;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtDe;
    private javax.swing.JFormattedTextField txtHora;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtPara;
    // End of variables declaration//GEN-END:variables
}
