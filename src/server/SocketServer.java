package server;

import java.io.*;
import java.net.*;
import java.sql.*;

// @author Alexander on Dec 3, 2023
public class SocketServer {

    // Puerto donde escucha el servidor
    private static final int PUERTO = 5000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado y contestando OK");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {

    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            Connection connection = DriverManager.getConnection("jdbc:mysql://human-resources.cqawfiwiwudi.us-east-2.rds.amazonaws.com:3306/human-resources", "admin", "W49TI1HYbQpjwPX9M8gr");

            while (true) {
                String command = (String) in.readObject();
                if (command.equalsIgnoreCase("Insert")) {
                    // Recibe los datos del empleado desde el cliente y realiza la inserción en la base de datos
                    Empleado empleado = (Empleado) in.readObject();
                    insertarEmpleado(empleado, connection);

                    out.writeObject("Inserción exitosa");
                } else if (command.equalsIgnoreCase("Update")) {
                    // Lógica para procesar la actualización de un empleado
                    // Recibe los datos del empleado actualizado desde el cliente y actualiza la base de datos

                    int empleadoId = in.readInt();
                    Empleado empleadoActualizado = (Empleado) in.readObject();
                    boolean actualizacionExitosa = actualizarEmpleado(empleadoId, empleadoActualizado, connection);

                    if (actualizacionExitosa) {
                        out.writeObject("Actualización exitosa");
                    } else {
                        out.writeObject("No se pudo actualizar el empleado");
                    }
                } else if (command.equalsIgnoreCase("Select")) {
                    // Recibe el ID del empleado y devuelve los datos al cliente
//                    int empleadoId = in.read();
                    out.writeObject("Buscando...");
                    int empleadoId = in.readInt();
                    Empleado empleado = seleccionarEmpleado(empleadoId, connection);

                    System.out.println("Respuesta: " + empleado);
                    // Envía los datos del empleado al cliente
                    out.writeObject(empleado);
                } else if (command.equalsIgnoreCase("Delete")) {
                    // Lógica para procesar la eliminación de un empleado
                    // Recibe el ID del empleado, realiza un borrado lógico y agrega al histórico
                    int empleadoId = in.readInt();
                    boolean eliminacionExitosa = eliminarEmpleado(empleadoId, connection);

                    if (eliminacionExitosa) {
                        out.writeObject("Eliminación exitosa");
                    } else {
                        out.writeObject("No se pudo eliminar el empleado");
                    }
                } else if (command.equalsIgnoreCase("Exit")) {
                    break; // Sale del bucle cuando el cliente decide cerrar la conexión
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertarEmpleado(Empleado empleado, Connection connection) throws SQLException {
        // Aquí implementa la lógica específica para la inserción de un empleado en la base de datos

        try ( PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO empleados (primerNombre, segundoNombre, email, fechaNac, sueldo, comision, cargoId, gerenteId, dptoId) VALUES (?, ?, ?, ? ,?, ?, ?, ?, ?)")) {
            statement.setString(1, empleado.getPrimerNombre());
            statement.setString(2, empleado.getSegundoNombre());
            statement.setString(3, empleado.getEmail());
            statement.setString(4, empleado.getFechaNac());
            statement.setDouble(5, empleado.getSueldo());
            statement.setString(6, empleado.getComision());
            statement.setInt(7, empleado.getCargoId());
            statement.setInt(8, empleado.getGerenteId());
            statement.setInt(9, empleado.getDptoId());

            // Ejecuta la inserción
            statement.executeUpdate();
        }
    }

    private Empleado seleccionarEmpleado(int empleadoId, Connection connection) throws SQLException {
        // Lógica para buscar el empleado en la base de datos por su ID

        Empleado empleado = null;

        try ( PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM empleados WHERE id = ?")) {
            statement.setInt(1, empleadoId);

            try ( ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Crea un objeto Empleado con los datos obtenidos de la base de datos
                    empleado = new Empleado(
                            resultSet.getString("primerNombre"),
                            resultSet.getString("segundoNombre"),
                            resultSet.getString("email"),
                            resultSet.getString("fechaNac"),
                            resultSet.getDouble("sueldo"),
                            resultSet.getString("comision"),
                            resultSet.getInt("cargoId"),
                            resultSet.getInt("gerenteId"),
                            resultSet.getInt("dptoId")
                    );
                }
            }
        }

        return empleado;
    }

    private boolean eliminarEmpleado(int empleadoId, Connection connection) throws SQLException {
        // Lógica para realizar la eliminación física de un empleado

        try ( PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM empleados WHERE id = ?")) {
            statement.setInt(1, empleadoId);

            // Ejecuta la eliminación
            int filasAfectadas = statement.executeUpdate();

            // Devuelve true si al menos una fila fue afectada, indicando una eliminación exitosa
            return filasAfectadas > 0;
        }
    }

    private boolean actualizarEmpleado(int empleadoId, Empleado empleado, Connection connection) throws SQLException {
        // Lógica para actualizar un empleado en la base de datos

        try ( PreparedStatement statement = connection.prepareStatement(
                "UPDATE empleados SET primerNombre=?, segundoNombre=?, email=?, fechaNac=?, sueldo=?, comision=?, cargoId=?, gerenteId=?, dptoId=? WHERE id=?")) {
            statement.setString(1, empleado.getPrimerNombre());
            statement.setString(2, empleado.getSegundoNombre());
            statement.setString(3, empleado.getEmail());
            statement.setString(4, empleado.getFechaNac());
            statement.setDouble(5, empleado.getSueldo());
            statement.setString(6, empleado.getComision());
            statement.setInt(7, empleado.getCargoId());
            statement.setInt(8, empleado.getGerenteId());
            statement.setInt(9, empleado.getDptoId());
            statement.setInt(10, empleadoId);

            // Ejecuta la actualización
            int filasAfectadas = statement.executeUpdate();

            // Devuelve true si al menos una fila fue afectada, indicando una actualización exitosa
            return filasAfectadas > 0;
        }
    }
}
