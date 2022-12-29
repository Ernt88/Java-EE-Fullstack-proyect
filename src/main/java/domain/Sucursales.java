/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author poiu0
 */
public class Sucursales {

    private int id_sucursal;
    private String nombre_sucursal;
    private String ubicacion;
    private int cantidad_empleados;
    private int id_trabajador_encargado;

    public Sucursales(int id_sucursal, String nombre_sucursal, String ubicacion, int id_trabajador_encargado, int cantidad_empleados) {
        this.id_sucursal = id_sucursal;
        this.nombre_sucursal = nombre_sucursal;
        this.ubicacion = ubicacion;
        this.id_trabajador_encargado = id_trabajador_encargado;
        this.cantidad_empleados = cantidad_empleados;
    }
    
    public Sucursales(String nombre_sucursal, String ubicacion, int id_trabajador_encargado, int cantidad_empleados) {
        this.nombre_sucursal = nombre_sucursal;
        this.ubicacion = ubicacion;
        this.id_trabajador_encargado = id_trabajador_encargado;
        this.cantidad_empleados = cantidad_empleados;
    }
    
    public Sucursales(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public String getNombre_sucursal() {
        return nombre_sucursal;
    }

    public void setNombre_sucursal(String nombre_sucursal) {
        this.nombre_sucursal = nombre_sucursal;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getId_trabajador_encargado() {
        return id_trabajador_encargado;
    }

    public void setId_trabajador_encargado(int id_trabajador_encargado) {
        this.id_trabajador_encargado = id_trabajador_encargado;
    }

    public int getCantidad_empleados() {
        return cantidad_empleados;
    }

    public void setCantidad_empleados(int cantidad_empleados) {
        this.cantidad_empleados = cantidad_empleados;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sucursales{");
        sb.append("id_sucursal=").append(id_sucursal);
        sb.append(", nombre_sucursal=").append(nombre_sucursal);
        sb.append(", ubicacion=").append(ubicacion);
        sb.append(", id_trabajador_encargado=").append(id_trabajador_encargado);
        sb.append(", cantidad_empleados=").append(cantidad_empleados);
        sb.append('}');
        return sb.toString();
    }

}
