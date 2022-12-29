/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import static datos.conexion.close;
import static datos.conexion.getConnection;
import domain.Medicamentos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author poiu0
 */
public class MedicamentosDAO {
     private static final String SQL_SELECT = "SELECT id_medicamento, nombre_medicamento, laboratorio, existencias, tipo_medicamento, caducidad, requiere_receta FROM medicamentos";
     private static final String SQL_SELECT_BY_ID = "SELECT id_medicamento, nombre_medicamento, laboratorio, existencias, tipo_medicamento, caducidad, requiere_receta FROM medicamentos WHERE id_medicamento = ?";
    private static final String SQL_INSERT = "INSERT INTO medicamentos (nombre_medicamento, laboratorio, existencias, tipo_medicamento, caducidad, requiere_receta) VALUES (?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE medicamentos SET nombre_medicamento = ?, laboratorio = ?, existencias = ?, tipo_medicamento = ?, caducidad = ?, requiere_receta = ? WHERE id_medicamento = ?";
    private static final String SQL_DELETE = "DELETE FROM medicamentos WHERE id_medicamento = ?";
    
    public List<Medicamentos>seleccionar(){
          Connection conn  = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Medicamentos medicamentos = null;
        List<Medicamentos> medica = new ArrayList<>();
        
    try {
     
     
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                
                int id_medicamento = rs.getInt("id_medicamento");
                String nombre_medicamento = rs.getString("nombre_medicamento");
                String laboratorio = rs.getString("laboratorio");
                int existencias = rs.getInt("existencias");
                String tipo_medicamento = rs.getString("tipo_medicamento");
                String caducidad = rs.getString("caducidad");
                Boolean requiere_receta = rs.getBoolean("requiere_receta");
             
                
                medicamentos = new Medicamentos (id_medicamento,nombre_medicamento,laboratorio,existencias,tipo_medicamento,caducidad,requiere_receta);
                System.out.println(medicamentos);
                
                medica.add(medicamentos);
            }
            
        } catch (SQLException ex){
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
          return medica;
    }
   
    public Medicamentos buscar(Medicamentos medicamento){
                Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, medicamento.getId_medicamento());
            rs = stmt.executeQuery();
            
            rs.next();
            int id_medicamento = rs.getInt("id_medicamento");
                String nombre_medicamento = rs.getString("nombre_medicamento");
                String laboratorio = rs.getString("laboratorio");
                int existencias = rs.getInt("existencias");
                String tipo_medicamento = rs.getString("tipo_medicamento");
                String caducidad = rs.getString("caducidad");
                Boolean requiere_receta = rs.getBoolean("requiere_receta");
            
            medicamento.setId_medicamento(id_medicamento);
            medicamento.setNombre_medicamento(nombre_medicamento);
            medicamento.setLaboratorio(laboratorio);
            medicamento.setExistencias(existencias);
            medicamento.setTipo_medicamento(tipo_medicamento);
            medicamento.setcaducidad(caducidad);
            medicamento.setRequiere_receta(requiere_receta);
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return medicamento;
    }
    
    public int insertar(Medicamentos medicamentos){
        Connection conn  = null;
        PreparedStatement stmt = null;
        
        int registros = 0;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, medicamentos.getNombre_medicamento());
            stmt.setString(2, medicamentos.getLaboratorio());
            stmt.setInt(3, medicamentos.getExistencias());
            stmt.setString(4, medicamentos.getTipo_medicamento());
            stmt.setString(5, medicamentos.getcaducidad());
            stmt.setBoolean(6, medicamentos.getRequiere_receta());
         
            
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int actualizar(Medicamentos medicamentos){
        Connection conn  = null;
        PreparedStatement stmt = null;
        
        int registros = 0;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, medicamentos.getNombre_medicamento());
            stmt.setString(2, medicamentos.getLaboratorio());
            stmt.setInt(3, medicamentos.getExistencias());
            stmt.setString(4, medicamentos.getTipo_medicamento());
            stmt.setString(5, medicamentos.getcaducidad());
            stmt.setBoolean(6, medicamentos.getRequiere_receta());
            stmt.setInt(7, medicamentos.getId_medicamento());
       
            
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
        public int eliminar(Medicamentos medicamentos){
        Connection conn  = null;
        PreparedStatement stmt = null;
        
        int registros = 0;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, medicamentos.getId_medicamento());
            
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
