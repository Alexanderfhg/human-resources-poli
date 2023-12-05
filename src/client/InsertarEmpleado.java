package client;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import server.Empleado;

// @author Alexander on Dec 3, 2023
public class InsertarEmpleado extends javax.swing.JFrame {

    public InsertarEmpleado() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitle = new javax.swing.JLabel();
        jLabelFirstName = new javax.swing.JLabel();
        jLabelSecondName = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelBirthDate = new javax.swing.JLabel();
        jLabelSalary = new javax.swing.JLabel();
        jLabelCommission = new javax.swing.JLabel();
        jLabelPositionId = new javax.swing.JLabel();
        jLabelManagerId = new javax.swing.JLabel();
        jLabelDepartmentId = new javax.swing.JLabel();
        jTextFieldFirstName = new javax.swing.JTextField();
        jTextFieldSecondName = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldBirthDate = new javax.swing.JTextField();
        jTextFieldSalary = new javax.swing.JTextField();
        jTextFieldCommission = new javax.swing.JTextField();
        jTextFieldPositionId = new javax.swing.JTextField();
        jTextFieldManagerId = new javax.swing.JTextField();
        jTextFieldDepartmentId = new javax.swing.JTextField();
        jButtonCreate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelTitle.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelTitle.setText("Insertar Empleado");

        jLabelFirstName.setText("Primer nombre:");

        jLabelSecondName.setText("Segundo nombre:");

        jLabelEmail.setText("Email:");

        jLabelBirthDate.setText("Fecha de nacimiento:");

        jLabelSalary.setText("Sueldo:");

        jLabelCommission.setText("Comisión:");

        jLabelPositionId.setText("Cargo ID:");

        jLabelManagerId.setText("Gerente ID:");

        jLabelDepartmentId.setText("Departamento ID:");

        jButtonCreate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonCreate.setText("Insertar");
        jButtonCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(154, Short.MAX_VALUE)
                .addComponent(jLabelTitle)
                .addContainerGap(154, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelSecondName)
                            .addComponent(jLabelFirstName)
                            .addComponent(jLabelEmail)
                            .addComponent(jLabelBirthDate)
                            .addComponent(jLabelSalary)
                            .addComponent(jLabelCommission)
                            .addComponent(jLabelPositionId)
                            .addComponent(jLabelManagerId)
                            .addComponent(jLabelDepartmentId))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldFirstName)
                            .addComponent(jTextFieldSecondName)
                            .addComponent(jTextFieldEmail)
                            .addComponent(jTextFieldBirthDate)
                            .addComponent(jTextFieldSalary)
                            .addComponent(jTextFieldCommission)
                            .addComponent(jTextFieldPositionId)
                            .addComponent(jTextFieldManagerId)
                            .addComponent(jTextFieldDepartmentId))))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabelTitle)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFirstName)
                    .addComponent(jTextFieldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSecondName)
                    .addComponent(jTextFieldSecondName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmail)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelBirthDate)
                    .addComponent(jTextFieldBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSalary)
                    .addComponent(jTextFieldSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCommission)
                    .addComponent(jTextFieldCommission, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPositionId)
                    .addComponent(jTextFieldPositionId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelManagerId)
                    .addComponent(jTextFieldManagerId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDepartmentId)
                    .addComponent(jTextFieldDepartmentId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jButtonCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateActionPerformed
        try {
            String primerNombre = jTextFieldFirstName.getText();
            String segundoNombre = jTextFieldSecondName.getText();
            String email = jTextFieldEmail.getText();
            String fechaNac = jTextFieldBirthDate.getText();
            double sueldo = Double.parseDouble(jTextFieldSalary.getText());
            String comision = jTextFieldCommission.getText();
            int cargoId = Integer.parseInt(jTextFieldPositionId.getText());
            int gerenteId = Integer.parseInt(jTextFieldManagerId.getText());
            int dptoId = Integer.parseInt(jTextFieldDepartmentId.getText());

            Empleado empleado = new Empleado(primerNombre, segundoNombre, email, fechaNac, sueldo, comision, cargoId, gerenteId, dptoId);
            SocketClient socketClient = new SocketClient();

            socketClient.enviarDatosAlServidor("Insert", empleado);

            JOptionPane.showMessageDialog(this, "Inserción exitosa");
        } catch (NumberFormatException ex) {
            // Manejar la excepción si los campos numéricos no contienen valores válidos
            JOptionPane.showMessageDialog(this, "Ingrese valores numéricos para campos numéricos");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsertarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonCreateActionPerformed

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
            java.util.logging.Logger.getLogger(InsertarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsertarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsertarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsertarEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCreate;
    private javax.swing.JLabel jLabelBirthDate;
    private javax.swing.JLabel jLabelCommission;
    private javax.swing.JLabel jLabelDepartmentId;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelFirstName;
    private javax.swing.JLabel jLabelManagerId;
    private javax.swing.JLabel jLabelPositionId;
    private javax.swing.JLabel jLabelSalary;
    private javax.swing.JLabel jLabelSecondName;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JTextField jTextFieldBirthDate;
    private javax.swing.JTextField jTextFieldCommission;
    private javax.swing.JTextField jTextFieldDepartmentId;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldFirstName;
    private javax.swing.JTextField jTextFieldManagerId;
    private javax.swing.JTextField jTextFieldPositionId;
    private javax.swing.JTextField jTextFieldSalary;
    private javax.swing.JTextField jTextFieldSecondName;
    // End of variables declaration//GEN-END:variables
}
