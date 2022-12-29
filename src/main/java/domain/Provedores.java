/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author poiu0
 */
public class Provedores {
    private int id_proveedor;
    private String nombre;
      private String telefono;
      private String firma_farmaceutica;
      private String correo;

    public Provedores(int id_proveedor, String nombre, String telefono, String firma_farmaceutica, String correo) {
        this.id_proveedor = id_proveedor;
        this.nombre = nombre;
        this.telefono = telefono;
        this.firma_farmaceutica = firma_farmaceutica;
        this.correo = correo;
    }
    
    public Provedores(String nombre, String telefono, String firma_farmaceutica, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.firma_farmaceutica = firma_farmaceutica;
        this.correo = correo;
    }
    
    public Provedores(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFirma_farmaceutica() {
        return firma_farmaceutica;
    }

    public void setFirma_farmaceutica(String firma_farmaceutica) {
        this.firma_farmaceutica = firma_farmaceutica;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
      
    
  
    
        @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Provedores{");
        sb.append("id_proveedor=").append(id_proveedor);
        sb.append(", nombre=").append(nombre);
        sb.append(", telefono=").append(telefono);
        sb.append(", firma_farmaceutica=").append(firma_farmaceutica);
        sb.append(", correo=").append(correo);
        sb.append('}');
        return sb.toString();
    }
      
        
}
