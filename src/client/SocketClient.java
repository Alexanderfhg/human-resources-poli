package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;
import server.Empleado;

/**
 * Clase que representa el cliente para la gestión de empleados mediante sockets.
 * Permite la conexión con el servidor y envío/recepción de datos.
 * También contiene métodos para manejar la interfaz gráfica de usuario.
 * @author Subgrupo1
 * @since Dec 3, 2023
 */
public class SocketClient extends javax.swing.JFrame {

    private ObjectOutputStream out;
    public ObjectInputStream in;
    private Socket socket;

    /**
     * Constructor de la clase SocketClient.
     */
    public SocketClient() {
        initComponents();
        conectarAlServidor();
    }

    /**
     * Método privado para establecer la conexión con el servidor.
     */
    private void conectarAlServidor() {
        try {
            socket = new Socket("localhost", 5000);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para enviar datos al servidor.
     * @param comando El comando a ser enviado.
     * @param empleado El objeto Empleado a ser enviado (en caso de "Insert" y "Update").
     * @throws ClassNotFoundException Si ocurre un error al recibir datos del servidor.
     */
    public void enviarDatosAlServidor(String comando, Empleado empleado) throws ClassNotFoundException {
        try {
            out.writeObject(comando);

            if (comando.equalsIgnoreCase("Insert")) {
                // Enviar un objeto Empleado para Insert
                out.writeObject(empleado);
            }

            String respuesta = (String) in.readObject();
            System.out.println("Respuesta del servidor: " + respuesta);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para enviar datos al servidor y recibir un objeto Empleado.
     * @param comando El comando a ser enviado.
     * @param empleadoId El ID del empleado a ser enviado (en caso de "Select" y "Delete").
     * @return El objeto Empleado recibido del servidor.
     * @throws ClassNotFoundException Si ocurre un error al recibir datos del servidor.
     */
    // Versión que recibe un entero
    public Empleado enviarDatosAlServidor(String comando, int empleadoId) throws ClassNotFoundException {
        try {
            out.writeObject(comando);
            out.flush();  // Asegurar que los datos se envíen de inmediato

            if (comando.equalsIgnoreCase("Select")) {
                // Si el comando es "Select", envía el empleadoId y espera la señal del servidor
                out.writeInt(empleadoId);
                out.flush();  // Asegurar que los datos se envíen de inmediato

                String confirmacion = (String) in.readObject();
                System.out.println(confirmacion);

                Empleado empleadoSeleccionado = (Empleado) in.readObject();
                return empleadoSeleccionado;
            } else if (comando.equalsIgnoreCase("Delete")) {
                out.writeInt(empleadoId);
                out.flush();

                JOptionPane.showMessageDialog(this, in.readObject());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Método para enviar datos al servidor y recibir una confirmación.
     * @param comando El comando a ser enviado.
     * @param empleadoId El ID del empleado a ser enviado (en caso de "Update").
     * @param empleado El objeto Empleado a ser enviado (en caso de "Update").
     * @return La confirmación recibida del servidor.
     * @throws ClassNotFoundException Si ocurre un error al recibir datos del servidor.
     */
    public String enviarDatosAlServidor(String comando, int empleadoId, Empleado empleado) throws ClassNotFoundException {
        try {
            out.writeObject(comando);
            out.flush();

            if (comando.equalsIgnoreCase("Update")) {
                out.writeInt(empleadoId);
                out.writeObject(empleado);
                out.flush();

                // Devuelve el mensaje de confirmación del servidor
                return (String) in.readObject();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonCreate = new javax.swing.JButton();
        jButtonRead = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jLabelTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonCreate.setText("Insertar");
        jButtonCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateActionPerformed(evt);
            }
        });

        jButtonRead.setText("Consultar");
        jButtonRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReadActionPerformed(evt);
            }
        });

        jButtonUpdate.setText("Actualizar");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Eliminar");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jLabelTitle.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelTitle.setText("Administrar Empleados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonRead, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(85, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabelTitle)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRead, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateActionPerformed
        InsertarEmpleado insertarEmpleado = new InsertarEmpleado();
        insertarEmpleado.setVisible(true);
    }//GEN-LAST:event_jButtonCreateActionPerformed

    private void jButtonReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReadActionPerformed
        ConsultarEmpleado consultarEmpleado = new ConsultarEmpleado();
        consultarEmpleado.setVisible(true);
    }//GEN-LAST:event_jButtonReadActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        EliminarEmpleado eliminarEmpleado = new EliminarEmpleado();
        eliminarEmpleado.setVisible(true);
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        ActualizarEmpleado actualizarEmpleado = new ActualizarEmpleado();
        actualizarEmpleado.setVisible(true);
    }//GEN-LAST:event_jButtonUpdateActionPerformed

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
            java.util.logging.Logger.getLogger(SocketClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SocketClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SocketClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SocketClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SocketClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCreate;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonRead;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JLabel jLabelTitle;
    // End of variables declaration//GEN-END:variables
}
