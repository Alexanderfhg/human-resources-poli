package server;

import java.io.Serializable;

/**
 * Clase que representa un empleado con sus atributos.
 * Implementa la interfaz Serializable para permitir la serialización.
 * @author Subgrupo1
 * @since Dec 3, 2023
 */
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;

    /** Identificador único del empleado. */
    private int id;

    /** Primer nombre del empleado. */
    private String primerNombre;

    /** Segundo nombre del empleado. */
    private String segundoNombre;

    /** Dirección de correo electrónico del empleado. */
    private String email;

    /** Fecha de nacimiento del empleado. */
    private String fechaNac;

    /** Salario del empleado. */
    private double sueldo;

    /** Comisión del empleado. */
    private String comision;

    /** Identificador del cargo del empleado. */
    private int cargoId;

    /** Identificador del gerente del empleado. */
    private int gerenteId;

    /** Identificador del departamento del empleado. */
    private int dptoId;

    /**
     * Constructor vacío requerido para la serialización.
     */
    public Empleado() {
        // Constructor vacío requerido para la serialización
    }

    /**
     * Constructor de la clase Empleado.
     * @param primerNombre Primer nombre del empleado.
     * @param segundoNombre Segundo nombre del empleado.
     * @param email Dirección de correo electrónico del empleado.
     * @param fechaNac Fecha de nacimiento del empleado.
     * @param sueldo Salario del empleado.
     * @param comision Comisión del empleado.
     * @param cargoId Identificador del cargo del empleado.
     * @param gerenteId Identificador del gerente del empleado.
     * @param dptoId Identificador del departamento del empleado.
     */
    public Empleado(String primerNombre, String segundoNombre, String email, String fechaNac, double sueldo, String comision, int cargoId, int gerenteId, int dptoId) {
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.email = email;
        this.fechaNac = fechaNac;
        this.sueldo = sueldo;
        this.comision = comision;
        this.cargoId = cargoId;
        this.gerenteId = gerenteId;
        this.dptoId = dptoId;
    }

    public int getId() {
        return id;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getComision() {
        return comision;
    }

    public void setComision(String comision) {
        this.comision = comision;
    }

    public int getCargoId() {
        return cargoId;
    }

    public void setCargoId(int cargoId) {
        this.cargoId = cargoId;
    }

    public int getGerenteId() {
        return gerenteId;
    }

    public void setGerenteId(int gerenteId) {
        this.gerenteId = gerenteId;
    }

    public int getDptoId() {
        return dptoId;
    }

    public void setDptoId(int dptoId) {
        this.dptoId = dptoId;
    }
}
