package server;

import java.io.Serializable;

// @author Alexander on Dec 3, 2023
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String primerNombre;
    private String segundoNombre;
    private String email;
    private String fechaNac;
    private double sueldo;
    private String comision;
    private int cargoId;
    private int gerenteId;
    private int dptoId;

    public Empleado() {
        // Constructor vacío requerido para la serialización
    }

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
