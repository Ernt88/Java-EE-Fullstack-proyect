/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import static datos.conexion.*;
import domain.Clientes;
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
public class ClientesDAO {
    
    private static final String SQL_SELECT = "SELECT id_Cliente, nombre, fecha_afiliacion, telefono FROM cliente";
    private static final String SQL_SELECT_BY_ID = "SELECT id_Cliente, nombre, fecha_afiliacion, telefono FROM cliente WHERE id_Cliente = ?";
    private static final String SQL_INSERT = "INSERT INTO cliente (nombre, fecha_afiliacion, telefono) VALUES (?,?,?)";
    private static final String SQL_UPDATE = "UPDATE cliente SET nombre = ?, fecha_afiliacion = ?, telefono = ? WHERE id_Cliente = ?";
    private static final String SQL_DELETE = "DELETE FROM cliente WHERE id_Cliente = ?";
    
    public List<Clientes> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Clientes cliente = null;
        List<Clientes> clientes = new ArrayList<>();
        
        try {
            
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                int id_Cliente = rs.getInt("id_Cliente");
                String nombre = rs.getString("nombre");
                String fecha_afiliacion = rs.getString("fecha_afiliacion");
                String telefono = rs.getString("telefono");
                
                cliente = new Clientes(id_Cliente, nombre, fecha_afiliacion, telefono);
                System.out.println(cliente);
                
                clientes.add(cliente);
            }
            
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
        return clientes;
    }
    
    public Clientes buscar(Clientes cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, cliente.getId_Cliente());
            rs = stmt.executeQuery();
            
            rs.next();
            int id_Cliente = rs.getInt("id_Cliente");
            String nombre = rs.getString("nombre");
            String fecha_afiliacion = rs.getString("fecha_afiliacion");
            String telefono = rs.getString("telefono");
            
            cliente.setId_Cliente(id_Cliente);
            cliente.setNombre(nombre);
            cliente.setFecha_afiliacion(fecha_afiliacion);
            cliente.setTelefono(telefono);
            
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
        return cliente;
    }
    
    public int insertar(Clientes cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        int registros = 0;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getFecha_afiliacion());
            stmt.setString(3, cliente.getTelefono());
            
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int actualizar(Clientes cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        int registros = 0;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getFecha_afiliacion());
            stmt.setString(3, cliente.getTelefono());
            stmt.setInt(4, cliente.getId_Cliente());
            
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int eliminar(Clientes cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        int registros = 0;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cliente.getId_Cliente());
            
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
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
