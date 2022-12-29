/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import static datos.conexion.close;
import static datos.conexion.getConnection;
import domain.Trabajadores;
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
public class TrabajadoresDAO {

    private static final String SQL_SELECT = "SELECT id_trabajador, nombre, id_sucursal, telefono, n_afiliacion_imss FROM trabajador";
    private static final String SQL_SELECT_BY_ID = "SELECT id_trabajador, nombre, id_sucursal, telefono, n_afiliacion_imss FROM trabajador WHERE id_trabajador = ?";
    private static final String SQL_INSERT = "INSERT INTO trabajador (nombre, id_sucursal, telefono, n_afiliacion_imss) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE trabajador SET nombre = ?, id_sucursal = ?, telefono = ?, n_afiliacion_imss = ? WHERE id_trabajador = ?";
    private static final String SQL_DELETE = "DELETE FROM trabajador WHERE id_trabajador = ?";

    public List<Trabajadores> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Trabajadores trabajador = null;
        List<Trabajadores> trabaj = new ArrayList<>();

        try {

            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {

                int id_trabajador = rs.getInt("id_trabajador");
                String nombre = rs.getString("nombre");
                int id_sucursal = rs.getInt("id_sucursal");
                String telefono = rs.getString("telefono");
                String n_afiliacion_imss = rs.getString("n_afiliacion_imss");

                trabajador = new Trabajadores(id_trabajador, nombre, id_sucursal, telefono, n_afiliacion_imss);
                System.out.println(trabajador);

                trabaj.add(trabajador);
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
        return trabaj;
    }

    public Trabajadores buscar(Trabajadores trabajador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, trabajador.getId_trabajador());
            rs = stmt.executeQuery();

            rs.next();
            int id_trabajador = rs.getInt("id_trabajador");
            String nombre = rs.getString("nombre");
            int id_sucursal = rs.getInt("id_sucursal");
            String telefono = rs.getString("telefono");
            String n_afiliacion_imss = rs.getString("n_afiliacion_imss");

            trabajador.setId_trabajador(id_trabajador);
            trabajador.setNombre(nombre);
            trabajador.setId_sucursal(id_sucursal);
            trabajador.setTelefono(telefono);
            trabajador.setN_afiliacion_imss(n_afiliacion_imss);

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
        return trabajador;
    }

    public int insertar(Trabajadores trabajador) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, trabajador.getNombre());
            stmt.setInt(2, trabajador.getId_sucursal());
            stmt.setString(3, trabajador.getTelefono());
            stmt.setString(4, trabajador.getN_afiliacion_imss());

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

    public int actualizar(Trabajadores trabajador) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, trabajador.getNombre());
            stmt.setInt(2, trabajador.getId_sucursal());
            stmt.setString(3, trabajador.getTelefono());
            stmt.setString(4, trabajador.getN_afiliacion_imss());
            stmt.setInt(5, trabajador.getId_trabajador());

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

    public int eliminar(Trabajadores proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, proveedor.getId_trabajador());

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
