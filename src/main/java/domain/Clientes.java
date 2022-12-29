
package domain;

/**
 *
 * @author poiu0
 */
public class Clientes {
    private int id_Cliente;
    private String nombre;
    private String fecha_afiliacion;
    private String telefono;

    public Clientes(int id_Cliente, String nombre, String fecha_afiliacion, String telefono) {
        this.id_Cliente = id_Cliente;
        this.nombre = nombre;
        this.fecha_afiliacion = fecha_afiliacion;
        this.telefono = telefono;
    }
    
    public Clientes(String nombre, String fecha_afiliacion, String telefono) {
        this.nombre = nombre;
        this.fecha_afiliacion = fecha_afiliacion;
        this.telefono = telefono;
    }
    
    public Clientes(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_afiliacion() {
        return fecha_afiliacion;
    }

    public void setFecha_afiliacion(String fecha_afiliacion) {
        this.fecha_afiliacion = fecha_afiliacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
     
    
        @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Clientes{");
        sb.append("id_Cliente=").append(id_Cliente);
        sb.append(", nombre=").append(nombre);
        sb.append(", fecha_afiliacion=").append(fecha_afiliacion);
        sb.append(", telefono=").append(telefono);
        sb.append('}');
        return sb.toString();
    }
        
    

    
   
      
      
}

