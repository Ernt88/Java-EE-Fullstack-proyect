/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author poiu0
 */
public class Trabajadores {

    private int id_trabajador;
    private String nombre;
    private String telefono;
    private String n_afiliacion_imss;
    private int id_sucursal;

    public Trabajadores(int id_trabajador, String nombre, int id_sucursal, String telefono, String n_afiliacion_imss) {
        this.id_trabajador = id_trabajador;
        this.nombre = nombre;
        this.id_sucursal = id_sucursal;
        this.telefono = telefono;
        this.n_afiliacion_imss = n_afiliacion_imss;
    }
    
    public Trabajadores(String nombre, int id_sucursal, String telefono, String n_afiliacion_imss) {
        this.nombre = nombre;
        this.id_sucursal = id_sucursal;
        this.telefono = telefono;
        this.n_afiliacion_imss = n_afiliacion_imss;
    }
    
    public Trabajadores(int id_trabajador) {
        this.id_trabajador = id_trabajador;
    }

    public int getId_trabajador() {
        return id_trabajador;
    }

    public void setId_trabajador(int id_trabajador) {
        this.id_trabajador = id_trabajador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getN_afiliacion_imss() {
        return n_afiliacion_imss;
    }

    public void setN_afiliacion_imss(String n_afiliacion_imss) {
        this.n_afiliacion_imss = n_afiliacion_imss;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Provedores{");
        sb.append("id_trabajador=").append(id_trabajador);
        sb.append(", nombre=").append(nombre);
        sb.append(", id_sucursal=").append(id_sucursal);
        sb.append(", telefono=").append(telefono);
        sb.append(", n_afiliacion_imss=").append(n_afiliacion_imss);
        sb.append('}');
        return sb.toString();
    }
}
