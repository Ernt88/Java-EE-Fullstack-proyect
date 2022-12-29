/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import static datos.conexion.close;
import static datos.conexion.getConnection;
import domain.Sucursales;
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
public class SucursalesDAO {

    private static final String SQL_SELECT = "SELECT id_sucursal, nombre_sucursal, ubicacion, id_trabajador_encargado, cantidad_empleados FROM sucursal";
    private static final String SQL_SELECT_BY_ID = "SELECT id_sucursal, nombre_sucursal, ubicacion, id_trabajador_encargado, cantidad_empleados FROM sucursal WHERE id_sucursal = ?";
    private static final String SQL_INSERT = "INSERT INTO sucursal (nombre_sucursal, ubicacion, id_trabajador_encargado, cantidad_empleados) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE sucursal SET nombre_sucursal = ?, ubicacion = ?, id_trabajador_encargado = ?, cantidad_empleados = ? WHERE id_sucursal = ?";
    private static final String SQL_DELETE = "DELETE FROM sucursal WHERE id_sucursal = ?";

    public List<Sucursales> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Sucursales sucursal = null;
        List<Sucursales> sucur = new ArrayList<>();

        try {

            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {

                int id_sucursal = rs.getInt("id_sucursal");
                String nombre_sucursal = rs.getString("nombre_sucursal");
                String ubicacion = rs.getString("ubicacion");
                int id_trabajador_encargado = rs.getInt("id_trabajador_encargado");
                int cantidad_empleados = rs.getInt("cantidad_empleados");

                sucursal = new Sucursales(id_sucursal, nombre_sucursal, ubicacion, id_trabajador_encargado, cantidad_empleados);
                System.out.println(sucursal);

                sucur.add(sucursal);
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
        return sucur;
    }

    public Sucursales buscar(Sucursales sucursal) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, sucursal.getId_sucursal());
            rs = stmt.executeQuery();

            rs.next();
            int id_sucursal = rs.getInt("id_sucursal");
            String nombre_sucursal = rs.getString("nombre_sucursal");
            String ubicacion = rs.getString("ubicacion");
            int id_trabajador_encargado = rs.getInt("id_trabajador_encargado");
            int cantidad_empleados = rs.getInt("cantidad_empleados");

            sucursal.setId_sucursal(id_sucursal);
            sucursal.setNombre_sucursal(nombre_sucursal);
            sucursal.setUbicacion(ubicacion);
            sucursal.setId_trabajador_encargado(id_trabajador_encargado);
            sucursal.setCantidad_empleados(cantidad_empleados);

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
        return sucursal;
    }

    public int insertar(Sucursales sucursal) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, sucursal.getNombre_sucursal());
            stmt.setString(2, sucursal.getUbicacion());
            stmt.setInt(3, sucursal.getId_trabajador_encargado());
            stmt.setInt(4, sucursal.getCantidad_empleados());

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

    public int actualizar(Sucursales sucursal) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, sucursal.getNombre_sucursal());
            stmt.setString(2, sucursal.getUbicacion());
            stmt.setInt(3, sucursal.getId_trabajador_encargado());
            stmt.setInt(4, sucursal.getCantidad_empleados());
            stmt.setInt(5, sucursal.getId_sucursal());

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

    public int eliminar(Sucursales sucursal) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, sucursal.getId_sucursal());

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
